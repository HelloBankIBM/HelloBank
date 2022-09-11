package com.helloBank.desafio.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.helloBank.desafio.Services.ContaService;
import com.helloBank.desafio.Services.TransacaoService;
import com.helloBank.desafio.models.Conta;
import com.helloBank.desafio.models.Transacao;

@RestController
@RequestMapping("/transacao")
public class TransacaoController {
    @Autowired
    TransacaoService transacaoService;

    @Autowired
    ContaService contaService;

    @PostMapping
    public Transacao create(@RequestBody Transacao transacao) {
        Conta contaDestino = contaService.findById(transacao.getContaDestino());
        Conta contaOrigem = contaService.findById(transacao.getContaOrigem());

        contaOrigem.setSaldo(contaOrigem.getSaldo() - transacao.getValor());
        contaDestino.setSaldo(contaDestino.getSaldo() + transacao.getValor());

        contaService.update(contaOrigem);
        contaService.update(contaDestino);

        return transacaoService.save(transacao);
    }

    @GetMapping
    public List<Transacao> findAll() {
        return transacaoService.findAll();
    }
}
