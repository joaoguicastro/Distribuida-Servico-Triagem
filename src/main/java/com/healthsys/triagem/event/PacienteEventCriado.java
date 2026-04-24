package com.healthsys.triagem.event;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder(toBuilder = true)
public class PacienteEventCriado {

    private Long pacienteId;
    private Long usuarioId;
    private String nome;
}
