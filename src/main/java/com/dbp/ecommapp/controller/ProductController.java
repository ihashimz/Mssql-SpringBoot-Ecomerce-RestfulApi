package com.dbp.ecommapp.controller;


import com.dbp.ecommapp.entity.Product;
import com.dbp.ecommapp.exception.ResourceNotFoundException;
import com.dbp.ecommapp.repository.ProductRepository;

import com.github.javafaker.Faker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Product controller.
 */

@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    private ProductRepository productRepository ;


    /**
     * List all products.
     *
     * @param  proudct model
     * @return
     */

    @GetMapping("/")
    public List<Product> getAllProduct() {
        return productRepository.findAll();
    }


    /**
     * Find a specific product by its id.
     *
     * @param id
     * @param handle error
     * @return
     */

    @GetMapping("/{id}")
    public ResponseEntity<Product> getEmployeeById(@PathVariable(value = "id") Long productId)
            throws ResourceNotFoundException {
        Product product = productRepository.findById(productId)
                .orElseThrow(() -> new ResourceNotFoundException("Product not found for this id :: " + productId));
        return ResponseEntity.ok().body(product);
    }


    /**
     * New product.
     *
     * @param product model
     * @return
     */

    @PostMapping(value = "/" , consumes = {"application/json", "multipart/form-data" })
    public Product createProudct(@Valid @ModelAttribute Product product) {
        return productRepository.save(product);
    }


    /**
     * Generate Fake product.
     *
     * @param faker
     * @return
     */

    @PostMapping("/fake")
    public Product createProduct2() {
        Faker faker = new Faker();
        Product product = new Product();
        product.setProductName(faker.book().title());
        product.setDescr(faker.book().publisher()+", "+faker.book().author());
        product.setType("books");
        product.setPrice((double) faker.number().numberBetween(1,2500));
        product.setProduct_qnt(faker.number().numberBetween(0,80));
        product.setSellerId((long)33);
        return productRepository.save(product);
    }


    /**
     * Delete product by its id.
     *
     * @param id
     * @return
     */

    @DeleteMapping("/{id}")
    public Map<String, Boolean> deleteEmployee(@PathVariable(value = "id") Long productId)
            throws ResourceNotFoundException {
        Product product = productRepository.findById(productId)
                .orElseThrow(() -> new ResourceNotFoundException("Product not found for this id :: " + productId));

        productRepository.delete(product);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return response;
    }

}
