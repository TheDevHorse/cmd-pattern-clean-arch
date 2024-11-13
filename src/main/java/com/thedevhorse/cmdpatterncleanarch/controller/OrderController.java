package com.thedevhorse.cmdpatterncleanarch.controller;

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
        // TODO document why this method is empty
    }

    @PutMapping("/{command}")
    public void updateOrder(@PathVariable String command) {
        orderUseCaseInputPort.get(command).execute(null);
    }
}
