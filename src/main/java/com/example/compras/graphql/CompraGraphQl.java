package com.example.compras.graphql;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.example.compras.domain.Compra;
import com.example.compras.domain.CompraInput;
import com.example.compras.domain.Produto;
import com.example.compras.service.ClienteService;
import com.example.compras.service.CompraService;
import com.example.compras.service.ProdutoService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;

@Component
public class CompraGraphQl implements GraphQLQueryResolver, GraphQLMutationResolver {

    @Autowired
    private CompraService service;

    @Autowired
    private ClienteService clienteService;

    @Autowired
    private ProdutoService produtoService;

    public Compra compra(Long id){
        return service.findById(id);
    }

    public List<Compra> compras(){
        return service.findAll();
    }

    public Compra saveCompra(CompraInput input){
        ModelMapper mapper = new ModelMapper();
        Compra comp = mapper.map(input, Compra.class);

        comp.setData(new Date());

        comp.setCliente(clienteService.findById(input.getClienteId()));
        comp.setProduto(produtoService.fidById(input.getProdutoId()));
        return service.save(comp);
    }

    public Boolean deleteCompra(Long id){
        return service.deleteById(id);
    }
}
