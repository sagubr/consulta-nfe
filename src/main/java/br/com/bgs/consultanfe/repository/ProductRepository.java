package br.com.bgs.consultanfe.repository;

import br.com.bgs.consultanfe.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

    @NonNull
    Product save(Product product);
}
