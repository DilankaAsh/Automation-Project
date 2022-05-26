package com.automation.practice.tests;

import com.automation.practice.model.page.Account;
import com.automation.practice.model.page.Authentication;
import com.automation.practice.model.page.CreateAccount;
import com.automation.practice.model.page.Home;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Test user registration functionality
 */
public class UserRegistrationTest extends BaseTest {

    @Test
    public void testCreateNewAccount() {

        Home home = new Home(driver).clickOnSignInMenu();

        Authentication authentication = new Authentication(driver)
                .setAccountCreateEmail("dilash1234@gmail.com") //Increment end email
                .submitAccountCreate();

        CreateAccount createAccount = new CreateAccount(driver)
                .setFirstName("John").setLastName("Du")
                .setPassword("10325")
                .setAddressLine1("4 Home Street")
                .setCity("Ryde")
                .setState("Alabama")
                .setZipCode("13253")
                .setCountry("United States")
                .setMobilePhone("1234567891")
                .setAddressAlias("House")
                .clickOnRegister();

        assertEquals("Welcome to your account. Here you can manage all of your personal information and orders.",
                new Account(driver).getWelcomeToAccountMessage());
    }
}