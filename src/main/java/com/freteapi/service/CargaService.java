package com.freteapi.service;

import com.freteapi.dto.CargaRequestDTO;
import com.freteapi.dto.CargaResponseDTO;
import com.freteapi.exception.ResourceNotFoundException;
import com.freteapi.mapper.CargaMapper;
import com.freteapi.model.Carga;
import com.freteapi.repository.CargaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class CargaService {

    @Autowired
    private CargaRepository repository;

    @Autowired
    private CargaMapper mapper;

    @Transactional(readOnly = true)
    public List<CargaResponseDTO> listar() {
        return repository.findAll().stream().map(mapper::toResponseDTO).collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public CargaResponseDTO buscar(Long id) {
        Carga entity = repository.findById(id)
            .orElseThrow(() -> new ResourceNotFoundException("Carga não encontrado com id: " + id));
        return mapper.toResponseDTO(entity);
    }

    public CargaResponseDTO criar(CargaRequestDTO dto) {
        Carga entity = mapper.toEntity(dto);
        Carga salvo = repository.save(entity);
        return mapper.toResponseDTO(salvo);
    }

    public CargaResponseDTO atualizar(Long id, CargaRequestDTO dto) {
        if (!repository.existsById(id)) {
            throw new ResourceNotFoundException("Carga não encontrado com id: " + id);
        }
        Carga entity = mapper.toEntity(dto);
        entity.setId(id);
        Carga salvo = repository.save(entity);
        return mapper.toResponseDTO(salvo);
    }

    public void deletar(Long id) {
        if (!repository.existsById(id)) {
            throw new ResourceNotFoundException("Carga não encontrado com id: " + id);
        }
        repository.deleteById(id);
    }
}
