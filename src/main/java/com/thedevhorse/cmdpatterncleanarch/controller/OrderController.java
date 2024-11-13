package com.thedevhorse.cmdpatterncleanarch.controller;

import com.thedevhorse.cmdpatterncleanarch.domain.Order;
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
    public void createOrder() {
        orderUseCaseInputPort.get("IN_PROGRESS").execute(new Order());
    }

    @PutMapping("/{command}")
    public void updateOrder(@PathVariable String command) {
        orderUseCaseInputPort.get(command).execute(new Order());
    }
}
