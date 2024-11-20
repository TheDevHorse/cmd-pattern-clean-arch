package com.thedevhorse.cmdpatterncleanarch.usecase;

import com.thedevhorse.cmdpatterncleanarch.domain.Order;
import org.springframework.stereotype.Component;

@Component("IN_PROGRESS")
public class InProgressOrderUseCase implements OrderUseCaseInputPort {

    private final OrderRepositoryOutputPort orderRepositoryOutputPort;

    public InProgressOrderUseCase(OrderRepositoryOutputPort orderRepositoryOutputPort) {
        this.orderRepositoryOutputPort = orderRepositoryOutputPort;
    }

    @Override
    public void execute(final Order order) {
        orderRepositoryOutputPort.createOrder(order);
    }
}
