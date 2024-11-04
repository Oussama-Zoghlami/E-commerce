package com.tekup.ecommerce.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "_product")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "product_id")
    private Integer idProduct;
    @Column(name = "product_name")
    private String name;
    @Column(name = "product_price")
    private double price;
    @Column(name = "product_description")
    private String description;
    @Column(name = "product_quantity")
    private Integer quantity;


    @ManyToOne
    @JoinColumn(name = "category_id") // Define foreign key column for category
    private Category category;

    @ManyToMany // Correct mapping
    @JoinTable(
            name = "product_ordre",
            joinColumns = @JoinColumn(name = "product_id"),
            inverseJoinColumns = @JoinColumn(name = "ordre_id")
    )
    private Set<Ordre> ordres;

    @ManyToOne
    @JoinColumn(name = "user_id") // Define foreign key column for user
    private User user;





}
