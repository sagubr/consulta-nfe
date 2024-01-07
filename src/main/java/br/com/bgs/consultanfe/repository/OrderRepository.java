package br.com.bgs.consultanfe.repository;

import br.com.bgs.consultanfe.entities.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {

    @NonNull
    Order save (Order order);

}
