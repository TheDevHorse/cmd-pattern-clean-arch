package com.thedevhorse.cmdpatterncleanarch.usecase;

import com.thedevhorse.cmdpatterncleanarch.domain.Order;

public interface OrderUseCaseInputPort {

    void execute(Order order);
}
