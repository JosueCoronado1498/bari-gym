package com.josuecoronado.barigym.repository;

import com.josuecoronado.barigym.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IRepositoryCliente extends JpaRepository<Cliente, Long> {
}
