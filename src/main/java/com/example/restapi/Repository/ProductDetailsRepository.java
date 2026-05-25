package com.example.restapi.Repository;

import com.example.restapi.Model.ProductDetails;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductDetailsRepository extends JpaRepository<ProductDetails,Integer> {
}
