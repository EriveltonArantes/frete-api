package com.freteapi.dto;

import jakarta.validation.constraints.*;

public class CargaRequestDTO {

    @NotBlank(message = "remetente não pode estar em branco")
    private String remetente;
    @NotBlank(message = "cnpj remetente não pode estar em branco")
    private String cnpjRemetente;
    @NotBlank(message = "destinatario não pode estar em branco")
    private String destinatario;
    @NotBlank(message = "cnpj destinatario não pode estar em branco")
    private String cnpjDestinatario;
    @NotBlank(message = "descricao não pode estar em branco")
    private String descricao;
    @NotNull(message = "peso não pode ser nulo")
    private Double peso;
    @NotNull(message = "volume não pode ser nulo")
    private Double volume;
    @DecimalMin(value = "0.0", message = "valor n f não pode ser negativo")
    @NotNull(message = "valor n f não pode ser nulo")
    private Double valorNF;

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
