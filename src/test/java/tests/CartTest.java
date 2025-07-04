package tests;

import io.qameta.allure.*;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class CartTest extends BaseTest {

    @Test
    @Epic("Корзина")
    @Feature("Добавление товара")
    @Story("Отображение товара в корзине")
    @Severity(SeverityLevel.CRITICAL)
    @Owner("Бородич Тимофей")
    @Description("Проверка добавление товара в корзину")
    @Flaky
    @Link(name = "документация", url = "https://www.saucedemo.com/")
    @TmsLink("TMS_T10")
    @Issue("TMS_T11")
    public void checkCart() {
        loginPage.open();
        loginPage.login(user, password);
        productsPage.addProduct("Sauce Labs Backpack");
        productsPage.openCart();
        assertTrue(cartPage.isProductInCart("Sauce Labs Backpack"),
                "SO BAAAAD");
        assertEquals(cartPage.getProductFromCart(0),
                "Sauce Labs Backpack",
                "SO BAAAAAD");
        assertTrue(cartPage.getProductsName().contains("Sauce Labs Backpack"));
        assertEquals(cartPage.getProductPrice("Sauce Labs Backpack"), 29.99);
    }
}
