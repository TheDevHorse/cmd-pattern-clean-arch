package com.thedevhorse.cmdpatterncleanarch.controller;

import com.thedevhorse.cmdpatterncleanarch.usecase.OrderUseCaseInputPort;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/order")
public class OrderController {

    private final OrderUseCaseInputPort orderUseCaseInputPort;

    public OrderController(OrderUseCaseInputPort orderUseCaseInputPort) {
        this.orderUseCaseInputPort = orderUseCaseInputPort;
    }

    @PostMapping
    public void createOrder() {

    }

    @PutMapping
    public void updateOrder() {

    }
}
