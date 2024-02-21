package com.example.cardapio.domain.order;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@Table(name = "order")
@Entity(name = "order")
@EqualsAndHashCode(of = "id")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    private String telefone;

    private String endereco;

    private Integer valorTotal;

}
