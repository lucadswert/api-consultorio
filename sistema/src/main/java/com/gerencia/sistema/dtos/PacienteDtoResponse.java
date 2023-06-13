package com.gerencia.sistema.dtos;

import com.gerencia.sistema.entidades.Paciente;

public record PacienteDtoResponse(String nome, String email, String CPF) {
    public PacienteDtoResponse(Paciente paciente){
        this(paciente.getNome(), paciente.getEmail(), paciente.getCPF());
    }
}
