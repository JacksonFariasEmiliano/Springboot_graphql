package com.example.compras.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CompraInput {

    private Long id;
     private int quantidade;
    private String status;

    private Long clienteId;
    private Long produtoId;

}
