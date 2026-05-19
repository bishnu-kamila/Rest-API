package com.example.restapi.Service;

import com.example.restapi.Model.Product;
import com.example.restapi.Repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImplementation implements ProductService{

    ProductRepository productRepository;

    @Autowired
    public ProductServiceImplementation(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public Product saveProduct(Product product) {
        return productRepository.save(product);
    }

    @Override
    public List<Product> getAll() {
        return productRepository.findAll();
    }

    @Override
    public Product getProductById(Integer productId) {
        Optional<Product> product = productRepository.findById(productId);
        if(product.isPresent()){
            return product.get();
        }else{
            throw new RuntimeException("Data not found");
        }
    }

    @Override
    public Product updateProduct(Product product, Integer productId) {
        Product updateProduct = productRepository.findById(productId).orElseThrow(()->new RuntimeException());
        updateProduct.setProductName(product.getProductName());
        updateProduct.setProductDescription(product.getProductDescription());
        updateProduct.setPrice(product.getPrice());
        productRepository.save(updateProduct);
        return updateProduct;
    }

    @Override
    public void deleteProduct(String product, Integer productId) {
        Product delProduct = productRepository.findById(productId).orElseThrow(()->new RuntimeException());
        productRepository.delete(delProduct);
    }
}
