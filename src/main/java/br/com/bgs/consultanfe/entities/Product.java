package br.com.bgs.consultanfe.entities;

import jakarta.persistence.*;

import java.math.BigDecimal;

@Entity
@Table(name = "products")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @ManyToOne
    private Order order;
    private String description;
    private double quantity;
    private String unitOfMeasure;

    private BigDecimal price;

}
