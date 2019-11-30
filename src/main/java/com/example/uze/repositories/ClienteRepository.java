package com.example.uze.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.uze.model.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Integer> {

}
