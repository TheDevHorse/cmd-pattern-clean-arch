package com.thedevhorse.cmdpatterncleanarch.domain;

import java.util.UUID;

public class Order {

    private UUID orderId;

    private Status status;

    private Double price;

    private Order(UUID orderId,
                  Status status,
                  Double price) {
        this.orderId = orderId;
        this.status = status;
        this.price = price;
    }

    public static Order create(final UUID orderId,
                               final Status status,
                               final Double price) {
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
        this.status = Status.CANCELED;
    }

    public void completeOrder() {
        if (status.equals(Status.CANCELED)) {
            throw new IllegalArgumentException("Cannot complete a canceled order");
        }
        this.status = Status.COMPLETED;
    }

    public UUID orderId() {
        return orderId;
    }

    public Status status() {
        return status;
    }

    public Double price() {
        return price;
    }
}
