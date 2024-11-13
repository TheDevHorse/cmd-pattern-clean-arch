package com.thedevhorse.cmdpatterncleanarch.usecase;

import com.thedevhorse.cmdpatterncleanarch.domain.Order;
import org.springframework.stereotype.Service;

@Service("IN_PROGRESS")
public class InProgressOrderUseCaseInputPort implements OrderUseCaseInputPort {

    @Override
    public void execute(Order order) {

    }
}
