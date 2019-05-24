package com.ecommerce.order.order.model.event;

import com.ecommerce.order.common.event.DomainEvent;
import com.ecommerce.order.common.event.EventType;
import com.ecommerce.order.common.utils.Address;
import com.ecommerce.order.order.model.Order;
import com.ecommerce.order.order.model.OrderId;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.math.BigDecimal;
import java.time.Instant;

import static com.ecommerce.order.common.event.EventType.ORDER_CREATED;

public class OrderCreatedEvent extends DomainEvent {
    private final OrderId orderId;
    private final BigDecimal price;
    private final Instant createdAt;
    private final Address address;

    @JsonCreator
    private OrderCreatedEvent(@JsonProperty("_id") String _id,
                              @JsonProperty("_type") EventType _type,
                              @JsonProperty("_createdAt") Instant _createdAt,
                              @JsonProperty("orderId") OrderId orderId,
                              @JsonProperty("price") BigDecimal price,
                              @JsonProperty("createdAt") Instant createdAt,
                              @JsonProperty("address") Address address) {
        super(_id, _type, _createdAt);
        this.orderId = orderId;
        this.price = price;
        this.createdAt = createdAt;
        this.address = address;
    }

    public OrderCreatedEvent(Order order) {
        super(ORDER_CREATED);
        this.orderId = order.getId();
        this.price = order.getTotalPrice();
        this.createdAt = order.getCreatedAt();
        this.address = order.getAddress();
    }

    public OrderId getOrderId() {
        return orderId;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public Instant getCreatedAt() {
        return createdAt;
    }

    public Address getAddress() {
        return address;
    }
}
