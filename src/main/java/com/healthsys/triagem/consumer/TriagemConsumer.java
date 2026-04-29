package com.healthsys.triagem.consumer;

import com.healthsys.triagem.event.PacienteCriadoEvent;
import com.healthsys.triagem.service.TriagemService;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class TriagemConsumer {

    @Autowired
    private TriagemService triagemService;

    @RabbitListener(queues = "paciente.queue")
    public void receberEvento (PacienteCriadoEvent eventCriado) {
        System.out.println("🔥 PROCESSANDO TRIAGEM ...");

        var resultado = triagemService.classificarRisco(eventCriado.getPacienteId(), eventCriado.getNome());

        System.out.println("Resultado: " + resultado.getNivelRisco());
    }
}
