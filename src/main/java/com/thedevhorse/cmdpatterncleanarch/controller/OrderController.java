package com.thedevhorse.cmdpatterncleanarch.controller;

import com.thedevhorse.cmdpatterncleanarch.controller.dto.OrderRequest;
import com.thedevhorse.cmdpatterncleanarch.domain.Order;
import com.thedevhorse.cmdpatterncleanarch.usecase.OrderUseCaseInputPort;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/order")
public class OrderController {

    private final Map<String, OrderUseCaseInputPort> orderUseCaseInputPortMap;

    public OrderController(Map<String, OrderUseCaseInputPort> orderUseCaseInputPort) {
        this.orderUseCaseInputPortMap = orderUseCaseInputPort;
    }

    @PostMapping
    public void createOrder(@RequestBody OrderRequest orderRequest) {
        orderUseCaseInputPortMap.get(orderRequest.status().name())
                .execute(
                        mapToOrder(orderRequest)
                );
    }

    @PutMapping()
    public void updateOrder(@RequestBody OrderRequest orderRequest) {
        orderUseCaseInputPortMap.get(orderRequest.status().name())
                .execute(
                        mapToOrder(orderRequest)
                );
    }

    private Order mapToOrder(OrderRequest orderRequest) {
        return  Order.create(
                orderRequest.orderId(),
                orderRequest.status(),
                orderRequest.price()
        );
    }
}
