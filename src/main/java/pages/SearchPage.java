package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;


public class SearchPage {
    private WebDriver driver;
    private final By FIRST_PRODUCT = By.cssSelector("#pagination_contents > div.grid-list > div:nth-child(1) > div > form > div.ty-grid-list__item-name > bdi > a");
    private final By SEARCH_RESULT_TEXT = By.xpath("//*[@id=\"products_search_total_found_11\"]");


    public SearchPage(WebDriver driver) {
        this.driver = driver;
    }

    public void clickOnNextAndCaptureNames() throws InterruptedException, IOException {
        File file = new File("/Users/bencefulop/Downloads/codecool/automation testing/testingHangszerplaza.hu/search.txt");
        //int paginationSize = driver.findElements(By.cssSelector("#pagination_contents > div.ty-pagination > div.ty-pagination__items > a")).size();
        WebElement titles = driver.findElement(By.xpath("//*[@id=\"pagination_contents\"]/div[3]"));
        List<WebElement> titleNames = titles.findElements(By.xpath("//bdi//a"));
        for (WebElement title : titleNames) {
            FileWriter writer = new FileWriter(file);
            BufferedWriter bufferedWriter = new BufferedWriter(writer);
            bufferedWriter.write(title.getText());
            bufferedWriter.close();
        }
        /*for(int i = 2; i <= paginationSize+1; i++ ){
            String paginationSelector = "#pagination_contents > div.ty-pagination > div > a:nth-child("+i+")";
            JavascriptExecutor executor = (JavascriptExecutor)driver;
            executor.executeScript("arguments[0].click();", driver.findElement(By.cssSelector(paginationSelector)));
            Thread.sleep(2000);
        }*/
    }

    public ProductPage clickOnProduct(){
        driver.findElement(FIRST_PRODUCT).click();
        return new ProductPage(driver);
    }
    public String getSearchResultText(){
        return driver.findElement(SEARCH_RESULT_TEXT).getText();
    }
}





