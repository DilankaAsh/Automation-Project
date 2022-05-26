package com.automation.practice.tests;

import com.automation.practice.model.dto.Item;
import com.automation.practice.model.page.CartSummary;
import com.automation.practice.model.page.Product;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * Test shopping cart functionalities
 */
public class ShoppingCartTest extends BaseTest {

    private static final Map<String, Item> addedItems = new HashMap<>() {{
        put("Blouse", new Item("Blouse", "1", "$27.00"));
        put("Printed Dress", new Item("Printed Dress", "1", "$26.00"));
    }};

    @Test
    public void testAddItemsToCart() {

        Product product = new Product(driver)
                .clickOnProductCategory("Women")
                .clickOnProductCategory("Tops")
                .clickOnProductItem("Blouse")
                .clickOnAddToCart()
                .clickOnContinueShopping()
                .clickOnProductCategory("Women")
                .clickOnProductCategory("Dresses")
                .clickOnProductCategory("Casual Dresses")
                .clickOnProductItem("Printed Dress")
                .clickOnAddToCart()
                .clickOnShoppingCart();

        CartSummary cartSummary = new CartSummary(driver);

        assertTrue(addedItems.entrySet().stream().allMatch(entry -> entry.getValue().getName()
                .equals(cartSummary.getItemDescription().get(entry.getKey()).getName())));
        assertTrue(addedItems.entrySet().stream().allMatch(entry -> entry.getValue().getQuantity()
                .equals(cartSummary.getItemDescription().get(entry.getKey()).getQuantity())));
        assertTrue(addedItems.entrySet().stream().allMatch(entry -> entry.getValue().getUnitPrice()
                .equals(cartSummary.getItemDescription().get(entry.getKey()).getUnitPrice())));
        assertEquals(55f, cartSummary.getTotal());
    }
}
