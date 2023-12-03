package br.com.crisdev.clinicavet.controller;

import br.com.crisdev.clinicavet.domain.veterinario.*;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("/veterinarios")
public class VeterinarioController {

    @Autowired
    VeterinarioRepository repository;

    @PostMapping
    @Transactional
    public ResponseEntity cadastrar(@RequestBody @Valid DadosCadastroVeterinario dados, UriComponentsBuilder uriBuilder) {
        var veterinario = new Veterinario(dados);
        repository.save(veterinario);
        var uri = uriBuilder.path("/veterinarios/{id}").buildAndExpand(veterinario.getId()).toUri();
        return ResponseEntity.created(uri).body(new DadosDetalhamentoVeterinario(veterinario));
    }

    @GetMapping("/{id}")
    public ResponseEntity detalhar(@PathVariable Long id) {
        var veterinario = repository.getReferenceById(id);
        return ResponseEntity.ok(new DadosDetalhamentoVeterinario(veterinario));
    }

    @GetMapping
    public ResponseEntity<Page<DadosListagemVeterinarios>> listar(@PageableDefault(size = 10, sort = {"nome"})Pageable paginacao) {
        var page = repository.findAllByAtivoTrue(paginacao).map(DadosListagemVeterinarios::new);
        return ResponseEntity.ok(page);
    }

    @PutMapping
    @Transactional
    public ResponseEntity atualizar(@RequestBody DadosAtualizacaoVeterinario dados) {
        var veterinario = repository.getReferenceById(dados.id());
        veterinario.atualizarInformacoes(dados);
        return ResponseEntity.ok(new DadosDetalhamentoVeterinario(veterinario));
    }
}
