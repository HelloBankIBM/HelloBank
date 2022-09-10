package com.helloBank.desafio.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.helloBank.desafio.models.Conta;

public interface ContaRepository extends JpaRepository<Conta, Long> {

}
