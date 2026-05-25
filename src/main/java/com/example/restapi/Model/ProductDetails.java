package com.example.restapi.Model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class ProductDetails {
    @Id
    private int pDetailId;
    @Column(name = "pFeature")
    private String pFeature;
    @Column(name = "pValidity")
    private String pValidity;
    @Column(name = "pComposition")
    private String pComposition;


}
