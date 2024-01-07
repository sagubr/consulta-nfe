package br.com.bgs.consultanfe.parser;

import br.com.bgs.consultanfe.entities.Issuer;
import br.com.bgs.consultanfe.entities.Order;
import br.com.bgs.consultanfe.entities.Product;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class DocumentParser {

    private final Document document;
    private Order order;
    private Issuer issuer;
    private List<Product> products = new ArrayList<>();

    public DocumentParser(Document document) {
        this.document = Jsoup.parse(String.valueOf(document));
        this.issuer = createIssuer();
        this.order = createOrder();
        this.products = createProducts();
    }

    private Issuer createIssuer() {

        Elements tables = this.document.select("table");
        Elements rows = tables.get(6).select("tbody > tr");
        Elements columns = rows.get(0).select("td");

        String name = columns.get(0).text();
        String enrolment = columns.get(1).text();

        return new Issuer(name, enrolment);

    }

    public Issuer getIssuer() {
        return issuer;
    }

    private Order createOrder() {

        Elements tables = this.document.select("table");
        Elements td = tables.get(4).select("td");

        String keyAccess = String.join("", Objects.requireNonNull(td.first())
                .text()
                .split("\\D+"));

        Elements rows = tables.get(8).select("tbody > tr");
        Elements column = rows.get(0).select("td");

        String date = column.get(3)
                .text()
                .trim();

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");

        return new Order(
                LocalDateTime.parse(date, formatter),
                this.issuer,
                false,
                keyAccess
        );

    }

    public Order getOrder() {
        return order;
    }

    private List<Product> createProducts() {

        Elements tables = this.document.select("table");
        Elements rows = tables.get(1).select("tbody > tr");

        for (Element row : rows) {

            Elements column = row.select("td");

            String description = column.get(0)
                    .text()
                    .trim();

            String quantity = column.get(1)
                    .text()
                    .split(":\\s*", 2)[1]
                    .trim();

            String unitOfMeasure = column.get(2)
                    .text()
                    .split(":\\s*", 2)[1]
                    .trim();

            String priceBeforeConvert = column.get(3)
                    .text()
                    .split(":\\s*")[1]
                    .replaceAll("[^\\d,]*", "")
                    .replace(",", ".").trim();

            double price = Double.parseDouble(priceBeforeConvert);

            products.add(new Product(
                    this.order,
                    description,
                    Double.valueOf(quantity),
                    unitOfMeasure,
                    BigDecimal.valueOf(price)
            ));

        }

        return products;
    }

    public List<Product> getProducts() {
        return products;
    }
}
