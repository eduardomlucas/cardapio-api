package com.example.cardapio.domain.order.dto;

import lombok.Data;

import java.util.List;

@Data
public class OrderRequestDTO {

    private String nome;
    private String telefone;
    private String entrega;
    private Endereco endereco;
    private Pagamento pagamento;
    private List<Pedido> pedido;

}
