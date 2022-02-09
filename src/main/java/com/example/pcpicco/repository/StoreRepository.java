package com.example.pcpicco.repository;

import com.example.pcpicco.model.Store;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StoreRepository extends JpaRepository<Store, String> {
    Store findByName(String name);
}
