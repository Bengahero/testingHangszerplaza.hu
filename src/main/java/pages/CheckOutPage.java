package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CheckOutPage {
    private final WebDriver driver;


    public CheckOutPage(WebDriver driver){
        this.driver = driver;

    }
    public CartPage deleteProduct() {
        WebElement xButton = driver.findElement(By.xpath("//*[@id=\"checkout_info_products_368\"]/ul/li/a/i"));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();",xButton);
        return new CartPage(driver);






    }
}
