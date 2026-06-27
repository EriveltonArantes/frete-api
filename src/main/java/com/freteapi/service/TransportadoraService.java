package com.freteapi.service;

import com.freteapi.dto.TransportadoraRequestDTO;
import com.freteapi.dto.TransportadoraResponseDTO;
import com.freteapi.exception.ResourceNotFoundException;
import com.freteapi.mapper.TransportadoraMapper;
import com.freteapi.model.Transportadora;
import com.freteapi.repository.TransportadoraRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class TransportadoraService {

    @Autowired
    private TransportadoraRepository repository;

    @Autowired
    private TransportadoraMapper mapper;

    @Transactional(readOnly = true)
    public List<TransportadoraResponseDTO> listar() {
        return repository.findAll().stream().map(mapper::toResponseDTO).collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public TransportadoraResponseDTO buscar(Long id) {
        Transportadora entity = repository.findById(id)
            .orElseThrow(() -> new ResourceNotFoundException("Transportadora não encontrado com id: " + id));
        return mapper.toResponseDTO(entity);
    }

    public TransportadoraResponseDTO criar(TransportadoraRequestDTO dto) {
        Transportadora entity = mapper.toEntity(dto);
        Transportadora salvo = repository.save(entity);
        return mapper.toResponseDTO(salvo);
    }

    public TransportadoraResponseDTO atualizar(Long id, TransportadoraRequestDTO dto) {
        if (!repository.existsById(id)) {
            throw new ResourceNotFoundException("Transportadora não encontrado com id: " + id);
        }
        Transportadora entity = mapper.toEntity(dto);
        entity.setId(id);
        Transportadora salvo = repository.save(entity);
        return mapper.toResponseDTO(salvo);
    }

    public void deletar(Long id) {
        if (!repository.existsById(id)) {
            throw new ResourceNotFoundException("Transportadora não encontrado com id: " + id);
        }
        repository.deleteById(id);
    }
}
