package com.helloBank.desafio.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.helloBank.desafio.Services.ClienteService;
import com.helloBank.desafio.models.Cliente;

@RestController
@RequestMapping("/clientes")
public class ClienteController {
    @Autowired
    ClienteService clienteService;

    @GetMapping
    public ResponseEntity<List<Cliente>> findAll() {
        return ResponseEntity.ok().body(clienteService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> findById(@PathVariable(value = "id") Long id) {
        if (clienteService.findById(id) == null) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body("Cliente não encontrado");
        }
        return ResponseEntity.ok().body(clienteService.findById(id));
    }

    @PostMapping
    public ResponseEntity<Object> save(@RequestBody Cliente cliente) {
        if (clienteService.existsBycpfClient(cliente.getCpf())) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body("Usuário ja cadastrado");
        }

        return ResponseEntity.ok().body(clienteService.save(cliente));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> update(@PathVariable(value = "id") Long id, @RequestBody Cliente cliente) {
        if (clienteService.findById(id) == null) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body("Cliente não encontrado");
        }

        cliente.setId(id);
        return ResponseEntity.ok().body(clienteService.update(cliente));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> delete(@PathVariable(value = "id") Long id) {
        if (clienteService.findById(id) == null) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body("Cliente não encontrado");
        }

        clienteService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
