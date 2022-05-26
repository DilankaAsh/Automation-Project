package com.automation.practice.model.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * Page object model of shipping information page in payment flow
 */
public class Shipping {

    private WebDriver driver;

    public Shipping(WebDriver driver) {

        this.driver = driver;
    }

    /**
     * Click checkbox in shipping at payment flow
     *
     * @return Shipping
     */
    public Shipping clickCheckBox() {

        driver.findElement(By.id("cgv")).click();
        return this;
    }

    /**
     * Click on confirm shipping at payment flow
     *
     * @return Shipping
     */
    public Shipping clickOnConfirmShipping() {

        driver.findElement(By.name("processCarrier")).click();
        return this;
    }
}
