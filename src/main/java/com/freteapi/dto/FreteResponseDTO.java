package com.freteapi.dto;

public class FreteResponseDTO {

    private Long id;
    private Long cargaId;
    private Long veiculoId;
    private String motorista;
    private String origem;
    private String destino;
    private java.time.LocalDateTime dataColeta;
    private java.time.LocalDateTime dataEntrega;
    private Double valorFrete;
    private String status;
    private String observacoes;

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public Long getCargaId() { return cargaId; }
    public void setCargaId(Long cargaId) { this.cargaId = cargaId; }
    public Long getVeiculoId() { return veiculoId; }
    public void setVeiculoId(Long veiculoId) { this.veiculoId = veiculoId; }
    public String getMotorista() { return motorista; }
    public void setMotorista(String motorista) { this.motorista = motorista; }
    public String getOrigem() { return origem; }
    public void setOrigem(String origem) { this.origem = origem; }
    public String getDestino() { return destino; }
    public void setDestino(String destino) { this.destino = destino; }
    public java.time.LocalDateTime getDataColeta() { return dataColeta; }
    public void setDataColeta(java.time.LocalDateTime dataColeta) { this.dataColeta = dataColeta; }
    public java.time.LocalDateTime getDataEntrega() { return dataEntrega; }
    public void setDataEntrega(java.time.LocalDateTime dataEntrega) { this.dataEntrega = dataEntrega; }
    public Double getValorFrete() { return valorFrete; }
    public void setValorFrete(Double valorFrete) { this.valorFrete = valorFrete; }
    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
    public String getObservacoes() { return observacoes; }
    public void setObservacoes(String observacoes) { this.observacoes = observacoes; }
}
