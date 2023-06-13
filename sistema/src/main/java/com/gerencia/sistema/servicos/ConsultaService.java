package com.gerencia.sistema.servicos;

import com.gerencia.sistema.dtos.*;
import com.gerencia.sistema.entidades.Consulta;
import com.gerencia.sistema.entidades.Medico;
import com.gerencia.sistema.entidades.Paciente;
import com.gerencia.sistema.repositorios.ConsultaRepository;
import com.gerencia.sistema.repositorios.MedicoRepository;
import com.gerencia.sistema.repositorios.PacienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ConsultaService {
    @Autowired
    private ConsultaRepository repository;
    @Autowired
    private MedicoRepository medicoRepository;
    @Autowired
    private PacienteRepository pacienteRepository;

    public ResponseEntity<ConsultaDtoResponse> adicionar(ConsultaDtoRequest consultaDtoRequest) {
        var medico = medicoRepository.findById(consultaDtoRequest.engenheiroId());
        var paciente = pacienteRepository.findById(consultaDtoRequest.projetoId());

        if (medico.isPresent() && paciente.isPresent()) {
            var atuacao = new Consulta();

            repository.save(atuacao);
            return new ResponseEntity<ConsultaDtoResponse>(new ConsultaDtoResponse(atuacao), HttpStatus.OK);
        }

        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    public ResponseEntity<ConsultaDtoResponse> apagar(Long id) {
        Optional<Consulta> op=this.repository.findById(id);
        if(op.isPresent()) {
            Consulta consulta=op.get();
            this.repository.deleteById(id);
            return new ResponseEntity<ConsultaDtoResponse>(new ConsultaDtoResponse(consulta), HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
