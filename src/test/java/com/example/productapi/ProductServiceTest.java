package com.example.productapi;

import com.example.productapi.dto.ProductDTO;
import com.example.productapi.entity.Product;
import com.example.productapi.repository.ProductRepository;
import com.example.productapi.service.ProductService;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class ProductServiceTest {

    @Mock
    private ProductRepository repository;

    @InjectMocks
    private ProductService service;

    @Test
    void createProductTest() {

        ProductDTO dto = new ProductDTO();
        dto.setName("Laptop");
        dto.setDescription("Gaming Laptop");
        dto.setPrice(50000);
        dto.setQuantity(2);

        Product savedProduct = new Product();
        savedProduct.setName("Laptop");

        when(repository.save(any(Product.class)))
                .thenReturn(savedProduct);

        Product result = service.createProduct(dto);

        assertEquals("Laptop", result.getName());
        verify(repository, times(1)).save(any(Product.class));
    }

    @Test
    void deleteProductTest() {

        Long id = 1L;

        service.deleteProduct(id);

        verify(repository, times(1)).deleteById(id);
    }
}