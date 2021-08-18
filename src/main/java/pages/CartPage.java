package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CartPage {
    private final WebDriver driver;
    private final By CART_MESSAGE = By.xpath("//*[@id=\"tygh_main_container\"]/div[4]/div/div[2]/div/div/div/p");

    public CartPage(WebDriver driver) {
        this.driver = driver;
    }

    public String cartMessage(){
        return driver.findElement(CART_MESSAGE).getText();
    }


}
