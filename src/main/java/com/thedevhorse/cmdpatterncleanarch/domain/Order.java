package com.thedevhorse.cmdpatterncleanarch.domain;

import java.util.UUID;

import static java.util.Objects.nonNull;

public class Order {

    private UUID orderId;

    private Status status;

    private Order(UUID orderId,
            Status status) {
        setOrderId(orderId);
        setStatus(orderId, status);
    }

    public static Order create(final UUID orderId,
                        final Status status){
        return new Order(
                orderId,
                status
        );
    }

    public UUID orderId() {
        return orderId;
    }

    public Status status() {
        return status;
    }

    private void setStatus(UUID orderId, Status status) {
        if (nonNull(orderId) && status.equals(Status.IN_PROGRESS)) {
            throw new IllegalArgumentException("Cannot set status to IN_PROGRESS for an order with an existing ID: " + orderId);
        }
        this.status = status;
    }

    private void setOrderId(UUID orderId) {
        if (nonNull(orderId)) {
            this.orderId = orderId;
        } else {
            this.orderId = UUID.randomUUID();
        }
    }
}
