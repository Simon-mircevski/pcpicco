package com.example.pcpicco.model;

import lombok.Data;

import javax.persistence.*;


@Entity
@Data
@Table(name = "products", schema = "project")
public class Product {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "prod_id", nullable = false)
    private Integer id;

    private Boolean availability = true;

    private String name;

    private String description;

    private Integer price;

    private String type;

    private Integer quantity;

    private String url;

    @ManyToOne
    private Store storeName;

    public Product(){}

    public Product(String name, String description, Integer price, String type, Integer quantity, Store storeName) {
        this.availability = availability;
        this.name = name;
        this.description = description;
        this.price = price;
        this.type = type;
        this.quantity = quantity;
        this.storeName = storeName;
        this.url = url;
    }


}