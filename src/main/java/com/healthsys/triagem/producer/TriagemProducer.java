package com.healthsys.triagem.producer;

import com.healthsys.triagem.event.TriagemRealizadaEvent;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class TriagemProducer {

    private final RabbitTemplate rabbitTemplate;

    public TriagemProducer(RabbitTemplate rabbitTemplate,
                           Jackson2JsonMessageConverter messageConverter) {
        this.rabbitTemplate = rabbitTemplate;
        this.rabbitTemplate.setMessageConverter(messageConverter);
    }

    public void enviarEvento(TriagemRealizadaEvent event) {
        rabbitTemplate.convertAndSend(
                "triagem.exchange",
                "triagem.routing",
                event
        );
    }
}