package com.freteapi.model;

import jakarta.persistence.*;

@Entity
@Table(name = "cargas")
public class Carga {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String remetente;
    @Column(nullable = false)
    private String cnpjRemetente;
    @Column(nullable = false)
    private String destinatario;
    @Column(nullable = false)
    private String cnpjDestinatario;
    @Column(columnDefinition = "TEXT", nullable = false)
    private String descricao;
    private Double peso;
    private Double volume;
    private Double valorNF;

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getRemetente() { return remetente; }
    public void setRemetente(String remetente) { this.remetente = remetente; }
    public String getCnpjRemetente() { return cnpjRemetente; }
    public void setCnpjRemetente(String cnpjRemetente) { this.cnpjRemetente = cnpjRemetente; }
    public String getDestinatario() { return destinatario; }
    public void setDestinatario(String destinatario) { this.destinatario = destinatario; }
    public String getCnpjDestinatario() { return cnpjDestinatario; }
    public void setCnpjDestinatario(String cnpjDestinatario) { this.cnpjDestinatario = cnpjDestinatario; }
    public String getDescricao() { return descricao; }
    public void setDescricao(String descricao) { this.descricao = descricao; }
    public Double getPeso() { return peso; }
    public void setPeso(Double peso) { this.peso = peso; }
    public Double getVolume() { return volume; }
    public void setVolume(Double volume) { this.volume = volume; }
    public Double getValorNF() { return valorNF; }
    public void setValorNF(Double valorNF) { this.valorNF = valorNF; }
}
