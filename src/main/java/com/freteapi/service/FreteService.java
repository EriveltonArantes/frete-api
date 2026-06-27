package com.freteapi.service;

import com.freteapi.dto.FreteRequestDTO;
import com.freteapi.dto.FreteResponseDTO;
import com.freteapi.exception.ResourceNotFoundException;
import com.freteapi.mapper.FreteMapper;
import com.freteapi.model.Frete;
import com.freteapi.repository.FreteRepository;
import com.freteapi.repository.CargaRepository;
import com.freteapi.model.Carga;
import com.freteapi.repository.VeiculoRepository;
import com.freteapi.model.Veiculo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class FreteService {

    @Autowired
    private FreteRepository repository;

    @Autowired
    private FreteMapper mapper;

    @Autowired
    private CargaRepository cargaRepository;

    @Autowired
    private VeiculoRepository veiculoRepository;

    @Transactional(readOnly = true)
    public List<FreteResponseDTO> listar() {
        return repository.findAll().stream().map(mapper::toResponseDTO).collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public FreteResponseDTO buscar(Long id) {
        Frete entity = repository.findById(id)
            .orElseThrow(() -> new ResourceNotFoundException("Frete não encontrado com id: " + id));
        return mapper.toResponseDTO(entity);
    }

    public FreteResponseDTO criar(FreteRequestDTO dto) {
        Frete entity = mapper.toEntity(dto);
        Carga carga = cargaRepository.findById(dto.getCargaId())
            .orElseThrow(() -> new ResourceNotFoundException("Carga não encontrado com id: " + dto.getCargaId()));
        entity.setCarga(carga);
        Veiculo veiculo = veiculoRepository.findById(dto.getVeiculoId())
            .orElseThrow(() -> new ResourceNotFoundException("Veiculo não encontrado com id: " + dto.getVeiculoId()));
        entity.setVeiculo(veiculo);
        Frete salvo = repository.save(entity);
        return mapper.toResponseDTO(salvo);
    }

    public FreteResponseDTO atualizar(Long id, FreteRequestDTO dto) {
        if (!repository.existsById(id)) {
            throw new ResourceNotFoundException("Frete não encontrado com id: " + id);
        }
        Frete entity = mapper.toEntity(dto);
        entity.setId(id);
        Carga carga = cargaRepository.findById(dto.getCargaId())
            .orElseThrow(() -> new ResourceNotFoundException("Carga não encontrado com id: " + dto.getCargaId()));
        entity.setCarga(carga);
        Veiculo veiculo = veiculoRepository.findById(dto.getVeiculoId())
            .orElseThrow(() -> new ResourceNotFoundException("Veiculo não encontrado com id: " + dto.getVeiculoId()));
        entity.setVeiculo(veiculo);
        Frete salvo = repository.save(entity);
        return mapper.toResponseDTO(salvo);
    }

    public void deletar(Long id) {
        if (!repository.existsById(id)) {
            throw new ResourceNotFoundException("Frete não encontrado com id: " + id);
        }
        repository.deleteById(id);
    }
}
