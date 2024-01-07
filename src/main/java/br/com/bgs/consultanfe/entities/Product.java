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
    private Double quantity;
    private String unitOfMeasure;
    private BigDecimal price;

    public Product(Order order, String description, Double quantity, String unitOfMeasure, BigDecimal price) {
        this.order = order;
        this.description = description;
        this.quantity = quantity;
        this.unitOfMeasure = unitOfMeasure;
        this.price = price;
    }

    public void setOrder(Order order) {
        this.order = order;
    }
}
