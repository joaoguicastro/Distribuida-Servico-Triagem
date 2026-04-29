package com.healthsys.triagem.repository;

import com.healthsys.triagem.entity.TriagemEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TriagemRepository extends JpaRepository<TriagemEntity, Long> {
    List<TriagemEntity> findByPacienteId(Long pacienteId);
}
