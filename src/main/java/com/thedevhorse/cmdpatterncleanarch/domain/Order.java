package com.thedevhorse.cmdpatterncleanarch.domain;

import java.util.UUID;

import static java.util.Objects.nonNull;

public class Order {

    private UUID orderId;

    private Status status;

    private final double price;

    private Order(UUID orderId,
                  Status status,
                  double price) {
        setOrderId(orderId);
        setStatus(orderId, status);
        this.price = price;
    }

    public static Order create(final UUID orderId,
                               final Status status,
                               final double price) {
        return new Order(
                orderId,
                status,
                price
        );
    }

    public void cancelOrder() {
        if (status.equals(Status.COMPLETED)) {
            throw new IllegalArgumentException("Cannot cancel a completed order");
        }
        setStatus(orderId, Status.CANCELED);
    }

    public void completeOrder() {
        if (status.equals(Status.CANCELED)) {
            throw new IllegalArgumentException("Cannot complete a canceled order");
        }
        setStatus(orderId, Status.COMPLETED);
    }

    public UUID orderId() {
        return orderId;
    }

    public Status status() {
        return status;
    }

    public double price() {
        return price;
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
