package com.freteapi.dto;

public class VeiculoResponseDTO {

    private Long id;
    private Long transportadoraId;
    private String placa;
    private String tipo;
    private Integer capacidade;
    private String modelo;
    private Integer ano;
    private Boolean status;

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
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
