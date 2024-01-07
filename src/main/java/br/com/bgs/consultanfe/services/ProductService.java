package br.com.bgs.consultanfe.services;

import br.com.bgs.consultanfe.entities.Product;
import br.com.bgs.consultanfe.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    @Autowired
    ProductRepository productRepository;

    public List<Product> save(List<Product> products) {
        return productRepository.saveAll(products);
    }

}

