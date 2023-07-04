package med.voll.api.controller;

import jakarta.validation.Valid;
import med.voll.api.dtos.DtoIndexPaciente;
import med.voll.api.dtos.DtoCadastroPaciente;
import med.voll.api.dtos.DtoUpdatePaciente;
import med.voll.api.services.PacienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

@RestController
@RequestMapping("pacientes")
public class PacienteController {

    private final PacienteService pacienteService;

    @Autowired
    public PacienteController(PacienteService pacienteService) {
        this.pacienteService = pacienteService;
    }

    @PostMapping
    @Transactional
    public ResponseEntity<DtoIndexPaciente> cadastrar(@RequestBody @Valid DtoCadastroPaciente dados, UriComponentsBuilder uriBuilder) {
        return pacienteService.cadastrarPaciente(dados);
    }

    @GetMapping
    public ResponseEntity<List<DtoIndexPaciente>> listar(@PageableDefault(size = 10, sort = {"nome"}) Pageable paginacao) {
        List<DtoIndexPaciente> dtoPage = pacienteService.listarPacientes(paginacao);
        return ResponseEntity.ok(dtoPage);
    }

    @PutMapping("/{id}")
    @Transactional
    public ResponseEntity<DtoIndexPaciente> atualizar(@PathVariable Long id, @RequestBody @Valid DtoUpdatePaciente dados) {
        return pacienteService.atualizarPaciente(id, dados);
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity<DtoIndexPaciente> excluir(@PathVariable Long id) {
        return pacienteService.apagarPaciente(id);
    }

    @GetMapping("/{id}")
    public ResponseEntity<DtoIndexPaciente> detalhar(@PathVariable Long id) {
        return pacienteService.buscarPacientePorId(id);
    }
}
