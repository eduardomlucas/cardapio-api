package com.example.cardapio.domain.order.dto;

import com.example.cardapio.domain.food.Food;
import lombok.Data;

import java.util.List;

@Data
public class OrderResponseDTO {

    private Long orderId;
    private String nome;
    private String telefone;
    private String endereco;
    private List<String> items;
    private FormaPagamento formaPagamento;
    private Integer total;
}
