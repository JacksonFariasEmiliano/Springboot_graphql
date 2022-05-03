package com.example.compras.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Service;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CompraResumo {

    private Long compraId;
    private String cliente;
    private String produto;
    private int quantidade;
}
