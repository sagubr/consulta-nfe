package br.com.bgs.consultanfe.services;

import br.com.bgs.consultanfe.entities.Address;
import org.jsoup.HttpStatusException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;


@Service
public class InspectorService {

    @Autowired
    private DocumentJsoupService documentJsoupService;

    public ResponseEntity<String> processUrl(Address address) {
        try {
            documentJsoupService.getDocument(
                    address.getUrl().replace("|", "%7C")
            );
            return ResponseEntity.status(HttpStatus.ACCEPTED).body("URL processada com sucesso: " + address.getUrl());
        } catch (HttpStatusException ex) {
            ex.printStackTrace();

            if (ex.getStatusCode() == HttpStatus.NOT_FOUND.value()) {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("URL não encontrada: " + address.getUrl());
            } else {
                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Erro ao processar a URL: " + address.getUrl());
            }
        } catch (Exception e) {

            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Erro interno ao processar a URL: " + address.getUrl());
        }
    }
}
