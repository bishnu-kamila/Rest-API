package com.example.restapi.Service;

import com.example.restapi.Model.Product;

import java.util.List;

public interface ProductService {
    Product saveProduct(Product product);

    List<Product> getAll();

    Product getProductById(Integer productId);

    Product updateProduct(Product product, Integer productId);

    void deleteProduct(String product,Integer productId);
}
