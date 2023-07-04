package med.voll.api.dtos;

import jakarta.validation.constraints.NotNull;
import med.voll.api.entidades.MotivoCancelamento;

public record DtoCancelarConsulta(
        @NotNull
        MotivoCancelamento motivo) {
}
