package com.thedevhorse.cmdpatterncleanarch.usecase;

import com.thedevhorse.cmdpatterncleanarch.domain.Order;
import org.springframework.stereotype.Service;

@Service("CANCELED")
public class CanceledOrderUseCaseInputPort implements OrderUseCaseInputPort {

    @Override
    public void execute(Order order) {

    }
}
