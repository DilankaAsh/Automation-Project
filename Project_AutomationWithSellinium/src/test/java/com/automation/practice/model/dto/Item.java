package com.automation.practice.model.dto;

/**
 * Define a shopping item
 */
public class Item {

    private String name;
    private String quantity;
    private String unitPrice;

    public Item(String name, String quantity, String unitPrice) {
        this.name = name;
        this.quantity = quantity;
        this.unitPrice = unitPrice;
    }

    /**
     * Get name of the shopping item
     *
     * @return shopping item name
     */
    public String getName() {
        return name;
    }

    /**
     * Set name of the shopping item
     *
     * @param name shopping item name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Get quantity of the shopping item
     *
     * @return shopping item quantity
     */
    public String getQuantity() {
        return quantity;
    }

    /**
     * Set quantity of the shopping item
     *
     * @param quantity shopping item quantity
     */
    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }

    /**
     * Get unit price of the shopping item
     *
     * @return shopping item unit price
     */
    public String getUnitPrice() {
        return unitPrice;
    }

    /**
     * Set unit price of the shopping item
     *
     * @param unitPrice shopping item unit price
     */
    public void setUnitPrice(String unitPrice) {
        this.unitPrice = unitPrice;
    }
}
