package com.example.compras.repository;

import com.example.compras.domain.Cliente;
import com.example.compras.domain.Compra;
import com.example.compras.domain.dto.CompraResumo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CompraRepository extends JpaRepository<Compra, Long> {

//    @Query("select c from Compra c where c.cliente.id = :clienteId")
//    List<Compra> findAllByCliente(@Param("clienteId") Long clienteId);

//    @Query("select c from Compra c where c.cliente = :cliente")
//    List<Compra> findAllByCliente(@Param("cliente") Cliente cliente);

    List<Compra> findAllByCliente(Cliente cliente);

    List<Compra> findAllByClienteAndQuantidade(Cliente cliente, int quantidade);


    @Query("select new com.example.compras.domain.dto.CompraResumo( c.id, cli.nome, p.nome, c.quantidade) from Compra c inner join c.cliente cli inner join c.produto p")
    List<CompraResumo> findAllCompraRelatorio();
}
