package com.automation.practice.model.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * Page object model of order summary page
 */
public class OrderSummary {

    private WebDriver driver;

    public OrderSummary(WebDriver driver) {

        this.driver = driver;
    }

    /**
     * Click confirm order in payment plow
     *
     * @return OrderSummary
     */
    public OrderSummary selectConfirmOrder() {

        driver.findElement(By.cssSelector("#cart_navigation > button")).click();
        return this;
    }
}
