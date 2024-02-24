package com.example.cardapio.domain.order.dto;

import lombok.Data;

@Data
public class Pagamento {
    private String formaPagamento;
    private String bandeira;
}
