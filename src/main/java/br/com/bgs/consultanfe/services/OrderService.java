package br.com.bgs.consultanfe.services;

import br.com.bgs.consultanfe.entities.Order;
import br.com.bgs.consultanfe.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderService {

    @Autowired
    OrderRepository orderRepository;

    public Order save(Order order){
        return orderRepository.save(order);
    }

    public Order findByKeyAccess(String keyAccess){
        return orderRepository.findByKeyAccess(keyAccess);
    }

}
