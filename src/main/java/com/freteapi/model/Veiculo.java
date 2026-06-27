package com.freteapi.model;

import jakarta.persistence.*;

@Entity
@Table(name = "veiculos")
public class Veiculo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "transportadora_id")
    private Transportadora transportadora;
    @Column(nullable = false)
    private String placa;
    @Column(nullable = false)
    private String tipo;
    private Integer capacidade;
    @Column(nullable = false)
    private String modelo;
    private Integer ano;
    private Boolean status;

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public Transportadora getTransportadora() { return transportadora; }
    public void setTransportadora(Transportadora transportadora) { this.transportadora = transportadora; }
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
