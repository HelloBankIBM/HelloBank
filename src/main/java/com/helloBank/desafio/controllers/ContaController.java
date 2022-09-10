package com.helloBank.desafio.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.helloBank.desafio.Services.ClienteService;
import com.helloBank.desafio.Services.ContaService;
import com.helloBank.desafio.models.Conta;

@RestController
@RequestMapping("/conta")
public class ContaController {

    @Autowired
    ContaService contaService;

    @Autowired
    ClienteService clienteService;

    @PostMapping
    public Conta create(@RequestBody Conta conta) {
        return contaService.save(conta);
    }

    @GetMapping("/{id}")
    public List<Conta> findByCpf(@PathVariable Long id) {
        return clienteService.findById(id).getContas();
    }
}
