package com.freteapi.repository;

import com.freteapi.model.Frete;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FreteRepository extends JpaRepository<Frete, Long> {
}
