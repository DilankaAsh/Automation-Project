package com.automation.practice.model.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * Page object model of home page
 */
public class Home {

    private WebDriver driver;

    public Home(WebDriver driver) {
        this.driver = driver;
    }

    /**
     * Click on user sign in menu item
     *
     * @return Home
     */
    public Home clickOnSignInMenu() {
        driver.findElement(By.className("login")).click();
        return this;
    }
}
