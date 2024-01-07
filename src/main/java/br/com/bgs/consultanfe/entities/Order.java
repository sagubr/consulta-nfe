package br.com.bgs.consultanfe.entities;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "orders")
public class Order {

    @Id
    private Long id;
    private LocalDate date;
    @Enumerated(EnumType.STRING)
    private Payment payment;
    @ManyToOne
    private Issuer issuer;
    private boolean validated;
    private String keyAccess;

}
