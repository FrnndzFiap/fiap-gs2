package br.com.fiap.gs2.controller;

import br.com.fiap.gs2.dtos.TarefaRequestCreateDto;
import br.com.fiap.gs2.dtos.TarefaRequestUpdateDto;
import br.com.fiap.gs2.dtos.TarefaResponseDto;
import br.com.fiap.gs2.service.TarefaService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tarefas")
public class TarefaController {

    @Autowired
    private TarefaService tarefaService;

    @Autowired
    private ModelMapper modelMapper;

    @GetMapping
    public ResponseEntity<List<TarefaResponseDto>> list() {
        List<TarefaResponseDto> dtos = tarefaService.list()
                .stream()
                .map(e -> new TarefaResponseDto().toDto(e))
                .toList();

        return ResponseEntity.ok().body(dtos);
    }

    @GetMapping("{id}")
    public ResponseEntity<TarefaResponseDto> findById(@PathVariable Long id) {
        return ResponseEntity.ok()
                .body(
                        tarefaService
                                .findById(id)
                                .map(e -> new TarefaResponseDto().toDto(e))
                                .orElseThrow(() -> new RuntimeException("Id inexistente"))
                );

    }

    @GetMapping("{nome}")
    public ResponseEntity<TarefaResponseDto> findByNome(@PathVariable String nome) {
        return ResponseEntity.ok()
                .body(
                        tarefaService
                                .findByNome(nome)
                                .map(e -> new TarefaResponseDto().toDto(e))
                                .orElseThrow(() -> new RuntimeException("Nome inexistente"))
                );

    }

    @PostMapping
    public ResponseEntity<TarefaResponseDto> create(@RequestBody TarefaRequestCreateDto dto) {
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(
                        new TarefaResponseDto().toDto(
                                tarefaService.save(dto.toModel()))
                );
    }



    @PutMapping("{id}")
    public ResponseEntity<TarefaResponseDto> update(
            @PathVariable Long id,
            @RequestBody TarefaRequestUpdateDto dto) {
        if (! tarefaService.existsById(id)){
            throw new RuntimeException("Id inexistente");
        }
        return ResponseEntity.ok()
                .body(
                        new TarefaResponseDto().toDto(
                                tarefaService.save(dto.toModel(id)))
                );
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable Long id) {
        if (! tarefaService.existsById(id)){
            throw new RuntimeException("Id inexistente");
        }

        tarefaService.delete(id);
    }
}
