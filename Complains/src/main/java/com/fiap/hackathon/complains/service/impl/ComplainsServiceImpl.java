package com.fiap.hackathon.complains.service.impl;

import java.io.File;
import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.model.PutObjectResult;
import com.fiap.hackathon.complains.exception.ResourceNotFoundException;
import com.fiap.hackathon.complains.helper.ComplainsHelper;
import com.fiap.hackathon.complains.sqs.MessageServiceProducer;
import com.fiap.hackathon.complains.util.JsonUtil;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.fiap.hackathon.complains.model.dto.ComplainsDTO;
import com.fiap.hackathon.complains.model.dto.NovaComplainDTO;
import com.fiap.hackathon.complains.model.entity.Complains;
import com.fiap.hackathon.complains.repository.ComplainsRepository;
import com.fiap.hackathon.complains.service.ComplainsService;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.multipart.MultipartFile;

import static com.fiap.hackathon.complains.helper.ComplainsHelper.closeComplainsBuilder;
import static com.fiap.hackathon.complains.helper.ComplainsHelper.complainsDTOBuilder;
import static com.fiap.hackathon.complains.helper.ComplainsHelper.complainsUpdateBuilder;
import static com.fiap.hackathon.complains.helper.ComplainsHelper.createComplainsBuilder;

@Service
@Slf4j
public class ComplainsServiceImpl implements ComplainsService {

    private ComplainsRepository complainsRepository;
    private MessageServiceProducer messageServiceProducer;
    private AmazonS3 amazonS3;
    private String queueName;

    @Autowired
    public ComplainsServiceImpl(ComplainsRepository complainsRepository, MessageServiceProducer messageServiceProducer, AmazonS3 amazonS3, @Value("${amazon.queue.complains}") String queueName) {
        this.complainsRepository = complainsRepository;
        this.messageServiceProducer = messageServiceProducer;
        this.amazonS3 = amazonS3;
        this.queueName = queueName;
    }

    @Override
    public List<ComplainsDTO> listarComplains() {
        List<Complains> complainsList;
        complainsList = (List<Complains>) complainsRepository.findAll();
        return complainsList
                .stream()
                .map(ComplainsHelper::complainsDTOBuilder)
                .collect(Collectors.toList());
    }

    @Override
    public ComplainsDTO buscarComplainPorId(String id) {
        Complains complains = complainsRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException(HttpStatus.NOT_FOUND, "Id Not found!"));
        return complainsDTOBuilder(complains);
    }

    @Override
    public ComplainsDTO criar(MultipartFile evidencia, NovaComplainDTO novaComplainDTO) {
        Complains savedComplain = complainsRepository.save(createComplainsBuilder(novaComplainDTO));

        PutObjectResult putObjectResult = amazonS3.putObject("complain-document", evidencia.getOriginalFilename(), convertMultiPartFileToFile(evidencia));
        messageServiceProducer.sentToQueue(queueName, JsonUtil.writeValueAsString(savedComplain));

        log.info("***** COMPLAIN CREATED AND MESSAGE SENT TO QUEUE:  " + queueName + ", COMPLAIN USER: " + novaComplainDTO.getUsuario()
                + ", COMPLAIN ID: " + savedComplain.getId());

        return complainsDTOBuilder(savedComplain);
    }

    @Override
    public ComplainsDTO atualizar(String id, NovaComplainDTO novaComplainDTO) {
        Complains complains = complainsRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException(HttpStatus.NOT_FOUND, "Id Not found!"));
        Complains complainsUpdated = complainsUpdateBuilder(complains, novaComplainDTO);
        Complains updatedComplain = complainsRepository.save(complainsUpdated);

        messageServiceProducer.sentToQueue(queueName, JsonUtil.writeValueAsString(updatedComplain));
        log.info("***** COMPLAIN CREATED AND MESSAGE SENT TO QUEUE:  " + queueName + ", COMPLAIN USER: " + novaComplainDTO.getUsuario()
                + ", COMPLAIN ID: " + updatedComplain.getId());

        return complainsDTOBuilder(updatedComplain);
    }

    @Override
    public void deletarComplain(String id) {
        Complains complains = complainsRepository.findById(id).orElseThrow(() -> new HttpClientErrorException(HttpStatus.NOT_FOUND, "Id Not found!"));

        if (Objects.isNull(complains)) {
            throw new HttpClientErrorException(HttpStatus.NOT_FOUND, "Id Not found!");
        }

        complainsRepository.deleteById(id);
    }

    @Override
    public void fecharComplain(ComplainsDTO complainsDTO) {
        if (Objects.isNull(complainsDTO)) {
            throw new RuntimeException("Object is null!");
        }

        log.info("**** COMPLAIM UPDATED AND CLOSED!!! ****");

        complainsRepository.save(closeComplainsBuilder(complainsDTO));
    }

    private File convertMultiPartFileToFile(MultipartFile file){
        var newFile = new File(file.getOriginalFilename());

        try {
            FileUtils.writeByteArrayToFile(newFile, file.getBytes());
            return newFile;
        } catch (IOException ex) {
            throw new RuntimeException("erro escrevendo no arquivo");
        }
    }
}
