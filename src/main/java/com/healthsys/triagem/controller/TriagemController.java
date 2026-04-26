package com.healthsys.triagem.controller;

import com.healthsys.triagem.entity.TriagemEntity;
import com.healthsys.triagem.repository.TriagemRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/triagem")
public class TriagemController {

    private final TriagemRepository triagemRepository;

    public TriagemController(TriagemRepository triagemRepository) {
        this.triagemRepository = triagemRepository;
    }

    @GetMapping
    public ResponseEntity<List<TriagemEntity>> listarTodas() {
        return ResponseEntity.ok(triagemRepository.findAll());
    }

    @GetMapping("/paciente/{pacienteId}")
    public ResponseEntity<List<TriagemEntity>> buscarPorPaciente(@PathVariable Long pacienteId) {
        return ResponseEntity.ok(triagemRepository.findByPacienteId(pacienteId));
    }
}