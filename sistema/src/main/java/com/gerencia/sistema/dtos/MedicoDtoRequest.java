package com.gerencia.sistema.dtos;

import com.gerencia.sistema.entidades.Medico;
import com.gerencia.sistema.entidades.Especialidade;
import jakarta.validation.constraints.NotNull;

public record MedicoDtoRequest(@NotNull String nome, @NotNull String email, @NotNull String CREA, @NotNull String telefone, @NotNull String endereco, @NotNull Especialidade especialidade, boolean ativo) {
    public MedicoDtoRequest(Medico medico){

        this(medico.getNome(), medico.getCREA(), medico.getEmail(), medico.getTelefone(), medico.getEndereco(), medico.getEspecialidade(), true);
    }
}
