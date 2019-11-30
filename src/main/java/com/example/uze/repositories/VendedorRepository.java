package com.example.uze.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.uze.model.Vendedor;

@Repository
public interface VendedorRepository extends JpaRepository<Vendedor, Integer> {

}
