package com.automation.practice.tests;

import com.automation.practice.model.page.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Test the checkout function in shopping cart
 */
public class CheckoutTest extends BaseTest {

    @Test
    public void testProceedToCheckout() {

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

        CartSummary cartSummary = new CartSummary(driver).clickOnProceedToCheckOut();

        Authentication signIn = new Authentication(driver)
                .setSignInEmail("abcg4d@gmail.com")
                .setSigInPassword("10325")
                .submitLogin();

        Address address = new Address(driver)
                .clickProceedWithCheckout();

        Shipping shipping = new Shipping(driver)
                .clickCheckBox()
                .clickOnConfirmShipping();

        PaymentMethod paymentMethod = new PaymentMethod(driver)
                .selectPaymentMethod();

        OrderSummary orderSummary = new OrderSummary(driver).selectConfirmOrder();

        assertEquals("Your order on My Store is complete.", new OrderConfirm(driver).getOrderCompleteMessage());
    }
}
