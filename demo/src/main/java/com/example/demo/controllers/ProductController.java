package com.example.demo.controllers;


import com.example.demo.domain.product.Product;
import com.example.demo.domain.product.ProductRepository;
import com.example.demo.domain.product.RequestProductDTO;
import com.example.demo.domain.product.RequestProductPutDTO;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    private ProductRepository repository;


    @GetMapping     //requests data
    public ResponseEntity getAllProducts(){
        var allProducts = repository.findAll();
        return ResponseEntity.ok(allProducts);
    }

    @PostMapping    //Post data
    public ResponseEntity registerProduct(@RequestBody @Validated RequestProductDTO data){ //RequestProduct validates
        //DTO = data transfer Object
        Product newProduct = new Product(data);
        repository.save(newProduct);
        return ResponseEntity.ok().build(); //.build() necessario quando .ok()vazio
    }

    @PutMapping    //Not working yet
    @Transactional      // More than 1 command SQL (all of nothing)
    public ResponseEntity updateProduct(@RequestBody @Validated RequestProductPutDTO data){
        Optional<Product> optionalProduct = repository.findById(data.id());
        if(optionalProduct.isPresent()){
            Product product = optionalProduct.get();
            product.setName(data.name());
            product.setPrice_in_cents(data.price_in_cents());
            return ResponseEntity.ok(product);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    //geralmente não se deleta o dado permanentemente, mas se guarda para analytics ou restaurar versões
    @DeleteMapping("/{id}")     //The id is in the route
    public ResponseEntity deleteProduct(@PathVariable String id){
        repository.deleteById(id);
        return ResponseEntity.noContent().build();
    }

}
