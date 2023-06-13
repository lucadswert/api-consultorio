package com.gerencia.sistema.dtos;

import com.gerencia.sistema.entidades.Consulta;
import com.gerencia.sistema.entidades.Medico;
import com.gerencia.sistema.entidades.Paciente;
import jakarta.validation.constraints.NotNull;

public record ConsultaDtoResponse(MedicoDtoResponse engenheiro, PacienteDtoResponse projeto, String dataHora) {
    public ConsultaDtoResponse(Consulta consulta){
        this(new MedicoDtoResponse(consulta.getMedico()), new PacienteDtoResponse(consulta.getPaciente()), consulta.getDataHora());
    }
}
