package com.automation.practice.model.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * Page object model of payment method selection page
 */
public class PaymentMethod {

    private WebDriver driver;

    public PaymentMethod(WebDriver driver) {

        this.driver = driver;
    }

    /**
     * Select payment method in payment flow
     *
     * @return PaymentMethod
     */
    public PaymentMethod selectPaymentMethod() {

        driver.findElement(By.className("bankwire")).click();
        return this;
    }
}
