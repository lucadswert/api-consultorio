package com.gerencia.sistema.controladores;

import com.gerencia.sistema.dtos.ConsultaDtoRequest;
import com.gerencia.sistema.dtos.ConsultaDtoResponse;
import com.gerencia.sistema.servicos.ConsultaService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/atuacoes")
public class ConsultaController {

    @Autowired
    private ConsultaService service;

    @PostMapping
    public ResponseEntity<ConsultaDtoResponse> adicionar (@Valid @RequestBody ConsultaDtoRequest consultaDtoRequest){
        return service.adicionar(consultaDtoRequest);
    }

    @DeleteMapping
    public ResponseEntity<ConsultaDtoResponse> apagar (@PathVariable Long id){
        return service.apagar(id);
    }
}
