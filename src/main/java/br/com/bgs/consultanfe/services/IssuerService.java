package br.com.bgs.consultanfe.services;

import br.com.bgs.consultanfe.entities.Issuer;
import br.com.bgs.consultanfe.repository.IssuerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class IssuerService {

    @Autowired
    IssuerRepository issuerRepository;

    public Issuer save(Issuer issuer){
        return issuerRepository.save(issuer);
    }

    public Issuer findByEnrolment(String enrolment){
        return issuerRepository.findByEnrolment(enrolment);
    }
}
