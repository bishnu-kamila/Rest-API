package com.example.restapi.Controller;

import com.example.restapi.Model.Product;
import com.example.restapi.Repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthController {
    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private PasswordEncoder encoder;

    @PostMapping("/register")
    public String register(@RequestBody Product product){
        product.setPassword(encoder.encode(product.getPassword()));
        productRepository.save(product);

        return "User Registration Successfull";
    }

    @GetMapping("/home")
    public String home(){
        return "Welcome Secure API";
    }
}
