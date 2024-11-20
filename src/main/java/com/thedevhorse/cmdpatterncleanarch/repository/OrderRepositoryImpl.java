package com.thedevhorse.cmdpatterncleanarch.repository;

import com.thedevhorse.cmdpatterncleanarch.domain.Order;
import com.thedevhorse.cmdpatterncleanarch.usecase.OrderRepositoryOutputPort;
import org.springframework.stereotype.Component;

@Component
public class OrderRepositoryImpl implements OrderRepositoryOutputPort {

    @Override
    public void createOrder(Order order) {
        throw new UnsupportedOperationException("createOrder is not implemented yet.");
    }

    @Override
    public void updateOrder(Order order) {
        throw new UnsupportedOperationException("updateOrder is not implemented yet.");
    }
}
