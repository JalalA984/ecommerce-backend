package io.github.jalala984.ecommerce_backend.service;

import io.github.jalala984.ecommerce_backend.model.Product;
import io.github.jalala984.ecommerce_backend.repository.ProductDAO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    private final ProductDAO repo;

    public ProductService(ProductDAO repo) {
        this.repo = repo;
    }

    public List<Product> getAllProducts() {
        List<Product> products = repo.findAll();
        System.out.println("Products fetched: " + products); // Debugging
        return products;
    }

}
