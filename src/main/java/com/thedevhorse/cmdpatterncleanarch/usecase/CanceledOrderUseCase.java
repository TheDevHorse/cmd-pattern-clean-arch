package com.thedevhorse.cmdpatterncleanarch.usecase;

import com.thedevhorse.cmdpatterncleanarch.domain.Order;
import org.springframework.stereotype.Component;

@Component("CANCELED")
public class CanceledOrderUseCase implements OrderUseCaseInputPort {

    private final OrderProxyOutputPort orderProxyOutputPort;
    private final OrderRepositoryOutputPort orderRepositoryOutputPort;

    public CanceledOrderUseCase(OrderRepositoryOutputPort orderRepositoryOutputPort, OrderProxyOutputPort orderProxyOutputPort) {
        this.orderRepositoryOutputPort = orderRepositoryOutputPort;
        this.orderProxyOutputPort = orderProxyOutputPort;
    }

    @Override
    public void execute(Order newOrder) {
        Order order = orderRepositoryOutputPort.getOrder(newOrder.orderId());
        order.cancelOrder();
        orderProxyOutputPort.cancelOrder(newOrder);
        orderRepositoryOutputPort.createOrder(newOrder);
    }
}
