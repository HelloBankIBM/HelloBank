package com.helloBank.desafio.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "transacao")
public class Transacao {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Double valor;
    private Long contaOrigem;
    private Long contaDestino;

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    public Long getContaOrigem() {
        return contaOrigem;
    }

    public void setContaOrigem(Long contaOrigem) {
        this.contaOrigem = contaOrigem;
    }

    public Long getContaDestino() {
        return contaDestino;
    }

    public void setContaDestino(Long contaDestino) {
        this.contaDestino = contaDestino;
    }
}
