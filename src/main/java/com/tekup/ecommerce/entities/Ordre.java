package com.tekup.ecommerce.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.Set;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "_ordre")
public class Ordre {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ordre_id")
    private Integer idOrdre;
    @Column(name = "total_amount")
    private Integer totalAmount;
    @Column(name = "ordre_date")
    private Date ordreDate;

    @ManyToMany
    @JoinTable(
            name = "product_ordre",
            joinColumns = @JoinColumn(name = "ordre_id"),
            inverseJoinColumns = @JoinColumn(name = "product_id")
    )
    private Set<Product> products;

    @ManyToOne
    @JoinColumn(name = "user_id") // Define foreign key column for user
    private User user;

    @OneToOne(mappedBy = "ordre", cascade = CascadeType.ALL)
    private Payment payment;




}
