package com.healthsys.triagem;

import com.healthsys.triagem.entity.TriagemEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TriagemRepository extends JpaRepository<TriagemEntity, Long> {
}
