package com.automation.practice.model.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * Page object model of authentication page with user registration and login
 */
public class Authentication {

    private By emailAccountCreate = By.id("email_create");
    private By submitAccountCreate = By.id("SubmitCreate");
    private By emailSignIn = By.id("email");
    private By passwordSignIn = By.id("passwd");
    private By submitLogin = By.id("SubmitLogin");
    private WebDriver driver;

    public Authentication(WebDriver driver) {

        this.driver = driver;
    }

    /**
     * Set the email in account creation
     *
     * @param email email address of the user
     * @return Authentication
     */
    public Authentication setAccountCreateEmail(String email) {

        driver.findElement(emailAccountCreate).sendKeys(email);
        return this;
    }

    /**
     * Submit account creation
     *
     * @return Authentication
     */
    public Authentication submitAccountCreate() {

        driver.findElement(submitAccountCreate).click();
        return this;
    }

    /**
     * Set email in user sign in
     *
     * @return Authentication
     */
    public Authentication setSignInEmail(String email) {

        driver.findElement(emailSignIn).sendKeys(email);
        return this;
    }

    /**
     * Set password in user sign in
     *
     * @return Authentication
     */
    public Authentication setSigInPassword(String password) {

        driver.findElement(passwordSignIn).sendKeys(password);
        return this;
    }

    /**
     * Submit user sign in
     *
     * @return Authentication
     */
    public Authentication submitLogin() {

        driver.findElement(submitLogin).click();
        return this;
    }

}
