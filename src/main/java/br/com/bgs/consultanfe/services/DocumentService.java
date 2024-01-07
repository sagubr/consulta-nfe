package br.com.bgs.consultanfe.services;

import br.com.bgs.consultanfe.entities.Issuer;
import br.com.bgs.consultanfe.entities.Order;
import br.com.bgs.consultanfe.parser.DocumentJsoupParser;
import org.jsoup.HttpStatusException;
import org.jsoup.nodes.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DocumentService {

    @Autowired
    RequestJsoupService requestJsoupService;

    @Autowired
    ProductService productService;

    @Autowired
    IssuerService issuerService;

    @Autowired
    OrderService orderService;

    public void getDocument(String url) throws HttpStatusException {

        Document document = requestJsoupService.requestAddress(url);
        DocumentJsoupParser documentJsoupParser = new DocumentJsoupParser(document);

        Order order = orderService.findByKeyAccess(documentJsoupParser.getOrder().getKeyAccess());
        if(order != null){
            throw new RuntimeException("""
        Chave de acesso já cadastrada: %s
        """ + order.getKeyAccess());
        }

        Issuer issuer = issuerService.findByEnrolment(documentJsoupParser.getIssuer().getEnrolment());
        if(issuer != null){
            documentJsoupParser.getOrder().setIssuer(issuer);
        }else{
            issuerService.save(documentJsoupParser.getIssuer());
        }

        orderService.save(documentJsoupParser.getOrder());
        productService.save(documentJsoupParser.getProducts());

    }

}
