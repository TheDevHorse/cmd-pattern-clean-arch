package com.thedevhorse.cmdpatterncleanarch.usecase;

import com.thedevhorse.cmdpatterncleanarch.domain.Order;

public interface OrderProxyOutputPort {

    void sendOrder(Order order);
}
