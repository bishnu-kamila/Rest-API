package com.example.restapi.Controller;

import com.example.restapi.Model.Product;
import com.example.restapi.Model.ProductDetails;
import com.example.restapi.Service.ProductService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;



@RestController
@AllArgsConstructor
public class ProductController {

    @Autowired
    private ProductService productService;


    @PostMapping("/")
    public ResponseEntity<Product> saveProduct(@RequestBody Product product){
        return new ResponseEntity<Product>(productService.saveProduct(product), HttpStatus.CREATED);
    }

    @GetMapping("/getAll")
    public List<Product> getAll(){
        return productService.getAll();
    }

    @GetMapping("/{productId}")
    public ResponseEntity<Product> getProductById(@PathVariable("productId")Integer productId){
        return new ResponseEntity<Product>(productService.getProductById(productId),HttpStatus.OK);
    }

    @PutMapping("/update/{productId}")
    public ResponseEntity<Product> updateProduct(@RequestBody Product product, @PathVariable("productId")Integer productId){
        return new ResponseEntity<Product>(productService.updateProduct(product, productId),HttpStatus.OK);
    }

    @DeleteMapping("/delete/{productId}")
    public ResponseEntity<String> deleteProduct(@RequestBody String product, @PathVariable("productId")Integer productId){
        productService.deleteProduct(product,productId);
        return new ResponseEntity<String>("Product Delete Successfully",HttpStatus.OK);
    }

 }
