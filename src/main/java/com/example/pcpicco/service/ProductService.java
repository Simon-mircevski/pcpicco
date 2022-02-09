package com.example.pcpicco.service;

import com.example.pcpicco.model.Product;
import com.example.pcpicco.model.Store;

public interface ProductService {
    Product save(String name, String description, Integer price, String type, Integer quantity, Store store);
}
