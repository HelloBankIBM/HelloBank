package com.helloBank.desafio.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.helloBank.desafio.models.Transacao;
import com.helloBank.desafio.repositories.TransacaoRepository;

@Service
public class TransacaoService {
    @Autowired
    private TransacaoRepository transacaoRepository;

    public Transacao save(Transacao transacao) {
        return transacaoRepository.save(transacao);
    }

    public List<Transacao> findAll() {
        return transacaoRepository.findAll();
    }
}
