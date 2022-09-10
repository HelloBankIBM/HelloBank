package com.helloBank.desafio.Services;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.helloBank.desafio.models.Cliente;
import com.helloBank.desafio.repositories.ClienteRepository;

@Service
public class ClienteService {
    @Autowired
    private ClienteRepository clienteRepository;

    public List<Cliente> findAll() {
        return clienteRepository.findAll();
    }

    public Cliente findById(Long id) {
        return clienteRepository.findById(id).get();
    }

    @Transactional
    public Cliente save(Cliente cliente) {
        return clienteRepository.save(cliente);
    }

    public boolean existsBycpfClient(String cpf) {
        return clienteRepository.existsBycpf(cpf);
    }

    public Cliente update(Cliente cliente) {
        return clienteRepository.save(cliente);
    }

    @Transactional
    public void delete(Long id) {
        clienteRepository.deleteById(id);
    }
}
