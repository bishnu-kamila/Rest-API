package com.example.restapi.Controller;

import com.example.restapi.Model.Product;
import com.example.restapi.Model.ProductDetails;
import com.example.restapi.Service.ProductDetailsService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pDetails")
@AllArgsConstructor
public class ProductDetailsController {

    @Autowired
    private ProductDetailsService productDetailsService;


    @PostMapping("/add")
    public ResponseEntity<ProductDetails> addDetails(@RequestBody ProductDetails productDetails){
        return new ResponseEntity<ProductDetails>(productDetailsService.addDetails(productDetails), HttpStatus.CREATED);
    }

    @GetMapping("/getAll")
    public List<ProductDetails> getAllDetails(){
        return productDetailsService.getAllDetails();
    }

    @GetMapping("/{pDetailId}")
    public ResponseEntity<ProductDetails> getProduct(@PathVariable("pDetailId")Integer pDetailId){
        return new ResponseEntity<ProductDetails>(productDetailsService.getProductDetailsById(pDetailId),HttpStatus.OK);
    }

    @PutMapping("/updateDetails/{pDetailId}")
    public ResponseEntity<ProductDetails> updateProductDetails(@RequestBody ProductDetails productDetails, @PathVariable("pDetailId")Integer pDetailId){
        return new ResponseEntity<ProductDetails>(productDetailsService.updateProductDetails(productDetails, pDetailId),HttpStatus.OK);
    }

    @DeleteMapping("/deleteDetails/{pDetailId}")
    public ResponseEntity<String> deleteProductDetails(@RequestBody String productDetails, @PathVariable("pDetailId")Integer pDetailId){
        productDetailsService.deleteProductDetails(productDetails,pDetailId);
        return new ResponseEntity<String>("Product Details Delete Successfully",HttpStatus.OK);
    }


}
