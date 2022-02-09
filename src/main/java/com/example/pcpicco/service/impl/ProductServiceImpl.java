package com.example.pcpicco.service.impl;

import com.example.pcpicco.model.Product;
import com.example.pcpicco.model.Store;
import com.example.pcpicco.repository.ProductRepository;
import com.example.pcpicco.service.ProductService;
import org.springframework.stereotype.Service;

@Service
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;

    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public Product save( String name, String description, Integer price, String type, Integer quantity, Store store) {
        Product product = new Product( name,description, price, type, quantity, store);
        return this.productRepository.save(product);
    }
}
