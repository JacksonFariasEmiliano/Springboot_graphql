package com.example.compras.graphql.resolver;

import com.coxautodev.graphql.tools.GraphQLResolver;
import com.example.compras.domain.Produto;
import org.springframework.stereotype.Component;

@Component
public class ProdutoResolver implements GraphQLResolver<Produto> {

    public String valorReais(Produto produto){
        return "R$ " + produto.getValor();
    }
}
