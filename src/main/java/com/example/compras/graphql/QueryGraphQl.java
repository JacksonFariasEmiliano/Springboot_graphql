package com.example.compras.graphql;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.example.compras.cliente.ClienteRepository;
import com.example.compras.domain.Cliente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class QueryGraphQl implements GraphQLQueryResolver {

    public String hello(){
        return "Hello GraphQL";
    }
    public int soma(int a, int b){
        return a+b;
    }

}
