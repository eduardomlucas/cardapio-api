package com.example.cardapio.controller;


import com.example.cardapio.domain.order.dto.OrderRequestDTO;
import com.example.cardapio.domain.order.dto.OrderResponseDTO;
import com.example.cardapio.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("order")
public class OrderController {

    @Autowired
    private OrderService service;

    // receber o dto
    @PostMapping
    @CrossOrigin(origins = "*", allowedHeaders = "*")
    public OrderResponseDTO makeOrder(@RequestBody OrderRequestDTO dto){
        return service.makeOrder(dto);
    }
}
