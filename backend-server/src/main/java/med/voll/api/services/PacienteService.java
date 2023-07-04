package med.voll.api.services;

import med.voll.api.dtos.DtoCadastroPaciente;
import med.voll.api.dtos.DtoIndexPaciente;
import med.voll.api.dtos.DtoListagemMedico;
import med.voll.api.dtos.DtoUpdatePaciente;
import med.voll.api.entidades.Paciente;
import med.voll.api.repositories.PacienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PacienteService {

    private final PacienteRepository pacienteRepository;

    @Autowired
    public PacienteService(PacienteRepository pacienteRepository) {
        this.pacienteRepository = pacienteRepository;
    }

    public ResponseEntity<DtoIndexPaciente> cadastrarPaciente(DtoCadastroPaciente dados) {
        Paciente paciente = new Paciente(dados);
        Paciente pacienteSalvo = pacienteRepository.save(paciente);
        return ResponseEntity.status(HttpStatus.CREATED).body(new DtoIndexPaciente(pacienteSalvo));
    }

    public ResponseEntity<DtoIndexPaciente> atualizarPaciente(Long id, DtoUpdatePaciente dados) {
        Optional<Paciente> optionalPaciente = pacienteRepository.findById(id);
        if (optionalPaciente.isPresent()) {
            Paciente paciente = optionalPaciente.get();
            paciente.atualizarInformacoes(dados);
            Paciente pacienteAtualizado = pacienteRepository.save(paciente);
            return ResponseEntity.ok(new DtoIndexPaciente(pacienteAtualizado));
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    public List<DtoIndexPaciente> listarPacientes(Pageable paginacao) {
        List<DtoIndexPaciente> lista = pacienteRepository.findAll().stream().filter(paciente -> paciente.getAtivo() == true)
                .sorted((m1, m2) -> m1.getNome()
                        .compareToIgnoreCase(m2.getNome())).map(DtoIndexPaciente::new).collect(Collectors.toList());
        return lista;
    }

    public ResponseEntity<DtoIndexPaciente> buscarPacientePorId(Long id) {
        Optional<Paciente> optionalPaciente = pacienteRepository.findById(id);
        if (optionalPaciente.isPresent()) {
            Paciente paciente = optionalPaciente.get();
            return ResponseEntity.ok(new DtoIndexPaciente(paciente));
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    public ResponseEntity<DtoIndexPaciente> apagarPaciente(Long id) {
        Optional<Paciente> optionalPaciente = pacienteRepository.findById(id);
        if (optionalPaciente.isPresent()) {
            Paciente paciente = optionalPaciente.get();
            paciente.excluir();
            pacienteRepository.save(paciente);
            return ResponseEntity.ok(new DtoIndexPaciente(paciente));
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
