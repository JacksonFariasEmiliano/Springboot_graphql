package com.example.compras.graphql;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.example.compras.domain.Produto;
import com.example.compras.service.ProdutoService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ProdutoGraphQl implements GraphQLQueryResolver, GraphQLMutationResolver {

    @Autowired
    private ProdutoService service;

    public Produto produto(Long id){
        return service.fidById(id);
    }

    public List<Produto> produtos(){
        return service.findAll();
    }

    public Produto saveProduto(Produto produto){
        ModelMapper m = new ModelMapper();
        Produto prod = m.map(produto, Produto.class );
        return service.save(prod);
    }

    public Boolean deleteProduto(Long id){
        return service.deleteById(id);
    }
}
