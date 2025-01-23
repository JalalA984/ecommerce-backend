package io.github.jalala984.ecommerce_backend.service;

import io.github.jalala984.ecommerce_backend.model.Product;
import io.github.jalala984.ecommerce_backend.repository.ProductDAO;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
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

    public Product getProductById(int prodId) {
        return repo.findById(prodId).orElse(null);
    }

    public Product addProduct(Product product, MultipartFile imageFile) throws IOException {
        product.setImageName(imageFile.getName());
        product.setImageType(imageFile.getContentType());
        product.setImageData(imageFile.getBytes());
        return repo.save(product);
    }
}
