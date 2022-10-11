package com.fiap.hackathon.complains.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.fiap.hackathon.complains.model.dto.ComplainsDTO;
import com.fiap.hackathon.complains.model.dto.NovaComplainDTO;
import com.fiap.hackathon.complains.service.ComplainsService;

@RestController
@RequestMapping("/complains")
public class ComplainsController {

    private ComplainsService complainsService;

    @Autowired
    public ComplainsController(ComplainsService complainsService) {
        this.complainsService = complainsService;
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

    @PostMapping(value = "/createComplain")
    public ResponseEntity<Void> createComplain(@RequestBody NovaComplainDTO newComplainDTO) {
        complainsService.criar(newComplainDTO);
        return new ResponseEntity<>(HttpStatus.CREATED);
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
