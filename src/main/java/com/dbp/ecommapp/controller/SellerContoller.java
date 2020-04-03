package com.dbp.ecommapp.controller;

import com.dbp.ecommapp.entity.Seller;
import com.dbp.ecommapp.exception.ResourceNotFoundException;
import com.dbp.ecommapp.repository.SellerRepository;
import com.github.javafaker.Faker;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/sellers")



public class SellerContoller {



    @Autowired
    private SellerRepository sellerRepository ;
    

    
    private BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();


    /**
     * List all sellers.
     *
     * @param  seller model
     * @return
     */

    @GetMapping("/")
    public List<Seller> getAllSeller() {
        return sellerRepository.findAll();
    }


    /**
     * Find a specific seller by its id.
     *
     * @param id
     * @param handle error
     * @return
     */
    
    @GetMapping("/{id}")
    public ResponseEntity<Seller> getEmployeeById(@PathVariable(value = "id") Long sellerId)
            throws ResourceNotFoundException {
        Seller seller = sellerRepository.findById(sellerId)
                .orElseThrow(() -> new ResourceNotFoundException("Seller not found for this id :: " + sellerId));
        return ResponseEntity.ok().body(seller);
    }


    /**
     * New seller.
     *
     * @param seller model
     * @return
     */

    @PostMapping(value = "/" , consumes = {"application/json", "multipart/form-data" })
    public Seller insertSeller(@Valid @ModelAttribute Seller seller) {

        seller.setPassword(passwordEncoder.encode(seller.getPassword()));
        return sellerRepository.save(seller);
    }


    /**
     * Generate Fake seller.
     *
     * @param faker
     * @return
     */

    @PostMapping("/fake")
    public Seller insertSeller2() {
        Faker faker = new Faker();
        Seller seller = new Seller();
        seller.setFirstName(faker.name().firstName());
        seller.setLastName(faker.name().lastName());
        seller.setSellerEmail(faker.bothify(faker.funnyName().name().replaceAll("\\s+","").toLowerCase()+"@gmail.com"));
        seller.setSellerMobile(faker.bothify("9665########"));
        seller.setCity(faker.address().city());
        seller.setAddress(faker.address().fullAddress());
        seller.setPassword(passwordEncoder.encode("123456789"));
        return sellerRepository.save(seller);
    }

    /**
     * Delete seller by its id.
     *
     * @param id
     * @return
     */

    @DeleteMapping("/{id}")
    public Map<String, Boolean> deleteEmployee(@PathVariable(value = "id") Long sellerId)
            throws ResourceNotFoundException {
        Seller seller = sellerRepository.findById(sellerId)
                .orElseThrow(() -> new ResourceNotFoundException("Seller not found for this id :: " + sellerId));

        sellerRepository.delete(seller);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return response;
    }

}


