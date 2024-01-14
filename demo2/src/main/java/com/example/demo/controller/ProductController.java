package com.example.demo.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.example.demo.model.Product;
import com.example.demo.model.User;


@RestController
public class ProductController implements CommandLineRunner {
	private List<Product> products = new ArrayList<Product>();
	private final RestTemplate restTemplate;
	@Override
    public void run(String... args)  {
        products.add(new Product(1, 10));
        products.add(new Product(2, 10));
    }
    @Autowired
    public ProductController(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }
    @GetMapping("/products")
    public List<Product> getAllProducts() {
        return products;
    }
    
    @GetMapping("/products/{id}")
    public Product getProductById(@PathVariable int id) {
        // Get the product by ID
        Product product = products.stream()
                                  .filter(p -> p.getId() == id)
                                  .findFirst()
                                  .orElse(null);

        if (product != null) {
            // Use RestTemplate to fetch a User and associate it with the product
            User user = restTemplate.getForObject("http://localhost:8080/user/"+id, User.class, product.getId());
            product.setUerUser(user);
        }

        return product;
    }
}
