package med.voll.api.dtos;

import jakarta.validation.constraints.NotNull;
import med.voll.api.dtos.DtoEndereco;

public record DtoUpdatePaciente(
        String nome,
        String telefone,
        DtoEndereco endereco) {
}
