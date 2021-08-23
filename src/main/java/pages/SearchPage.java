package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class SearchPage{
    private final WebDriver driver;
    private final By FIRST_PRODUCT = By.cssSelector("#pagination_contents > div.grid-list > div:nth-child(1) > div > form > div.ty-grid-list__item-name > bdi > a");
    private final By SEARCH_RESULT_TEXT = By.xpath("//*[@id=\"products_search_total_found_11\"]");
    private final By NEXT_BUTTON = By.xpath("//*[@id=\"pagination_contents\"]/div[1]/a[2]/i");

    public SearchPage(WebDriver driver) {
        this.driver = driver;
    }

    public void clickOnNextAndCaptureNames() throws InterruptedException, IOException {
        File file = new File("/Users/bencefulop/Downloads/codecool/automation testing/testingHangszerplaza.hu/search.txt");
        FileWriter writer = new FileWriter(file);
        BufferedWriter bufferedWriter = new BufferedWriter(writer);
        int paginationSize = driver.findElements(By.xpath("//*[@id=\"pagination_contents\"]/div[1]/div/a")).size();
        List<WebElement> titles = driver.findElements(By.className("ty-grid-list__item-name"));
        for (WebElement title : titles) {
            bufferedWriter.write(title.getText());
            bufferedWriter.newLine();
            System.out.println(title.getText());
        }
        int i = 0;

        while (i<paginationSize) {
            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("arguments[0].click();", driver.findElement(NEXT_BUTTON));
            Thread.sleep(1000);
            titles = driver.findElements(By.xpath("//div[@class='ty-grid-list__item-name']//a"));
            for (WebElement title : titles) {
                bufferedWriter.write(title.getText());
                bufferedWriter.newLine();
                System.out.println(title.getText());
            }
            i++;
        }
        bufferedWriter.close();
    }

    public ProductPage clickOnProduct(){
        driver.findElement(FIRST_PRODUCT).click();
        return new ProductPage(driver);
    }
    public String getSearchResultText(){
        return driver.findElement(SEARCH_RESULT_TEXT).getText();
    }
}





