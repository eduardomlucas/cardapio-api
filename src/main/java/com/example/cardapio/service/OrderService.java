package com.example.cardapio.service;


import com.example.cardapio.domain.food.Food;
import com.example.cardapio.domain.food.FoodRepository;
import com.example.cardapio.domain.order.OrderRepository;
import com.example.cardapio.domain.order.dto.OrderRequestDTO;
import com.example.cardapio.domain.order.dto.OrderResponseDTO;
import com.example.cardapio.domain.order.dto.Pedido;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class OrderService {

    @Autowired
    private FoodRepository foodRepository;

    @Autowired
    private OrderRepository repository;

    public OrderResponseDTO makeOrder(OrderRequestDTO dto){

        Integer valorTotal = 0;
        List<String> itemsPedido = new ArrayList<>();

        System.out.println(dto);
        for(Pedido item :  dto.getPedido()){
            Food food = foodRepository.findById(item.getId()).get();
            itemsPedido.add(food.getTitle());

            Integer valorItems = item.getQuantity() * food.getPrice();

            valorTotal += valorItems;

        }

        // taxa de entrega
        if(dto.getEntrega().equals("casa")){
            valorTotal += 10;
        }

        String endereco = formataEndereco(dto.getEndereco().getLogradouro(),dto.getEndereco().getNumero(), dto.getEndereco().getComplemento());

        OrderResponseDTO response = new OrderResponseDTO();
        response.setEndereco(endereco);
        response.setNome(dto.getNome());
        response.setTotal(valorTotal);
        response.setTelefone(dto.getTelefone());
        response.setFormaPagamento(dto.getPagamento());
        response.setItems(itemsPedido);

        response.setOrderId(Long.valueOf(1));

        return response;
    }

    private String formataEndereco(String logradouro, String numero, String complemento) {
        return logradouro + " - " + numero + " | Complemento: "+complemento;
    }
}
