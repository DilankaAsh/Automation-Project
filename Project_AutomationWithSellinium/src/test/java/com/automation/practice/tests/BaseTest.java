package com.automation.practice.tests;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

/**
 * Base test that will navigate to the website
 */
public class BaseTest {

    protected WebDriver driver;

    @BeforeEach
    public void setUpTest() {

        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.manage().window().maximize();
        driver.navigate().to("http://automationpractice.com/index.php");
    }

    @AfterEach
    public void tearDownTest() {
        driver.close();
    }
}
