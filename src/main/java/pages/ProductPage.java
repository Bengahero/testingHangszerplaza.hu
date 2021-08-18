package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class ProductPage {

    private WebDriver driver;
    private final By ADD_TO_CART_BUTTON = By.xpath("//*[@id=\"button_cart_26955\"]");
    private final By CHECKOUT_BUTTON = By.xpath("/html/body/div[4]/div/div[2]/div[2]/a");

    public ProductPage(WebDriver driver){
        this.driver = driver;
    }
    
    public String getProductData(){
        List<WebElement> info = driver.findElements(By.id("content_description"));
        String productInfo = "";
        for(WebElement element: info){
            System.out.println(element.getText());
            productInfo = element.getText();
        }
        return productInfo;

    }

    public void addToCart(){
        driver.findElement(ADD_TO_CART_BUTTON).click();
    }
    public CheckOutPage checkOut(){
        WebDriverWait wait = new WebDriverWait(driver, 20);
        wait.until(ExpectedConditions.elementToBeClickable(CHECKOUT_BUTTON));
        driver.findElement(CHECKOUT_BUTTON).click();
        return new CheckOutPage(driver);
    }


}
