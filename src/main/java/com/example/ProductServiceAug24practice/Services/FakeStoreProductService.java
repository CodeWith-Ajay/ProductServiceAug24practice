package com.example.ProductServiceAug24practice.Services;

import com.example.ProductServiceAug24practice.dto.FakeStoredto;
import com.example.ProductServiceAug24practice.exception.ProductNotFoundException;
import com.example.ProductServiceAug24practice.models.Product;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class FakeStoreProductService implements ProductService{
    @Override
    public Product getProductByid(long id) throws ProductNotFoundException {
        RestTemplate restTemplate = new RestTemplate();
        String url= "https://fakestoreapi.com/products/";
        FakeStoredto fakeStoredto = restTemplate.getForObject(url + id, FakeStoredto.class);
        if(fakeStoredto == null) {
            throw new ProductNotFoundException("Product with id "+id+" is not available in Database");

        }
        return convertfakestoreproducttoproduct(fakeStoredto);
    }

    private Product convertfakestoreproducttoproduct(FakeStoredto dto) {
        Product product = new Product();
        product.setCategory(dto.getCategory());
        product.setDescription(dto.getDescription());
        product.setName(dto.getTitle());
        return product;


    }
}
