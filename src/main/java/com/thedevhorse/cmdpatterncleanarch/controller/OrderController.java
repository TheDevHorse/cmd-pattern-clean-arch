package com.thedevhorse.cmdpatterncleanarch.controller;

import com.thedevhorse.cmdpatterncleanarch.controller.dto.OrderRequest;
import com.thedevhorse.cmdpatterncleanarch.domain.Order;
import com.thedevhorse.cmdpatterncleanarch.domain.Status;
import com.thedevhorse.cmdpatterncleanarch.usecase.OrderUseCaseInputPort;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/order")
public class OrderController {

    private final Map<String, OrderUseCaseInputPort> orderUseCaseInputPort;

    public OrderController(Map<String, OrderUseCaseInputPort> orderUseCaseInputPort) {
        this.orderUseCaseInputPort = orderUseCaseInputPort;
    }

    @PostMapping
    public void createOrder(OrderRequest orderRequest) {
        orderUseCaseInputPort.get(orderRequest.status().name())
                .execute(
                        mapToOrder(orderRequest)
                );
    }

    @PutMapping()
    public void updateOrder(OrderRequest orderRequest) {
        orderUseCaseInputPort.get(orderRequest.status().name())
                .execute(
                        mapToOrder(orderRequest)
                );
    }

    private Order mapToOrder(OrderRequest orderRequest) {
        return  Order.create(
                orderRequest.orderId(),
                orderRequest.status()
        );
    }
}
