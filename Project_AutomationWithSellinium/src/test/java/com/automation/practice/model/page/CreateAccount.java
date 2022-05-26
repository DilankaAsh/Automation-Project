package com.automation.practice.model.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

/**
 * Page object model of user registration page
 */
public class CreateAccount {

    private WebDriver driver;

    public CreateAccount(WebDriver driver) {

        this.driver = driver;
    }

    /**
     * Set first name in create account
     *
     * @param firstName user first name
     * @return CreateAccount
     */
    public CreateAccount setFirstName(String firstName) {

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("customer_firstname")));
        driver.findElement(By.id("customer_firstname")).sendKeys(firstName);
        return this;
    }

    /**
     * Set last name in create account
     *
     * @param lastName user last name
     * @return CreateAccount
     */
    public CreateAccount setLastName(String lastName) {

        driver.findElement(By.id("customer_lastname")).sendKeys(lastName);
        return this;
    }

    /**
     * Set password in create account
     *
     * @param password user password
     * @return CreateAccount
     */
    public CreateAccount setPassword(String password) {

        driver.findElement(By.id("passwd")).sendKeys(password);
        return this;
    }

    /**
     * Set address line 1 in create account
     *
     * @param addressLine1 address line 1
     * @return CreateAccount
     */
    public CreateAccount setAddressLine1(String addressLine1) {

        driver.findElement(By.id("address1")).sendKeys(addressLine1);
        return this;
    }

    /**
     * Set city in create account
     *
     * @param city city
     * @return CreateAccount
     */
    public CreateAccount setCity(String city) {

        driver.findElement(By.id("city")).sendKeys(city);
        return this;
    }

    /**
     * Set state in create account
     *
     * @param state state
     * @return CreateAccount
     */
    public CreateAccount setState(String state) {

        new Select(driver.findElement(By.id("id_state"))).selectByVisibleText(state);
        return this;
    }

    /**
     * Set zip code in create account
     *
     * @param zipCode zip code
     * @return CreateAccount
     */
    public CreateAccount setZipCode(String zipCode) {

        driver.findElement(By.id("postcode")).sendKeys(zipCode);
        return this;
    }

    /**
     * Set country in create account
     *
     * @param country country
     * @return CreateAccount
     */
    public CreateAccount setCountry(String country) {

        new Select(driver.findElement(By.id("id_country"))).selectByVisibleText(country);
        return this;
    }

    /**
     * Set mobile number in create account
     *
     * @param mobilePhone mobile phone num
     * @return CreateAccount
     */
    public CreateAccount setMobilePhone(String mobilePhone) {

        driver.findElement(By.id("phone_mobile")).sendKeys(mobilePhone);
        return this;
    }

    /**
     * Set address alias in create account
     *
     * @param addressAlias address alias
     * @return CreateAccount
     */
    public CreateAccount setAddressAlias(String addressAlias) {

        driver.findElement(By.id("alias")).sendKeys(addressAlias);
        return this;
    }

    /**
     * Click on register button
     *
     * @return CreateAccount
     */
    public CreateAccount clickOnRegister() {

        driver.findElement(By.id("submitAccount")).click();
        return this;
    }
}
