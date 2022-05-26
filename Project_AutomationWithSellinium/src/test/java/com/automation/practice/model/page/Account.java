package com.automation.practice.model.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * Page object model of user account page
 */
public class Account {

    private By welcomeMessage = By.className("info-account");
    private WebDriver driver;

    public Account(WebDriver driver) {

        this.driver = driver;
    }

    /**
     * Retrieve welcome message in user account page
     *
     * @return welcome message
     */
    public String getWelcomeToAccountMessage() {

        return driver.findElement(welcomeMessage).getText();
    }
}