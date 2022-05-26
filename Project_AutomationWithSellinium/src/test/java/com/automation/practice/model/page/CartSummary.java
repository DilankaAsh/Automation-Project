package com.automation.practice.model.page;

import com.automation.practice.model.dto.Item;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

/**
 * Page object model of shopping cart summary
 */
public class CartSummary {

    private WebDriver driver;
    private By shoppingCartSummary = By.id("cart_summary");
    private By tableBody = By.tagName("tbody");
    private By tableFoot = By.tagName("tfoot");
    private By tableRow = By.tagName("tr");
    private By cartDescription = By.className("cart_description");
    private By paragraph = By.tagName("p");
    private By cartQuantity = By.className("cart_quantity");
    private By quantityInput = By.className("cart_quantity_input");
    private By cartTotal = By.className("cart_total");
    private By price = By.className("price");
    private By totalDelivery = By.className("cart_total_delivery");
    private By totalShipping = By.id("total_shipping");
    private By totalCartTax = By.className("cart_total_tax");
    private By totalTax = By.id("total_tax");
    private Map<String, Item> itemsInTheCart = new HashMap<>();

    public CartSummary(WebDriver driver) {

        this.driver = driver;
    }

    /**
     * Retrieve item description in cart summary
     *
     * @return map of added items to cart
     */
    public Map<String, Item> getItemDescription() {

        var rows = driver.findElement(shoppingCartSummary).findElement(tableBody).findElements(tableRow);

        for (int i = 0; i < rows.size(); i++) {
            String itemName = rows.get(i).findElement(cartDescription).findElement(paragraph).getText();
            String quantity = rows.get(i).findElement(cartQuantity).findElement(quantityInput).getAttribute("value");
            String unitPrice = rows.get(i).findElement(cartTotal).findElement(price).getText();
            itemsInTheCart.put(itemName, new Item(itemName, quantity, unitPrice));
        }
        return itemsInTheCart;
    }

    /**
     * Retrieve the total price of added items in shopping cart
     *
     * @return total price
     */
    public Float getTotal() {
        float total = 0f;
        float shipping = Float.parseFloat(driver.findElement(shoppingCartSummary).findElement(tableFoot)
                        .findElement(totalDelivery).findElement(totalShipping).getText().replace("$", ""));

        float tax = Float.parseFloat(driver.findElement(shoppingCartSummary).findElement(tableFoot)
                        .findElement(totalCartTax).findElement(totalTax).getText().replace("$", ""));

        for (Entry<String, Item> entry : itemsInTheCart.entrySet()) {
            total += Float.parseFloat(entry.getValue().getUnitPrice().replace("$", ""))
                    * Float.parseFloat(entry.getValue().getQuantity());
        }
        return total + shipping + tax;
    }

    /**
     * Click on proceed to checkout
     *
     * @return CartSummary
     */
    public CartSummary clickOnProceedToCheckOut() {

        driver.findElement(By.className("standard-checkout")).click();
        return this;
    }
}
