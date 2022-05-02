package com.example.compras.graphql;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.example.compras.domain.Cliente;
import com.example.compras.service.ClienteService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ClienteGraphQl implements GraphQLQueryResolver, GraphQLMutationResolver {

    @Autowired
    private ClienteService service;

    public Cliente cliente(Long id) {
        return service.findById(id);
    }

    public List<Cliente> clientes() {
        return service.findAll();
    }

    public Cliente saveCliente(Cliente input) {
//        Cliente c = new Cliente();
//        c.setId(input.getId());
//        c.setNome(input.getNome());
//        c.setEmail(input.getEmail());
        ModelMapper m = new ModelMapper();
        Cliente c = m.map(input, Cliente.class);
        return service.save(c);
    }

    public Boolean deleteCliente(Long id) {
        return service.deleteById(id);
    }
}
