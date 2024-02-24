package com.example.cardapio.domain.order.dto;

import lombok.Data;

import java.util.List;

@Data
public class OrderResponseDTO {

    private Long orderId;
    private String nome;
    private String telefone;
    private String endereco;
    private List<String> items;
    private Pagamento formaPagamento;
    private Integer total;
}
