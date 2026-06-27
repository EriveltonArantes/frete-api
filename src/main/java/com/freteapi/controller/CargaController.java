package com.freteapi.controller;

import com.freteapi.dto.CargaRequestDTO;
import com.freteapi.dto.CargaResponseDTO;
import com.freteapi.service.CargaService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@Tag(name = "Carga", description = "Gerenciamento de cargas")
@RestController
@RequestMapping("/api/cargas")
public class CargaController {

    @Autowired
    private CargaService service;

    @Operation(summary = "Listar todos os Carga")
    @GetMapping
    public List<CargaResponseDTO> listar(@RequestParam(required = false) String descricao) {
        List<CargaResponseDTO> resultado = service.listar();
        if (descricao != null && !descricao.isBlank()) {
            resultado = resultado.stream().filter(item -> item.getDescricao() != null &&
                item.getDescricao().toLowerCase().contains(descricao.toLowerCase()))
                .collect(java.util.stream.Collectors.toList());
        }
        return resultado;
    }

    @Operation(summary = "Buscar Carga por ID")
    @GetMapping("/{id}")
    public CargaResponseDTO buscar(@PathVariable Long id) { return service.buscar(id); }

    @Operation(summary = "Criar Carga")
    @PostMapping
    public ResponseEntity<CargaResponseDTO> criar(@Valid @RequestBody CargaRequestDTO carga) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.criar(carga));
    }

    @Operation(summary = "Atualizar Carga")
    @PutMapping("/{id}")
    public CargaResponseDTO atualizar(@PathVariable Long id, @Valid @RequestBody CargaRequestDTO carga) {
        return service.atualizar(id, carga);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @Operation(summary = "Excluir Carga")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        service.deletar(id);
        return ResponseEntity.noContent().build();
    }
}
