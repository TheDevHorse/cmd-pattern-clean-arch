package com.thedevhorse.cmdpatterncleanarch.usecase;

import com.thedevhorse.cmdpatterncleanarch.domain.Order;
import org.springframework.stereotype.Component;

@Component("COMPLETED")
public class CompletedOrderUseCase implements OrderUseCaseInputPort {

    private final OrderProxyOutputPort orderProxyOutputPort;
    private final OrderRepositoryOutputPort orderRepositoryOutputPort;

    public CompletedOrderUseCase(OrderRepositoryOutputPort orderRepositoryOutputPort, OrderProxyOutputPort orderProxyOutputPort) {
        this.orderRepositoryOutputPort = orderRepositoryOutputPort;
        this.orderProxyOutputPort = orderProxyOutputPort;
    }

    @Override
    public void execute(Order newOrder) {
        Order order = orderRepositoryOutputPort.getOrder(newOrder.orderId());
        order.completeOrder();
        orderProxyOutputPort.sendOrder(newOrder);
        orderRepositoryOutputPort.updateOrder(newOrder);
    }
}
