package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProductsPage extends BasePage {

    private static final By TITLE = By.cssSelector("[data-test = title]");
    private static final By CART_BUTTON = By.cssSelector(".shopping_cart_link");
    private static final String ADD_TO_CART_PATTERN = "//*[text() = '%s']/ancestor::div[@class = 'inventory_item']//button";

    public ProductsPage(WebDriver driver) {
        super(driver);
    }


    public String getTitle() {
        return driver.findElement(TITLE).getText();
    }

    @Step("Добавление товара с именем: {product} в корзину")
    public void addProduct(String product) {
        driver.findElement(By.xpath(String.format(ADD_TO_CART_PATTERN, product))).click();
    }

    @Step("Нажатие на кнопку корзины")
    public void openCart() {
        driver.findElement(CART_BUTTON).click();
    }
}
