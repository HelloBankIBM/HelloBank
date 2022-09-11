package com.helloBank.desafio.Services;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.helloBank.desafio.models.Conta;
import com.helloBank.desafio.repositories.ContaRepository;

@Service
public class ContaService {
    @Autowired
    private ContaRepository contaRepository;

    public Conta findById(Long id) {
        return contaRepository.findById(id).get();
    }

    @Transactional
    public Conta save(Conta conta) {
        return contaRepository.save(conta);
    }

    public Conta update(Conta conta) {
        return contaRepository.save(conta);
    }
}
