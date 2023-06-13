package com.gerencia.sistema.repositorios;

import com.gerencia.sistema.dtos.PacienteDtoResponse;
import com.gerencia.sistema.entidades.Paciente;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PacienteRepository extends JpaRepository<Paciente, Long> {
}
