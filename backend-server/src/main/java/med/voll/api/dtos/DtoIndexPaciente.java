package med.voll.api.dtos;

import med.voll.api.entidades.Paciente;

public record DtoIndexPaciente(Long id, String nome, String email, String cpf) {

    public DtoIndexPaciente(Paciente paciente) {
        this(paciente.getId(), paciente.getNome(), paciente.getEmail(), paciente.getCpf());
    }

}
