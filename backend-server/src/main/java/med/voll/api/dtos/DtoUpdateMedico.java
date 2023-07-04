package med.voll.api.dtos;

import jakarta.validation.constraints.NotNull;

public record DtoUpdateMedico(
        String nome,
        String telefone,
        DtoEndereco endereco) {
}
