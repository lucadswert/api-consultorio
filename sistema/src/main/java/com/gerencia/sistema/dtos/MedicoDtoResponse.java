package com.gerencia.sistema.dtos;

import com.gerencia.sistema.entidades.Medico;
import com.gerencia.sistema.entidades.Especialidade;

public record MedicoDtoResponse(String nome, String email, String CREA, Especialidade especialidade) {
    public MedicoDtoResponse(Medico medico){
        this(medico.getNome(), medico.getEmail(), medico.getCREA(), medico.getEspecialidade());
    }
}
