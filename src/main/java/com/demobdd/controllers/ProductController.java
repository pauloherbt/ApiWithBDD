package com.demobdd.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {
    private List<String> products =List.of("Notebook","Television","CellPhone","Microwave");
    @GetMapping
    public List<String> findAll(){
      return products;
    }
    @GetMapping("/{name}")
    public String findByName(@PathVariable String name){
      return products.stream().filter((s)->s.equals(name)).findFirst().orElseThrow();
    }
}
