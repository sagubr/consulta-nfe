package br.com.bgs.consultanfe.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "issuers")
public class Issuer {

    @Id
    private Long id;
    private String name;
    private String enrolment;

}
