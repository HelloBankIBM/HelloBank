package com.helloBank.desafio.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.helloBank.desafio.models.Transacao;

public interface TransacaoRepository extends JpaRepository<Transacao, Long> {

}
