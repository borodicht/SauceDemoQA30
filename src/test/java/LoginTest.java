import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest{

    @Test
    public void checkSuccessLogin() {
        driver.get("https://www.saucedemo.com/");
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        driver.findElement(By.id("login-button")).click();
        String title = driver.findElement(By.cssSelector(".title")).getText();
        Assert.assertEquals(title,
                "Products",
                "Логин не выполнен");
    }

    @Test
    public void checkLoginWithEmptyValue() {
        driver.get("https://www.saucedemo.com/");
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        driver.findElement(By.id("password")).sendKeys("");
        driver.findElement(By.id("login-button")).click();

        String title = driver.findElement(By.xpath("//h3[@data-test='error']")).getText();
        Assert.assertEquals(title,
                "Epic sadface: Password is required",
                "Логин не выполнен");
    }

    @Test
    public void checkLoginWithWrongPassword() {
        driver.get("https://www.saucedemo.com/");
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        driver.findElement(By.id("password")).sendKeys("1243143143");
        driver.findElement(By.id("login-button")).click();

        String title = driver.findElement(By.xpath("//h3[@data-test='error']")).getText();
        Assert.assertEquals(title,
                "Epic sadface: Password is required",
                "Логин не выполнен");
    }
}

//h3[@data-test='error']

//*[@id=\"login_button_container\"]/div/form/div[3]/h3