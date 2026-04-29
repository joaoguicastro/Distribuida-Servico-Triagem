package com.healthsys.triagem.consumer;

import com.healthsys.triagem.event.PacienteCriadoEvent;
import com.healthsys.triagem.service.TriagemService;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class PacienteCriadoConsumer {

    @Autowired
    private TriagemService triagemService;

    @RabbitListener(queues = "paciente.queue")
    public void receberPacienteCriado(PacienteCriadoEvent event) {
        System.out.println("📥 Evento recebido: paciente criado - ID: " + event.getPacienteId() + " | Nome: " + event.getNome());
        triagemService.classificarRisco(event.getPacienteId(), event.getNome());
    }
}
