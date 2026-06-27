package com.freteapi.dto;

import jakarta.validation.constraints.*;

public class FreteRequestDTO {

    @NotNull(message = "CargaId é obrigatório")
    @Positive(message = "CargaId deve ser um ID válido (positivo)")
    private Long cargaId;
    @NotNull(message = "VeiculoId é obrigatório")
    @Positive(message = "VeiculoId deve ser um ID válido (positivo)")
    private Long veiculoId;
    @NotBlank(message = "motorista não pode estar em branco")
    private String motorista;
    @NotBlank(message = "origem não pode estar em branco")
    private String origem;
    @NotBlank(message = "destino não pode estar em branco")
    private String destino;
    @NotNull(message = "data coleta não pode ser nulo")
    private java.time.LocalDateTime dataColeta;
    @FutureOrPresent(message = "data entrega não pode ser retroativo")
    @NotNull(message = "data entrega não pode ser nulo")
    private java.time.LocalDateTime dataEntrega;
    @DecimalMin(value = "0.0", message = "valor frete não pode ser negativo")
    @NotNull(message = "valor frete não pode ser nulo")
    private Double valorFrete;
    @NotBlank(message = "status não pode estar em branco")
    private String status;

    private String observacoes;

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
