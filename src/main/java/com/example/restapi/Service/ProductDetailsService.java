package com.example.restapi.Service;

import com.example.restapi.Model.ProductDetails;

import java.util.List;

public interface ProductDetailsService {
    ProductDetails addDetails(ProductDetails productDetails);

    List<ProductDetails> getAllDetails();

    ProductDetails getProductDetailsById(Integer pDetailId);
    ProductDetails updateProductDetails(ProductDetails productDetails, Integer pDetailId);

    void deleteProductDetails(String productDetails, Integer pDetailId);

}
