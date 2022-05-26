package com.automation.practice.model.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * Page object model of order confirmation page
 */
public class OrderConfirm {

    private WebDriver driver;

    public OrderConfirm(WebDriver driver) {

        this.driver = driver;
    }

    /**
     * Retrieve order complete message
     *
     * @return order complete message
     */
    public String getOrderCompleteMessage() {

        return driver.findElement(By.className("cheque-indent")).getText();
    }
}
