package com.freteapi.mapper;

import com.freteapi.dto.FreteRequestDTO;
import com.freteapi.dto.FreteResponseDTO;
import com.freteapi.model.Frete;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface FreteMapper {

    @Mapping(target = "carga", ignore = true)
    @Mapping(target = "veiculo", ignore = true)
    Frete toEntity(FreteRequestDTO dto);

    @Mapping(target = "cargaId", source = "carga.id")
    @Mapping(target = "veiculoId", source = "veiculo.id")
    FreteResponseDTO toResponseDTO(Frete entity);
}
