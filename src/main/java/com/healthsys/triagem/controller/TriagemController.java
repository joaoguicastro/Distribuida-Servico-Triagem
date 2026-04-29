package com.healthsys.triagem.controller;

import com.healthsys.triagem.entity.TriagemEntity;
import com.healthsys.triagem.repository.TriagemRepository;
import com.healthsys.triagem.service.TriagemService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/triagem")
public class TriagemController {

    private final TriagemRepository triagemRepository;
    private final TriagemService triagemService;

    public TriagemController(TriagemRepository triagemRepository, TriagemService triagemService) {
        this.triagemRepository = triagemRepository;
        this.triagemService = triagemService;
    }

    @GetMapping
    public ResponseEntity<List<TriagemEntity>> listarTodas() {
        return ResponseEntity.ok(triagemRepository.findAll());
    }

    @GetMapping("/paciente/{pacienteId}")
    public ResponseEntity<List<TriagemEntity>> buscarPorPaciente(@PathVariable Long pacienteId) {
        return ResponseEntity.ok(triagemRepository.findByPacienteId(pacienteId));
    }

    /**
     * Endpoint chamado pelo front-end para registrar triagem manualmente.
     * Recebe pacienteId e nome, classifica o risco e persiste.
     */
    @PostMapping
    public ResponseEntity<TriagemEntity> realizarTriagem(@RequestBody Map<String, Object> body) {
        Long pacienteId = Long.valueOf(body.get("pacienteId").toString());
        String nome = body.getOrDefault("nome", "Paciente").toString();
        TriagemEntity triagem = triagemService.classificarRisco(pacienteId, nome);
        return ResponseEntity.status(HttpStatus.CREATED).body(triagem);
    }
}