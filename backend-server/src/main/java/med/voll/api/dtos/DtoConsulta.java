package med.voll.api.dtos;

import med.voll.api.entidades.Consulta;

import java.time.LocalDateTime;

public record DtoConsulta(Long id, Long idMedico, Long idPaciente, LocalDateTime data) {
    public DtoConsulta(Consulta consulta) {
        this(consulta.getId(), consulta.getMedico().getId(), consulta.getPaciente().getId(), consulta.getData());
    }
}
