package com.freteapi.controller;

import com.freteapi.dto.VeiculoRequestDTO;
import com.freteapi.dto.VeiculoResponseDTO;
import com.freteapi.service.VeiculoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@Tag(name = "Veiculo", description = "Gerenciamento de veiculos")
@RestController
@RequestMapping("/api/veiculos")
public class VeiculoController {

    @Autowired
    private VeiculoService service;

    @Operation(summary = "Listar todos os Veiculo")
    @GetMapping
    public List<VeiculoResponseDTO> listar(@RequestParam(required = false) String placa, @RequestParam(required = false) Long transportadoraId) {
        List<VeiculoResponseDTO> resultado = service.listar();
        if (placa != null && !placa.isBlank()) {
            resultado = resultado.stream().filter(item -> item.getPlaca() != null &&
                item.getPlaca().toLowerCase().contains(placa.toLowerCase()))
                .collect(java.util.stream.Collectors.toList());
        }
        if (transportadoraId != null) {
            resultado = resultado.stream().filter(item -> transportadoraId.equals(item.getTransportadoraId())).collect(java.util.stream.Collectors.toList());
        }
        return resultado;
    }

    @Operation(summary = "Buscar Veiculo por ID")
    @GetMapping("/{id}")
    public VeiculoResponseDTO buscar(@PathVariable Long id) { return service.buscar(id); }

    @Operation(summary = "Criar Veiculo")
    @PostMapping
    public ResponseEntity<VeiculoResponseDTO> criar(@Valid @RequestBody VeiculoRequestDTO veiculo) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.criar(veiculo));
    }

    @Operation(summary = "Atualizar Veiculo")
    @PutMapping("/{id}")
    public VeiculoResponseDTO atualizar(@PathVariable Long id, @Valid @RequestBody VeiculoRequestDTO veiculo) {
        return service.atualizar(id, veiculo);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @Operation(summary = "Excluir Veiculo")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        service.deletar(id);
        return ResponseEntity.noContent().build();
    }
}
