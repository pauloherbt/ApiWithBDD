package com.demobdd.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping(value = "/products")
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
