package com.freteapi.controller;

import com.freteapi.model.Transportadora;
import com.freteapi.model.Veiculo;
import com.freteapi.model.Carga;
import com.freteapi.model.Frete;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.LinkedHashMap;
import java.util.Map;

@Tag(name = "Dashboard", description = "KPIs e totais do sistema")
@RestController
@RequestMapping("/api/dashboard")
public class DashboardController {

    @Autowired
    private com.freteapi.repository.TransportadoraRepository transportadoraRepository;

    @Autowired
    private com.freteapi.repository.VeiculoRepository veiculoRepository;

    @Autowired
    private com.freteapi.repository.CargaRepository cargaRepository;

    @Autowired
    private com.freteapi.repository.FreteRepository freteRepository;

    @Operation(summary = "Resumo com totais, somas e gráficos de status")
    @Transactional(readOnly = true)
    @GetMapping("/resumo")
    public Map<String, Object> resumo() {
        Map<String, Object> resumo = new LinkedHashMap<>();
        resumo.put("totalTransportadora", transportadoraRepository.count());
        resumo.put("totalVeiculo", veiculoRepository.count());
        resumo.put("somaCapacidadeVeiculo", veiculoRepository.findAll().stream().filter(e -> e.getCapacidade() != null).mapToInt(e -> e.getCapacidade()).sum());
        resumo.put("graficoVeiculo", veiculoRepository.findAll().stream()
            .collect(java.util.stream.Collectors.groupingBy(
                item -> String.valueOf(item.getStatus()),
                java.util.LinkedHashMap::new,
                java.util.stream.Collectors.counting())));
        resumo.put("totalCarga", cargaRepository.count());
        resumo.put("somaPesoCarga", cargaRepository.findAll().stream().filter(e -> e.getPeso() != null).mapToDouble(e -> e.getPeso()).sum());
        resumo.put("totalFrete", freteRepository.count());
        resumo.put("somaValorFreteFrete", freteRepository.findAll().stream().filter(e -> e.getValorFrete() != null).mapToDouble(e -> e.getValorFrete()).sum());
        resumo.put("graficoFrete", freteRepository.findAll().stream()
            .collect(java.util.stream.Collectors.groupingBy(
                item -> String.valueOf(item.getStatus()),
                java.util.LinkedHashMap::new,
                java.util.stream.Collectors.counting())));
        return resumo;
    }
}
