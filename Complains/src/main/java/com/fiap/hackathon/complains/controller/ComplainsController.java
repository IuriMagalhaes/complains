package com.fiap.hackathon.complains.controller;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

import com.amazonaws.services.s3.AmazonS3;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.fiap.hackathon.complains.model.dto.ComplainsDTO;
import com.fiap.hackathon.complains.model.dto.NovaComplainDTO;
import com.fiap.hackathon.complains.service.ComplainsService;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/complains")
public class ComplainsController {

    private ComplainsService complainsService;

    private AmazonS3 amazonS3;

    @Autowired
    public ComplainsController(ComplainsService complainsService, AmazonS3 amazonS3) {
        this.complainsService = complainsService;
        this.amazonS3 = amazonS3;
    }


    @GetMapping(value = "/listar")
    public ResponseEntity<List<ComplainsDTO>> listarReclamacoes() {
        List<ComplainsDTO> complainsDTOList = complainsService.listarComplains();
        return new ResponseEntity<>(complainsDTOList, HttpStatus.OK);
    }

    @GetMapping("/getById/{id}")
    public ResponseEntity<ComplainsDTO> getComplainsById(@PathVariable(name = "id") String id) {
        ComplainsDTO complainsDTO = complainsService.buscarComplainPorId(id);
        return new ResponseEntity<>(complainsDTO, HttpStatus.OK);
    }

    @PostMapping(value = "/createComplain", consumes = {MediaType.MULTIPART_FORM_DATA_VALUE})
    public ResponseEntity<ComplainsDTO> createComplain(@RequestPart("evidencia") MultipartFile document, @RequestPart("body") NovaComplainDTO newComplainDTO) throws IOException {
        ComplainsDTO complainsDTO = complainsService.criarComEvidencia(document, newComplainDTO);

        return new ResponseEntity<>(complainsDTO, HttpStatus.CREATED);
    }
    
    @PostMapping(value = "/createComplain")
    public ResponseEntity<ComplainsDTO> createComplain(@RequestBody NovaComplainDTO newComplainDTO) {
        ComplainsDTO complainsDTO = complainsService.criar(newComplainDTO);
        return new ResponseEntity<>(complainsDTO, HttpStatus.CREATED);
    }


    @PutMapping("/updateComplain/{id}")
    public ResponseEntity<ComplainsDTO> updateComplain(@RequestBody NovaComplainDTO novaComplainDTO, @PathVariable String id) {
        ComplainsDTO complainsDTO = complainsService.atualizar(id, novaComplainDTO);
        return new ResponseEntity<>(complainsDTO, HttpStatus.ACCEPTED);
    }

    @DeleteMapping("/deleteComplain/{id}")
    public ResponseEntity<Void> deleteComplain(@PathVariable String id) {
        complainsService.deletarComplain(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
