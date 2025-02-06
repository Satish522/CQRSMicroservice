package com.satish.dto;

import com.satish.command.entity.Product;

/**
 * Class ProductEvent
 * <p>
 * Description: This class represents ...
 * </p>
 *
 * @author satishkumarsubudhi
 * @since 05/02/25
 */
public class ProductEvent {

    private String eventType;

    private Product product;

    public ProductEvent() {

    }
    public ProductEvent(String eventType, Product product) {
        this.eventType = eventType;
        this.product = product;
    }

    public String getEventType() {
        return eventType;
    }

    public void setEventType(String eventType) {
        this.eventType = eventType;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }
}
