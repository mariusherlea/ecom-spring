package ro.mariusherlea.ecom.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ro.mariusherlea.ecom.model.Item;
import ro.mariusherlea.ecom.model.Order;
import ro.mariusherlea.ecom.model.OrderDetail;
import ro.mariusherlea.ecom.model.repository.OrderDetailRepository;

import java.util.List;

@Service
public class OrderDetailService {

    @Autowired
    private OrderDetailRepository orderDetailRepository;

    public void calcul(OrderDetail orderDetail, Item item, Order order){
        orderDetail.setPriceOfItemOrdered(item.getPriceToPay() * orderDetail.getItemQuantityOrdered());

        List<OrderDetail> orderDetails = orderDetailRepository.findByOrderId(order.getId());
        double sum = 0D;
        for (OrderDetail op : orderDetails) {
            sum += op.getPriceOfItemOrdered();
        }
        order.setCostOfOrder(sum);
    }
}
