package br.com.bgs.consultanfe.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "issuers")
public class Issuer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String enrolment;

    public Issuer(String name, String enrolment) {
        this.name = name;
        this.enrolment = enrolment;
    }
}
