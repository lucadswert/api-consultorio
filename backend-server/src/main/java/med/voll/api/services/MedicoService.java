package med.voll.api.services;

import med.voll.api.dtos.DtoCadastroMedico;
import med.voll.api.dtos.DtoListagemMedico;
import med.voll.api.dtos.DtoUpdateMedico;
import med.voll.api.entidades.Endereco;
import med.voll.api.entidades.Medico;
import med.voll.api.repositories.MedicoRepository;
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
public class MedicoService {

    private final MedicoRepository medicoRepository;

    @Autowired
    public MedicoService(MedicoRepository medicoRepository) {
        this.medicoRepository = medicoRepository;
    }

    public ResponseEntity<DtoListagemMedico> criarMedico(DtoCadastroMedico dados) {
        Medico medico = new Medico(dados);
        Medico medicoSalvo = medicoRepository.save(medico);
        return ResponseEntity.status(HttpStatus.CREATED).body(new DtoListagemMedico(medicoSalvo));
    }

    public ResponseEntity<DtoListagemMedico> atualizarMedico(Long id, DtoUpdateMedico dados) {
        Optional<Medico> optionalMedico = medicoRepository.findById(id);
        if (optionalMedico.isPresent()) {
            Medico medico = optionalMedico.get();
            if (dados.nome() != null) {
                medico.setNome(dados.nome());
            }
            if (dados.telefone() != null) {
                medico.setTelefone(dados.telefone());
            }
            if (dados.endereco() != null) {
                Endereco endereco = new Endereco(dados.endereco());
                medico.setEndereco(endereco);
            }
            Medico medicoAtualizado = medicoRepository.save(medico);
            return ResponseEntity.ok(new DtoListagemMedico(medicoAtualizado));
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    public List<DtoListagemMedico> listarMedicos(Pageable paginacao) {
        List<DtoListagemMedico> lista = medicoRepository.findAll().stream().filter(medico -> medico.getAtivo() == true)
                .sorted((m1, m2) -> m1.getNome()
                        .compareToIgnoreCase(m2.getNome())).map(DtoListagemMedico::new).collect(Collectors.toList());
        return lista;
    }

    public ResponseEntity<DtoListagemMedico> buscarMedicoPorId(Long id) {
        Optional<Medico> optionalMedico = medicoRepository.findById(id);
        if (optionalMedico.isPresent()) {
            Medico medico = optionalMedico.get();
            return ResponseEntity.ok(new DtoListagemMedico(medico));
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    public ResponseEntity<DtoListagemMedico> apagarMedico(Long id) {
        Optional<Medico> optionalMedico = medicoRepository.findById(id);
        if (optionalMedico.isPresent()) {
            Medico medico = optionalMedico.get();
            medico.setAtivo(false);
            medicoRepository.save(medico);
            return ResponseEntity.ok(new DtoListagemMedico(medico));
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
