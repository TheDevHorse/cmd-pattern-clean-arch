package com.thedevhorse.cmdpatterncleanarch.usecase;

import com.thedevhorse.cmdpatterncleanarch.domain.Order;

public interface OrderRepositoryOutputPort {

    void createOrder(Order order);

    void updateOrder(Order order);
}
