package com.healthsys.triagem.service;

import com.healthsys.triagem.TriagemRepository;
import com.healthsys.triagem.entity.TriagemEntity;
import com.healthsys.triagem.enums.NivelRisco;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TriagemService {

    @Autowired
    private TriagemRepository triagemRepository;

    public TriagemEntity classificarRisco (Long pacienteId, String nome) {
        NivelRisco nivelRisco;

        if (nome.toLowerCase().contains("dor")) {
            nivelRisco = NivelRisco.ALTO;
        } else if (nome.length() > 5) {
            nivelRisco = NivelRisco.MEDIO;
        } else {
            nivelRisco = NivelRisco.BAIXO;
        }

        TriagemEntity triagem = TriagemEntity.builder()
                .pacienteId(pacienteId)
                .nivelRisco(nivelRisco)
                .build();

        return triagemRepository.save(triagem);

    }
}
