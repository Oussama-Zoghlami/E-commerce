package com.tekup.ecommerce.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

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

}
