package com.gerencia.sistema.dtos;

import com.gerencia.sistema.entidades.Consulta;
import com.gerencia.sistema.entidades.Medico;
import com.gerencia.sistema.entidades.Paciente;
import jakarta.validation.constraints.NotNull;

public record ConsultaDtoRequest(@NotNull Long engenheiroId, @NotNull Long projetoId, @NotNull String dataHora) {
    public ConsultaDtoRequest(Consulta consulta){
        this(consulta.getMedico().getId(), consulta.getPaciente().getId(), consulta.getDataHora());
    }
}
