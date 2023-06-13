package com.gerencia.sistema.servicos;

import com.gerencia.sistema.dtos.MedicoDtoRequest;
import com.gerencia.sistema.dtos.MedicoDtoResponse;
import com.gerencia.sistema.dtos.PacienteDtoRequest;
import com.gerencia.sistema.dtos.PacienteDtoResponse;
import com.gerencia.sistema.entidades.Medico;
import com.gerencia.sistema.entidades.Paciente;
import com.gerencia.sistema.repositorios.MedicoRepository;
import com.gerencia.sistema.repositorios.PacienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PacienteService {
    @Autowired
    private PacienteRepository repository;
    
    public ResponseEntity<List<PacienteDtoResponse>> listar() {
        List<PacienteDtoResponse> lista = repository.findAll().stream().filter(paciente -> paciente.isAtivo() == true)
                .sorted((m1, m2) -> m1.getNome()
                        .compareToIgnoreCase(m2.getNome())).map(PacienteDtoResponse::new).collect(Collectors.toList());

        return new ResponseEntity<List<PacienteDtoResponse>>(lista, HttpStatus.OK);
    }

    public ResponseEntity<PacienteDtoResponse> adicionar(PacienteDtoRequest pacienteDtoRequest) {
        Paciente paciente = new Paciente(null, pacienteDtoRequest.nome(), pacienteDtoRequest.email(), pacienteDtoRequest.CPF(), pacienteDtoRequest.telefone(), pacienteDtoRequest.endereco(), true);
        repository.save(paciente);
        return new ResponseEntity<PacienteDtoResponse>(new PacienteDtoResponse(paciente), HttpStatus.CREATED);
    }

    public ResponseEntity<PacienteDtoResponse> atualizar(Long id, PacienteDtoRequest pacienteDtoRequest) {
        Optional<Paciente> op = this.repository.findById(id);
        if(op.isPresent()) {
            //Fiz o "bloqueio" de forma leiga, mas funciona. Acaba não lançando nenhuma exceção, mas não permite alterar - Se possível, elaborar algo mais bonito kkkkk
            Paciente paciente = new Paciente(null, pacienteDtoRequest.nome(), op.get().getEmail(), op.get().getCPF(), pacienteDtoRequest.telefone(), pacienteDtoRequest.endereco(), true);
            paciente.setId(id);
            this.repository.save(paciente);
            return new ResponseEntity<PacienteDtoResponse>(new PacienteDtoResponse(paciente), HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
    public ResponseEntity<PacienteDtoResponse> apagar(Long id) {
        Optional<Paciente> op=this.repository.findById(id);
        if(op.isPresent()) {
            Paciente paciente=op.get();
            paciente.setAtivo(false);
            return new ResponseEntity<PacienteDtoResponse>(new PacienteDtoResponse(paciente), HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
