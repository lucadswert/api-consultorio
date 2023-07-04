package med.voll.api.controller;

import jakarta.validation.Valid;
import med.voll.api.dtos.DtoListagemMedico;
import med.voll.api.dtos.DtoCadastroMedico;
import med.voll.api.dtos.DtoUpdateMedico;
import med.voll.api.entidades.Medico;
import med.voll.api.services.MedicoService;
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
@RequestMapping("medicos")
public class MedicoController {

    @Autowired
    private MedicoService medicoService;

    @PostMapping
    @Transactional
    public ResponseEntity<DtoListagemMedico> cadastrar(@RequestBody @Valid DtoCadastroMedico dados, UriComponentsBuilder uriBuilder) {
        return medicoService.criarMedico(dados);
    }

    @GetMapping
    public ResponseEntity<List<DtoListagemMedico>> listar(@PageableDefault(size = 10, sort = {"nome"}) Pageable paginacao) {
        List<DtoListagemMedico> dtoPage = medicoService.listarMedicos(paginacao);
        return ResponseEntity.ok(dtoPage);
    }

    @PutMapping("/{id}")
    @Transactional
    public ResponseEntity<DtoListagemMedico> atualizar(@PathVariable Long id, @RequestBody @Valid DtoUpdateMedico dados) {
        return medicoService.atualizarMedico(id, dados);
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity<DtoListagemMedico> excluir(@PathVariable Long id) {
        return medicoService.apagarMedico(id);
    }

    @GetMapping("/{id}")
    public ResponseEntity<DtoListagemMedico> detalhar(@PathVariable Long id) {
        return medicoService.buscarMedicoPorId(id);
    }
}
