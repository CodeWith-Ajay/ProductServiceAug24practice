package com.example.ProductServiceAug24practice.Services;

import com.example.ProductServiceAug24practice.exception.ProductNotFoundException;
import com.example.ProductServiceAug24practice.models.Product;

public interface ProductService {

    public Product getProductByid(long id) throws ProductNotFoundException;

}
