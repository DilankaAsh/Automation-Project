package com.automation.practice.model.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * Page object model of address page in payment flow
 */
public class Address {

    private By proceedCheckoutButton = By.name("processAddress");
    private WebDriver driver;

    public Address(WebDriver driver) {

        this.driver = driver;
    }

    /**
     * Proceed with checkout flow, after address information are filled
     *
     * @return Address
     */
    public Address clickProceedWithCheckout() {

        driver.findElement(proceedCheckoutButton).click();
        return this;
    }
}
