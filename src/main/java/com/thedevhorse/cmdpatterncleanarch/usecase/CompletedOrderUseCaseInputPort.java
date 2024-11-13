package com.thedevhorse.cmdpatterncleanarch.usecase;

import com.thedevhorse.cmdpatterncleanarch.domain.Order;
import org.springframework.stereotype.Component;

@Component("COMPLETED")
public class CompletedOrderUseCaseInputPort implements OrderUseCaseInputPort {

    @Override
    public void execute(Order order) {

    }
}
