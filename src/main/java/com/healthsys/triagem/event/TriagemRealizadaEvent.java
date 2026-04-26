package com.healthsys.triagem.event;

public record TriagemRealizadaEvent (
        Long pacienteId,
        String nome,
        String nivelRisco
) {}
