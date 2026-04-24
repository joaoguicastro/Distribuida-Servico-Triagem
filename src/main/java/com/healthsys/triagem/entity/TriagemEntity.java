package com.healthsys.triagem.entity;

import com.healthsys.triagem.enums.NivelRisco;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "TB_TRI")
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
@Data
public class TriagemEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_TRI")
    private Long id;

    private Long pacienteId;

    @Enumerated(EnumType.STRING)
    @Column(name = "NVL_RSC")
    private NivelRisco nivelRisco;

    @Column(name = "STS_TRI")
    private String status;
}
