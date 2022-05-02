package com.example.compras.repository;

import com.example.compras.domain.Cliente;
import com.example.compras.domain.Compra;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CompraRepository extends JpaRepository<Compra, Long> {
    List<Compra> findAllByCliente(Cliente cliente);
}
