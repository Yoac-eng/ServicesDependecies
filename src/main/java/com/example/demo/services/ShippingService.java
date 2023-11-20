package com.example.demo.services;

import com.example.demo.entities.Order;
import org.springframework.stereotype.Service;

@Service
public class ShippingService {

    public double shipment(Order order){
        double orderBasic = order.getBasic();

        if (orderBasic < 100.00){
            return 20.00;
        }
        if (orderBasic < 200.00) {
            return 12.00;
        }

        return 0;
    }
}
