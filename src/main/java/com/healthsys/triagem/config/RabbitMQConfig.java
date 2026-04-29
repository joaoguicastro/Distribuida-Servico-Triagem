package com.healthsys.triagem.config;

import org.springframework.amqp.core.*;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMQConfig {

    public static final String TRIAGEM_EXCHANGE    = "triagem.exchange";
    public static final String TRIAGEM_QUEUE       = "triagem.queue";
    public static final String TRIAGEM_ROUTING_KEY = "triagem.routing";

    public static final String PACIENTE_EXCHANGE    = "paciente.exchange";
    public static final String PACIENTE_QUEUE       = "paciente.queue";
    public static final String PACIENTE_ROUTING_KEY = "paciente.criado";

    @Bean
    public TopicExchange triagemExchange() {
        return new TopicExchange(TRIAGEM_EXCHANGE);
    }

    @Bean
    public Queue triagemQueue() {
        return new Queue(TRIAGEM_QUEUE, true);
    }

    @Bean
    public Binding triagemBinding() {
        return BindingBuilder
                .bind(triagemQueue())
                .to(triagemExchange())
                .with(TRIAGEM_ROUTING_KEY);
    }

    @Bean
    public TopicExchange pacienteExchange() {
        return new TopicExchange(PACIENTE_EXCHANGE);
    }

    @Bean
    public Queue pacienteQueue() {
        return new Queue(PACIENTE_QUEUE, true);
    }

    @Bean
    public Binding pacienteBinding() {
        return BindingBuilder
                .bind(pacienteQueue())
                .to(pacienteExchange())
                .with(PACIENTE_ROUTING_KEY);
    }

    @Bean
    public Jackson2JsonMessageConverter messageConverter() {
        return new Jackson2JsonMessageConverter();
    }
}