package com.gerencia.sistema.controladores;

import com.gerencia.sistema.dtos.ConsultaDtoRequest;
import com.gerencia.sistema.dtos.ConsultaDtoResponse;
import com.gerencia.sistema.dtos.MedicoDtoRequest;
import com.gerencia.sistema.dtos.MedicoDtoResponse;
import com.gerencia.sistema.servicos.MedicoService;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/engenheiros")
public class MedicoController {
    @Autowired
    private MedicoService service;

    @GetMapping
    public ResponseEntity<List<MedicoDtoResponse>> listar (){
        return service.listar();
    }
    @PostMapping
    public ResponseEntity<MedicoDtoResponse> adicionar (@Valid @RequestBody MedicoDtoRequest medicoDtoRequest){
        return service.adicionar(medicoDtoRequest);
    }

    @PutMapping("/{id}")
    @Transactional
    public ResponseEntity<MedicoDtoResponse> atualizar (@PathVariable Long id, @Valid @RequestBody MedicoDtoRequest medicoDtoRequest){
        return service.atualizar(id, medicoDtoRequest);
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity<MedicoDtoResponse> apagar (@PathVariable Long id){
        return service.apagar(id);
    }
}
