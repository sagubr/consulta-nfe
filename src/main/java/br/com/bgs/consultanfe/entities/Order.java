package br.com.bgs.consultanfe.entities;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "orders")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDateTime date;
    @ManyToOne
    private Issuer issuer;
    private String keyAccess;

    public Order(LocalDateTime date, Issuer issuer, String keyAccess) {
        this.date = date;
        this.issuer = issuer;
        this.keyAccess = keyAccess;
    }

    public void setIssuer(Issuer issuer) {
        this.issuer = issuer;
    }

    public String getKeyAccess() {
        return keyAccess;
    }
}
