package com.example.restapi.Service;

import com.example.restapi.Model.Product;
import com.example.restapi.Model.ProductDetails;
import com.example.restapi.Repository.ProductDetailsRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class ProductdetailsServiceImplementation implements ProductDetailsService{



    @Autowired
    ProductDetailsRepository productDetailsRepository;

    @Override
    public ProductDetails addDetails(ProductDetails productDetails) {
        return productDetailsRepository.save(productDetails);
    }

    @Override
    public List<ProductDetails> getAllDetails() {
        return productDetailsRepository.findAll();
    }

    @Override
    public ProductDetails getProductDetailsById(Integer pDetailId) {
        Optional<ProductDetails> productDetails = productDetailsRepository.findById(pDetailId);
        if(productDetails.isPresent()){
            return productDetails.get();
        }else{
            throw new RuntimeException();
        }
    }

    @Override
    public ProductDetails updateProductDetails(ProductDetails productDetails, Integer pDetailId) {
        ProductDetails pd = productDetailsRepository.findById(pDetailId).orElseThrow(()->new RuntimeException("Id Not Found"));
        pd.setPFeature(productDetails.getPFeature());
        pd.setPValidity(productDetails.getPValidity());
        pd.setPComposition(productDetails.getPComposition());
        productDetailsRepository.save(pd);
        return pd;
    }

    @Override
    public void deleteProductDetails(String productDetails, Integer pDetailId) {
        ProductDetails delProduct = productDetailsRepository.findById(pDetailId).orElseThrow(()->new RuntimeException());
        productDetailsRepository.delete(delProduct);
    }
}
