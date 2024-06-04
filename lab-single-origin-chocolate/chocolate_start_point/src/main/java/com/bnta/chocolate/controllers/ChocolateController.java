package com.bnta.chocolate.controllers;

import com.bnta.chocolate.models.Chocolate;
import com.bnta.chocolate.repositories.ChocolateRepository;
import com.bnta.chocolate.services.ChocolateService;
import com.bnta.chocolate.services.EstateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/chocolates")
public class ChocolateController {

    @Autowired
    ChocolateService chocolateService;

    @Autowired
    ChocolateRepository chocolateRepository;

//    INDEX http://localhost:8080/chocolates/
//    Modified to merge both GET /chocolates and GET /chocolates?cocoaPercentage=? into one controller method,
    @GetMapping
    public ResponseEntity<List<Chocolate>> getAllChocolates(@RequestParam(required = false) Integer cocoaPercentage) {
        List<Chocolate> chocolates;
        if (cocoaPercentage != null) {
            chocolates = chocolateService.getChocolatesByCocoaPercentage(cocoaPercentage);
        } else {
            chocolates = chocolateService.getAllChocolates();
        }
        return new ResponseEntity<>(chocolates, HttpStatus.OK);
    }

//    SHOW http://localhost:8080/chocolates/{id}
    @GetMapping(value = "/{id}")
    public ResponseEntity<Chocolate> getChocolateById(@PathVariable Long id) {
        Optional<Chocolate> chocolate = chocolateService.getChocolateById(id);
        if (chocolate.isPresent()) {
            return new ResponseEntity<>(chocolate.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }




}
