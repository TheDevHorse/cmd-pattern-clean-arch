package com.thedevhorse.cmdpatterncleanarch.usecase;

import com.thedevhorse.cmdpatterncleanarch.domain.Order;

import java.util.UUID;

public interface OrderRepositoryOutputPort {

    void createOrder(Order order);

    void updateOrder(Order order);

    Order getOrder(UUID orderId);
}
