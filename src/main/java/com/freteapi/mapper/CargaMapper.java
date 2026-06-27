package com.freteapi.mapper;

import com.freteapi.dto.CargaRequestDTO;
import com.freteapi.dto.CargaResponseDTO;
import com.freteapi.model.Carga;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface CargaMapper {

    Carga toEntity(CargaRequestDTO dto);

    CargaResponseDTO toResponseDTO(Carga entity);
}
