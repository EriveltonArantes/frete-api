package com.freteapi.mapper;

import com.freteapi.dto.TransportadoraRequestDTO;
import com.freteapi.dto.TransportadoraResponseDTO;
import com.freteapi.model.Transportadora;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface TransportadoraMapper {

    Transportadora toEntity(TransportadoraRequestDTO dto);

    TransportadoraResponseDTO toResponseDTO(Transportadora entity);
}
