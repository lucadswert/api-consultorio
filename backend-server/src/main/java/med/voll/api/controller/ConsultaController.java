package med.voll.api.controller;

import jakarta.validation.Valid;
import med.voll.api.services.ConsultaService;
import med.voll.api.dtos.DtoCriacaoConsulta;
import med.voll.api.dtos.DtoCancelarConsulta;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("consultas")
public class ConsultaController {

    @Autowired
    private ConsultaService agenda;

    @PostMapping
    @Transactional
    public ResponseEntity agendar(@RequestBody @Valid DtoCriacaoConsulta dados) {
        var dto = agenda.agendar(dados);
        return ResponseEntity.ok(dto);
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity cancelar(@PathVariable Long id, @RequestBody @Valid DtoCancelarConsulta dados) {
        agenda.cancelar(id, dados);
        return ResponseEntity.noContent().build();
    }

}
