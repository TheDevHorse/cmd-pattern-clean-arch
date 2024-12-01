package com.thedevhorse.cmdpatterncleanarch.proxy;

import com.thedevhorse.cmdpatterncleanarch.domain.Order;
import com.thedevhorse.cmdpatterncleanarch.repository.OrderRepositoryImpl;
import com.thedevhorse.cmdpatterncleanarch.usecase.OrderProxyOutputPort;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class OrderProxyImpl implements OrderProxyOutputPort {

    private static final Logger logger = LoggerFactory.getLogger(OrderProxyImpl.class);

    @Override
    public void sendOrder(Order order) {
        logger.info("Processing sendOrder for Order ID: {}", order.orderId());
    }

    @Override
    public void cancelOrder(Order order) {
        logger.info("Processing cancelOrder for Order ID: {}", order.orderId());
    }
}