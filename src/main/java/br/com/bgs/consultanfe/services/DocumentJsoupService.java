package br.com.bgs.consultanfe.services;

import br.com.bgs.consultanfe.parser.DocumentParser;
import org.jsoup.HttpStatusException;
import org.jsoup.nodes.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigureOrder;
import org.springframework.stereotype.Service;

@Service
public class DocumentJsoupService {

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

        DocumentParser documentParser = new DocumentParser(document);
        issuerService.save(documentParser.getIssuer());
        orderService.save(documentParser.getOrder());
        productService.save(documentParser.getProducts());

    }
}
