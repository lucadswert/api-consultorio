package com.gerencia.sistema.repositorios;

import com.gerencia.sistema.dtos.MedicoDtoResponse;
import com.gerencia.sistema.entidades.Medico;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MedicoRepository extends JpaRepository<Medico, Long> {
}
