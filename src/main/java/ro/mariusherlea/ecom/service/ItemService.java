package ro.mariusherlea.ecom.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ro.mariusherlea.ecom.model.Item;
import ro.mariusherlea.ecom.model.Order;
import ro.mariusherlea.ecom.model.OrderDetail;
import ro.mariusherlea.ecom.model.repository.ItemRepository;
import ro.mariusherlea.ecom.model.repository.OrderDetailRepository;

import java.util.List;

@Service
public class ItemService {

    @Autowired
    private ItemRepository itemRepository;

    public void calcul(Item item){

        item.setPriceToPay(item.getBasePrice() - item.getDiscount());
    }
}
