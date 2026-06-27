package com.freteapi.controller;

import com.freteapi.dto.FreteRequestDTO;
import com.freteapi.dto.FreteResponseDTO;
import com.freteapi.service.FreteService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@Tag(name = "Frete", description = "Gerenciamento de fretes")
@RestController
@RequestMapping("/api/fretes")
public class FreteController {

    @Autowired
    private FreteService service;

    @Operation(summary = "Listar todos os Frete")
    @GetMapping
    public List<FreteResponseDTO> listar(@RequestParam(required = false) String motorista, @RequestParam(required = false) Long cargaId, @RequestParam(required = false) Long veiculoId) {
        List<FreteResponseDTO> resultado = service.listar();
        if (motorista != null && !motorista.isBlank()) {
            resultado = resultado.stream().filter(item -> item.getMotorista() != null &&
                item.getMotorista().toLowerCase().contains(motorista.toLowerCase()))
                .collect(java.util.stream.Collectors.toList());
        }
        if (cargaId != null) {
            resultado = resultado.stream().filter(item -> cargaId.equals(item.getCargaId())).collect(java.util.stream.Collectors.toList());
        }
        if (veiculoId != null) {
            resultado = resultado.stream().filter(item -> veiculoId.equals(item.getVeiculoId())).collect(java.util.stream.Collectors.toList());
        }
        return resultado;
    }

    @Operation(summary = "Buscar Frete por ID")
    @GetMapping("/{id}")
    public FreteResponseDTO buscar(@PathVariable Long id) { return service.buscar(id); }

    @Operation(summary = "Criar Frete")
    @PostMapping
    public ResponseEntity<FreteResponseDTO> criar(@Valid @RequestBody FreteRequestDTO frete) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.criar(frete));
    }

    @Operation(summary = "Atualizar Frete")
    @PutMapping("/{id}")
    public FreteResponseDTO atualizar(@PathVariable Long id, @Valid @RequestBody FreteRequestDTO frete) {
        return service.atualizar(id, frete);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @Operation(summary = "Excluir Frete")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        service.deletar(id);
        return ResponseEntity.noContent().build();
    }
}
