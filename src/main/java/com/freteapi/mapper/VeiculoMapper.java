package com.freteapi.mapper;

import com.freteapi.dto.VeiculoRequestDTO;
import com.freteapi.dto.VeiculoResponseDTO;
import com.freteapi.model.Veiculo;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface VeiculoMapper {

    @Mapping(target = "transportadora", ignore = true)
    Veiculo toEntity(VeiculoRequestDTO dto);

    @Mapping(target = "transportadoraId", source = "transportadora.id")
    VeiculoResponseDTO toResponseDTO(Veiculo entity);
}
