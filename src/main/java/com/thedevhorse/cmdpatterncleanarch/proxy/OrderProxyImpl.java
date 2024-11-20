package com.thedevhorse.cmdpatterncleanarch.proxy;

import com.thedevhorse.cmdpatterncleanarch.domain.Order;
import com.thedevhorse.cmdpatterncleanarch.usecase.OrderProxyOutputPort;
import org.springframework.stereotype.Component;

@Component
public class OrderProxyImpl implements OrderProxyOutputPort {

    @Override
    public void sendOrder(Order order) {
        throw new UnsupportedOperationException("sendOrder is not implemented yet.");
    }

    @Override
    public void cancelOrder(Order order) {
        throw new UnsupportedOperationException("cancel is not implemented yet.");
    }
}