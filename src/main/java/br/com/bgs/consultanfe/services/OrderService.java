package br.com.bgs.consultanfe.services;

import br.com.bgs.consultanfe.entities.Order;
import br.com.bgs.consultanfe.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderService {

    @Autowired
    OrderRepository orderRepository;

    public void save(Order order){
        orderRepository.save(order);
    }

}
