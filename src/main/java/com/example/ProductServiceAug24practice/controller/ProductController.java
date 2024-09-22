package com.example.ProductServiceAug24practice.controller;

import com.example.ProductServiceAug24practice.Services.ProductService;
import com.example.ProductServiceAug24practice.exception.ProductNotFoundException;
import com.example.ProductServiceAug24practice.models.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.HandlerExceptionResolver;

@RestController
public class ProductController {
    @Autowired
    private ProductService productService;
    @Qualifier("handlerExceptionResolver")
    @Autowired
    private HandlerExceptionResolver handlerExceptionResolver;
    @GetMapping("/products/{id}")
    public ResponseEntity<Product> getProductById(@PathVariable("id") long productId) throws ProductNotFoundException {

//        if(productId < 1 || productId > 20){
//            return new ResponseEntity<>(HttpStatusCode.valueOf(400));
//
//        }
            Product product=productService.getProductByid(productId);
            return new ResponseEntity<>(product, HttpStatusCode.valueOf(200));
    }
}
