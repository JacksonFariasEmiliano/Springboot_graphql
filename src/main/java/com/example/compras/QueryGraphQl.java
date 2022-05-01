package com.example.compras;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
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

    public Cliente cliente(){
        return new Cliente(1L, "Jackson", "jk@gmail.com");
    }

    public List<Cliente> clientes(){
        List<Cliente> list = new ArrayList<>();
        for (int i = 0; i < 10; i++){
            list.add(new Cliente(2L, "Cliente " + i, "jk"+i+"@gmail.com"));
        }
        return list;
    }
}
