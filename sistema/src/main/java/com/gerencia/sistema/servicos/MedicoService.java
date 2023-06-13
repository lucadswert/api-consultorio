package com.gerencia.sistema.servicos;

import com.gerencia.sistema.dtos.MedicoDtoRequest;
import com.gerencia.sistema.dtos.MedicoDtoResponse;
import com.gerencia.sistema.dtos.PacienteDtoResponse;
import com.gerencia.sistema.entidades.Consulta;
import com.gerencia.sistema.entidades.Medico;
import com.gerencia.sistema.entidades.Paciente;
import com.gerencia.sistema.repositorios.ConsultaRepository;
import com.gerencia.sistema.repositorios.MedicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class MedicoService {
    @Autowired
    private MedicoRepository repository;

    @Autowired
    private ConsultaRepository consultaRepository;
    
    public ResponseEntity<List<MedicoDtoResponse>> listar() {
        List<MedicoDtoResponse> lista = repository.findAll().stream().filter(medico -> medico.isAtivo() == true)
                .sorted((m1, m2) -> m1.getNome()
                        .compareToIgnoreCase(m2.getNome())).map(MedicoDtoResponse::new).collect(Collectors.toList());

        return new ResponseEntity<List<MedicoDtoResponse>>(lista, HttpStatus.OK);
    }

    public ResponseEntity<MedicoDtoResponse> adicionar(MedicoDtoRequest medicoDtoRequest) {
        Medico medico = new Medico(null, medicoDtoRequest.nome(), medicoDtoRequest.CREA(), medicoDtoRequest.email(), medicoDtoRequest.telefone(), medicoDtoRequest.endereco(), medicoDtoRequest.especialidade(), true);
        repository.save(medico);
        return new ResponseEntity<MedicoDtoResponse>(new MedicoDtoResponse(medico), HttpStatus.CREATED);
    }

    public ResponseEntity<MedicoDtoResponse> atualizar(Long id, MedicoDtoRequest medicoDtoRequest) {
        Optional<Medico> op=this.repository.findById(id);
        if(op.isPresent()) {
            //Fiz o "bloqueio" de forma leiga, mas funciona. Acaba não lançando nenhuma exceção, mas não permite alterar - Se possível, elaborar algo mais bonito kkkkk
            Medico medico = new Medico(null, medicoDtoRequest.nome(), op.get().getCREA(), op.get().getEmail(), medicoDtoRequest.telefone(), medicoDtoRequest.endereco(), op.get().getEspecialidade(), true);
            medico.setId(id);
            this.repository.save(medico);
            return new ResponseEntity<MedicoDtoResponse>(new MedicoDtoResponse(medico), HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
    public ResponseEntity<MedicoDtoResponse> apagar(Long id) {
        Optional<Medico> op=this.repository.findById(id);

        if(op.isPresent()) {
            Medico medico=op.get();
            medico.setAtivo(false);
            repository.save(medico);
            return new ResponseEntity<MedicoDtoResponse>(new MedicoDtoResponse(medico), HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
