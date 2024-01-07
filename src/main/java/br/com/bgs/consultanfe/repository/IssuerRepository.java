package br.com.bgs.consultanfe.repository;

import br.com.bgs.consultanfe.entities.Issuer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Repository;

@Repository
public interface IssuerRepository extends JpaRepository<Issuer, Long> {

    @NonNull
    Issuer save(Issuer issuer);

    Issuer findByEnrolment(String enrolment);
}
