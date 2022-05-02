package com.example.compras.graphql.resolver;

import com.coxautodev.graphql.tools.GraphQLResolver;
import com.example.compras.domain.Cliente;
import com.example.compras.domain.Compra;
import com.example.compras.domain.Produto;
import com.example.compras.service.ClienteService;
import com.example.compras.service.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CompraResolver implements GraphQLResolver<Compra> {

    @Autowired
    private ClienteService clienteService;
    @Autowired
    private ProdutoService produtoService;

    public String status(Compra compra){
        return "Teste : " + compra.getStatus();
    }

    public Cliente cliente(Compra compra){
        return clienteService.findById(compra.getCliente().getId());
    }

    public Produto produto(Compra compra){
        return produtoService.fidById(compra.getProduto().getId());
    }
}
