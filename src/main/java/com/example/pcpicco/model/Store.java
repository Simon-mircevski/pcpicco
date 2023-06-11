package com.example.pcpicco.model;

import lombok.Data;

import javax.persistence.*;
@Data
@Entity
@Table(name = "stores")
public class Store {
    @Id
    private String store_name;

    private String name;

    private String locations;

    private String contact;

    public Store(String store_name, String locations, String contact){
        this.store_name = store_name;
        this.locations = locations;
        this.contact = contact;
    }

    public Store() {

    }
}