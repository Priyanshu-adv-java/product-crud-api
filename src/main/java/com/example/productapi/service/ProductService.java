package com.example.productapi.service;

import com.example.productapi.dto.ProductDTO;
import com.example.productapi.entity.Product;
import com.example.productapi.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

@Service
public class ProductService {
    private static final Logger logger =
            LoggerFactory.getLogger(ProductService.class);

    @Autowired
    private ProductRepository repository;

    public List<Product> getAllProducts() {
        return repository.findAll();
    }

    public Product getProductById(Long id) {
        logger.info("Fetching product with id {}", id);
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Product not found with id " + id));
    }

    public Product createProduct(ProductDTO dto) {
        logger.info("Creating product: {}", dto.getName());
        Product product = new Product();
        product.setName(dto.getName());
        product.setDescription(dto.getDescription());
        product.setPrice(dto.getPrice());
        product.setQuantity(dto.getQuantity());
        return repository.save(product);
    }

    public Product updateProduct(Long id, ProductDTO dto) {
        logger.info("Updating product with id {}", id);
        Product product = getProductById(id);
        product.setName(dto.getName());
        product.setDescription(dto.getDescription());
        product.setPrice(dto.getPrice());
        product.setQuantity(dto.getQuantity());
        return repository.save(product);
    }

    public void deleteProduct(Long id) {

        logger.info("Deleting product with id {}", id);

        repository.deleteById(id);
    }
}