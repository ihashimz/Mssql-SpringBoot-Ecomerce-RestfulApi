package com.dbp.ecommapp.controller;

import com.dbp.ecommapp.entity.Order;
import com.dbp.ecommapp.exception.ResourceNotFoundException;
import com.dbp.ecommapp.repository.OrderRepository;
import com.github.javafaker.Faker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/orders")
public class OrderController {


    @Autowired
    private OrderRepository orderRepository ;


    /**
     * List all orders.
     * @return
     */

    @GetMapping("/")
    public List<Order> getAllOrder() {
        return orderRepository.findAll();
    }


    /**
     * Find a specific order by its id.
     *
     * @param orderId
     * @exception
     * @return
     */
    
    @GetMapping("/{id}")
    public ResponseEntity<Order> getEmployeeById(@PathVariable(value = "id") Long orderId)
            throws ResourceNotFoundException {
        Order order = orderRepository.findById(orderId)
                .orElseThrow(() -> new ResourceNotFoundException("Order not found for this id :: " + orderId));
        return ResponseEntity.ok().body(order);
    }


    /**
     * New order.
     *
     * @param order model
     * @return
     */
    
    @PostMapping("/")
    public Order creteOrder(@Valid @RequestBody Order order) {
        return orderRepository.save(order);
    }


    /**
     * Generate Fake order.
     *
     * @param faker
     * @return
     */
    
    @PostMapping("/fake")
    public Order creteOrder2(@Valid @RequestBody Order order) {

        Faker faker = new Faker();

        return orderRepository.save(order);
    }


    /**
     * Delete order by its id.
     *
     * @param orderId
     * @return
     */
    
    @DeleteMapping("/{id}")
    public Map<String, Boolean> deleteEmployee(@PathVariable(value = "id") Long orderId)
            throws ResourceNotFoundException {
        Order order = orderRepository.findById(orderId)
                .orElseThrow(() -> new ResourceNotFoundException("Order not found for this id :: " + orderId));

        orderRepository.delete(order);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return response;
    }
}
