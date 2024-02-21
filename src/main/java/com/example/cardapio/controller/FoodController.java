package com.example.cardapio.controller;

import com.example.cardapio.domain.food.Food;
import com.example.cardapio.domain.food.FoodRepository;
import com.example.cardapio.domain.food.FoodRequestDTO;
import com.example.cardapio.domain.food.FoodResponseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("food")
public class FoodController {

    @Autowired
    private FoodRepository repository;

    @PostMapping
    @CrossOrigin(origins = "*", allowedHeaders = "*")
    public void saveFood(@RequestBody FoodRequestDTO data){
        Food foodData = new Food(data);
        repository.save(foodData);
    }

    @GetMapping
    @CrossOrigin(origins = "*", allowedHeaders = "*")
    public List<FoodResponseDTO> getAll(){

        List<FoodResponseDTO> foodList = repository.findAll().stream().map(FoodResponseDTO::new).toList();
        return foodList;
    }
}
