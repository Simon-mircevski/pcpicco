package com.example.pcpicco.repository;

import com.example.pcpicco.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Integer> {
}
