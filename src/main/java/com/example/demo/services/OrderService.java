package com.example.demo.services;

import com.example.demo.entities.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderService {

    @Autowired
    private ShippingService shippingService;

    public double total(Order order){
        double basicCost = order.getBasic();
        double effectiveDiscount = order.getBasic() * order.getDiscount()/100;
        double shipmentDiscount = shippingService.shipment(order);

        double totalValue = basicCost - effectiveDiscount + shipmentDiscount;

        return totalValue;
    }
}
