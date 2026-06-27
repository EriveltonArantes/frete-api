package com.freteapi.model;

import jakarta.persistence.*;

@Entity
@Table(name = "fretes")
public class Frete {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "carga_id")
    private Carga carga;
    @ManyToOne
    @JoinColumn(name = "veiculo_id")
    private Veiculo veiculo;
    @Column(nullable = false)
    private String motorista;
    @Column(nullable = false)
    private String origem;
    @Column(nullable = false)
    private String destino;
    private java.time.LocalDateTime dataColeta;
    private java.time.LocalDateTime dataEntrega;
    private Double valorFrete;
    @Column(nullable = false)
    private String status;
    @Column(columnDefinition = "TEXT")
    private String observacoes;

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public Carga getCarga() { return carga; }
    public void setCarga(Carga carga) { this.carga = carga; }
    public Veiculo getVeiculo() { return veiculo; }
    public void setVeiculo(Veiculo veiculo) { this.veiculo = veiculo; }
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
