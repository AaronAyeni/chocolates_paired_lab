package com.bnta.chocolate.controllers;

import com.bnta.chocolate.models.Chocolate;
import com.bnta.chocolate.repositories.ChocolateRepository;
import com.bnta.chocolate.services.ChocolateService;
import com.bnta.chocolate.services.EstateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/chocolates")
public class ChocolateController {

    @Autowired
    ChocolateService chocolateService;

    @Autowired
    ChocolateRepository chocolateRepository;

//    INDEX localhost:8080/chocolates
    @GetMapping
    public ResponseEntity<List<Chocolate>> getAllChocolates(){
        List<Chocolate> chocolates = chocolateService.getAllChocolates();
        return new ResponseEntity<>(chocolates, HttpStatus.OK);
    }
}
