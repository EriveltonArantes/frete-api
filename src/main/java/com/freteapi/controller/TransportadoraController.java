package com.freteapi.controller;

import com.freteapi.dto.TransportadoraRequestDTO;
import com.freteapi.dto.TransportadoraResponseDTO;
import com.freteapi.service.TransportadoraService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@Tag(name = "Transportadora", description = "Gerenciamento de transportadoras")
@RestController
@RequestMapping("/api/transportadoras")
public class TransportadoraController {

    @Autowired
    private TransportadoraService service;

    @Operation(summary = "Listar todos os Transportadora")
    @GetMapping
    public List<TransportadoraResponseDTO> listar(@RequestParam(required = false) String nome) {
        List<TransportadoraResponseDTO> resultado = service.listar();
        if (nome != null && !nome.isBlank()) {
            resultado = resultado.stream().filter(item -> item.getNome() != null &&
                item.getNome().toLowerCase().contains(nome.toLowerCase()))
                .collect(java.util.stream.Collectors.toList());
        }
        return resultado;
    }

    @Operation(summary = "Buscar Transportadora por ID")
    @GetMapping("/{id}")
    public TransportadoraResponseDTO buscar(@PathVariable Long id) { return service.buscar(id); }

    @Operation(summary = "Criar Transportadora")
    @PostMapping
    public ResponseEntity<TransportadoraResponseDTO> criar(@Valid @RequestBody TransportadoraRequestDTO transportadora) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.criar(transportadora));
    }

    @Operation(summary = "Atualizar Transportadora")
    @PutMapping("/{id}")
    public TransportadoraResponseDTO atualizar(@PathVariable Long id, @Valid @RequestBody TransportadoraRequestDTO transportadora) {
        return service.atualizar(id, transportadora);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @Operation(summary = "Excluir Transportadora")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        service.deletar(id);
        return ResponseEntity.noContent().build();
    }
}
