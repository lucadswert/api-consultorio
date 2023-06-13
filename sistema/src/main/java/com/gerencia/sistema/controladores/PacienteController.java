package com.gerencia.sistema.controladores;

import com.gerencia.sistema.dtos.MedicoDtoRequest;
import com.gerencia.sistema.dtos.MedicoDtoResponse;
import com.gerencia.sistema.dtos.PacienteDtoRequest;
import com.gerencia.sistema.dtos.PacienteDtoResponse;
import com.gerencia.sistema.servicos.PacienteService;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/projetos")
public class PacienteController {

    @Autowired
    PacienteService service;

    @GetMapping
    public ResponseEntity<List<PacienteDtoResponse>> listar (){
        return service.listar();
    }
    @PostMapping
    public ResponseEntity<PacienteDtoResponse> adicionar (@Valid @RequestBody PacienteDtoRequest pacienteDtoRequest){
        return service.adicionar(pacienteDtoRequest);
    }

    @PutMapping("/{id}")
    @Transactional
    public ResponseEntity<PacienteDtoResponse> atualizar (@PathVariable Long id,@Valid @RequestBody PacienteDtoRequest pacienteDtoRequest){
        return service.atualizar(id, pacienteDtoRequest);
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity<PacienteDtoResponse> apagar (@PathVariable Long id){
        return service.apagar(id);
    }
}
