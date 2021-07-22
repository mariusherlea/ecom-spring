package ro.mariusherlea.ecom.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ro.mariusherlea.ecom.model.Order;
import ro.mariusherlea.ecom.model.User;
import ro.mariusherlea.ecom.model.repository.ItemRepository;
import ro.mariusherlea.ecom.model.repository.OrderRepository;

@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private ItemRepository itemRepository;

    public void calcul(Order order, User user){
        int d=user.getContinent();
//        if(order.getCostOfOrder()<100){
            switch (d){
                case 1:
                    order.setShipping(20d);
                    break;
                case 2:
                    order.setShipping(40d);
                    break;
            }
//        } else order.setShipping(null);

    }
}
