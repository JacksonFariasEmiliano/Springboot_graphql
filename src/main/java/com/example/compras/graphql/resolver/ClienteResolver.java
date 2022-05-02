package com.example.compras.graphql.resolver;

import com.coxautodev.graphql.tools.GraphQLResolver;
import com.example.compras.domain.Cliente;
import com.example.compras.domain.Compra;
import com.example.compras.service.CompraService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ClienteResolver implements GraphQLResolver<Cliente> {

    @Autowired
    private CompraService compraService;

    public List<Compra> compras(Cliente cliente){
        return compraService.findAllByCliente(cliente);
    }
}
