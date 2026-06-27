package com.freteapi.dto;

import jakarta.validation.constraints.*;

public class VeiculoRequestDTO {

    @NotNull(message = "TransportadoraId é obrigatório")
    @Positive(message = "TransportadoraId deve ser um ID válido (positivo)")
    private Long transportadoraId;
    @NotBlank(message = "placa não pode estar em branco")
    private String placa;
    @NotBlank(message = "tipo não pode estar em branco")
    private String tipo;
    @Min(value = 0, message = "capacidade não pode ser negativo")
    @NotNull(message = "capacidade não pode ser nulo")
    private Integer capacidade;
    @NotBlank(message = "modelo não pode estar em branco")
    private String modelo;
    @Min(value = 0, message = "ano não pode ser negativo")
    @NotNull(message = "ano não pode ser nulo")
    private Integer ano;
    @NotNull(message = "status não pode ser nulo")
    private Boolean status;

    public Long getTransportadoraId() { return transportadoraId; }
    public void setTransportadoraId(Long transportadoraId) { this.transportadoraId = transportadoraId; }
    public String getPlaca() { return placa; }
    public void setPlaca(String placa) { this.placa = placa; }
    public String getTipo() { return tipo; }
    public void setTipo(String tipo) { this.tipo = tipo; }
    public Integer getCapacidade() { return capacidade; }
    public void setCapacidade(Integer capacidade) { this.capacidade = capacidade; }
    public String getModelo() { return modelo; }
    public void setModelo(String modelo) { this.modelo = modelo; }
    public Integer getAno() { return ano; }
    public void setAno(Integer ano) { this.ano = ano; }
    public Boolean getStatus() { return status; }
    public void setStatus(Boolean status) { this.status = status; }
}
