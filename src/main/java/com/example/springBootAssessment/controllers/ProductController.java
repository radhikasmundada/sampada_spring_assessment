package com.example.springBootAssessment.controllers;

import com.example.springBootAssessment.models.Product;
import com.example.springBootAssessment.services.ProductsService;
import com.example.springBootAssessment.utilities.ResponseHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/products")
public class ProductController {

    @Autowired
    private ProductsService productsService;

    @GetMapping("/")
    public ResponseEntity<Object> getAll(){
        return ResponseHandler.createResponse("Found Products", HttpStatus.OK, productsService.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> getItem(@PathVariable Long id){
        return ResponseHandler.createResponse("product found", HttpStatus.OK, productsService.getItem(id));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Object> delete(@PathVariable Long id){
        return ResponseHandler.createResponse("product deleted", HttpStatus.OK, productsService.delete(id));
    }

    @PostMapping("/add")
    public ResponseEntity<Object> create(@RequestBody Product product){
        return ResponseHandler.createResponse("product added", HttpStatus.CREATED, productsService.create(product));
    }

    @PutMapping("/update")
    public  Object update(@RequestBody Product product){
        return ResponseHandler.createResponse("product updated", HttpStatus.OK, productsService.update(product));
    }

}
