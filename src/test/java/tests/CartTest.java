package tests;

import org.testng.annotations.Test;

public class CartTest extends BaseTest {

    @Test
    public void checkCart() {
        loginPage.open();
        loginPage.login("standard_user", "secret_sauce");
        productsPage.addProduct("Sauce Labs Backpack");
        productsPage.addProduct("Sauce Labs Bike Light");
        productsPage.openCart();
    }
}
