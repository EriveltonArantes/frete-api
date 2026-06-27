package com.freteapi.service;

import com.freteapi.dto.VeiculoRequestDTO;
import com.freteapi.dto.VeiculoResponseDTO;
import com.freteapi.exception.ResourceNotFoundException;
import com.freteapi.mapper.VeiculoMapper;
import com.freteapi.model.Veiculo;
import com.freteapi.repository.VeiculoRepository;
import com.freteapi.repository.TransportadoraRepository;
import com.freteapi.model.Transportadora;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class VeiculoService {

    @Autowired
    private VeiculoRepository repository;

    @Autowired
    private VeiculoMapper mapper;

    @Autowired
    private TransportadoraRepository transportadoraRepository;

    @Transactional(readOnly = true)
    public List<VeiculoResponseDTO> listar() {
        return repository.findAll().stream().map(mapper::toResponseDTO).collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public VeiculoResponseDTO buscar(Long id) {
        Veiculo entity = repository.findById(id)
            .orElseThrow(() -> new ResourceNotFoundException("Veiculo não encontrado com id: " + id));
        return mapper.toResponseDTO(entity);
    }

    public VeiculoResponseDTO criar(VeiculoRequestDTO dto) {
        Veiculo entity = mapper.toEntity(dto);
        Transportadora transportadora = transportadoraRepository.findById(dto.getTransportadoraId())
            .orElseThrow(() -> new ResourceNotFoundException("Transportadora não encontrado com id: " + dto.getTransportadoraId()));
        entity.setTransportadora(transportadora);
        Veiculo salvo = repository.save(entity);
        return mapper.toResponseDTO(salvo);
    }

    public VeiculoResponseDTO atualizar(Long id, VeiculoRequestDTO dto) {
        if (!repository.existsById(id)) {
            throw new ResourceNotFoundException("Veiculo não encontrado com id: " + id);
        }
        Veiculo entity = mapper.toEntity(dto);
        entity.setId(id);
        Transportadora transportadora = transportadoraRepository.findById(dto.getTransportadoraId())
            .orElseThrow(() -> new ResourceNotFoundException("Transportadora não encontrado com id: " + dto.getTransportadoraId()));
        entity.setTransportadora(transportadora);
        Veiculo salvo = repository.save(entity);
        return mapper.toResponseDTO(salvo);
    }

    public void deletar(Long id) {
        if (!repository.existsById(id)) {
            throw new ResourceNotFoundException("Veiculo não encontrado com id: " + id);
        }
        repository.deleteById(id);
    }
}
