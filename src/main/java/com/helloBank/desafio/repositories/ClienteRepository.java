package com.helloBank.desafio.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.helloBank.desafio.models.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {
    boolean existsBycpf(String cpf);
}
