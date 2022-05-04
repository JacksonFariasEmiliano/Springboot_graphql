package com.example.compras.graphql;

import com.example.compras.domain.Cliente;
import com.fasterxml.jackson.core.io.JsonEOFException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.graphql.spring.boot.test.GraphQLResponse;
import com.graphql.spring.boot.test.GraphQLTestTemplate;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.IOException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class ClienteGraphQlTest extends GraphQLTestTemplate {

    @Test
    void testClientes() throws IOException, JSONException {

        GraphQLResponse response = perform ("cliente.graphql", null);

        assertTrue(response.isOk());

        String json = response.getRawResponse().getBody();
        System.out.println("Body: " + json);

        JSONArray jC = new JSONObject(json).getJSONObject("data").getJSONArray("clientes");
        System.out.println(jC);

        ObjectMapper mapper = new ObjectMapper();

        List<Cliente> clientes = mapper.readValue(jC.toString(), new TypeReference<List<Cliente>>(){});

        clientes.forEach(cliente -> System.out.println(cliente.getNome()));
    }

    @Test
    void clientes() {
    }

    @Test
    void saveCliente() {
    }

    @Test
    void deleteCliente() {
    }
}