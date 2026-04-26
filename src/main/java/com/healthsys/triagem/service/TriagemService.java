package com.healthsys.triagem.service;

import com.healthsys.triagem.event.TriagemRealizadaEvent;
import com.healthsys.triagem.producer.TriagemProducer;
import com.healthsys.triagem.repository.TriagemRepository;
import com.healthsys.triagem.entity.TriagemEntity;
import com.healthsys.triagem.enums.NivelRisco;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TriagemService {

    @Autowired
    private TriagemRepository triagemRepository;

    @Autowired
    private TriagemProducer triagemProducer;

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

        triagemProducer.enviarEvento(
                new TriagemRealizadaEvent(
                        pacienteId,
                        nome,
                        nivelRisco.name()
                )
        );

        return triagemRepository.save(triagem);

    }
}
