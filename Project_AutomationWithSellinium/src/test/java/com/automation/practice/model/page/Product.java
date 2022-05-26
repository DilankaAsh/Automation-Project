package com.automation.practice.model.page;

import com.automation.practice.model.dto.Item;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.HashMap;
import java.util.Map;

/**
 * Page object model of all the product pages
 */
public class Product {

    private WebDriver driver;
    private Map<String, Item> addedItems = new HashMap<>();

    public Product(WebDriver driver) {
        this.driver = driver;
    }

    /**
     * Click on a product category
     *
     * @return Product
     */
    public Product clickOnProductCategory(String categoryName) {
        driver.findElement(By.linkText(categoryName)).click();
        return this;
    }

    /**
     * Click on product item
     *
     * @return Product
     */
    public Product clickOnProductItem(String productName) {

        driver.findElement(By.linkText(productName)).click();
        String itemName = driver.findElement(
                By.cssSelector("#center_column > div > div > div.pb-center-column.col-xs-12.col-sm-4 > h1"))
                .getText();
        String quantity = driver.findElement(By.id("quantity_wanted")).getAttribute("value");
        String unitPrice = driver.findElement(By.id("our_price_display")).getText();
        addedItems.put(productName, new Item(itemName, quantity, unitPrice));
        return this;
    }

    /**
     * Click on add to cart
     *
     * @return Product
     */
    public Product clickOnAddToCart() {

        driver.findElement(By.id("add_to_cart")).click();
        return this;
    }

    /**
     * Click on continue shopping after product is added
     *
     * @return Product
     */
    public Product clickOnContinueShopping() {

        driver.findElement(By.className("left")).click();
        return this;
    }

    /**
     * Click on shopping cart
     *
     * @return Product
     */
    public Product clickOnShoppingCart() {

        driver.findElement(By.linkText("Proceed to checkout")).click();
        return this;
    }
}
