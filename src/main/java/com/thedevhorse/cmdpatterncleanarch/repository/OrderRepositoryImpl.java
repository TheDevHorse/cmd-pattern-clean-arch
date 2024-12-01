package com.thedevhorse.cmdpatterncleanarch.repository;

import com.thedevhorse.cmdpatterncleanarch.domain.Order;
import com.thedevhorse.cmdpatterncleanarch.domain.Status;
import com.thedevhorse.cmdpatterncleanarch.usecase.OrderRepositoryOutputPort;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class OrderRepositoryImpl implements OrderRepositoryOutputPort {

    private static final Logger logger = LoggerFactory.getLogger(OrderRepositoryImpl.class);

    @Override
    public void createOrder(Order order) {
        logger.info("Creating order with ID: {}", order.orderId());
    }

    @Override
    public void updateOrder(Order order) {
        logger.info("Updating order with ID: {}", order.orderId());
    }

    @Override
    public Order getOrder(UUID orderId) {
        return Order.create(
                orderId,
                Status.IN_PROGRESS,
                100.0
        );
    }
}
