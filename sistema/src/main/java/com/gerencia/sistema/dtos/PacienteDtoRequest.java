package com.gerencia.sistema.dtos;

import com.gerencia.sistema.entidades.Paciente;
import jakarta.validation.constraints.NotNull;

public record PacienteDtoRequest(@NotNull String nome, @NotNull String email, @NotNull String CPF, @NotNull String telefone, @NotNull String endereco, boolean ativo ) {
    public PacienteDtoRequest(Paciente paciente){
        this(paciente.getNome(), paciente.getEmail(), paciente.getCPF(), paciente.getTelefone(), paciente.getEndereco(), true);
    }
}
