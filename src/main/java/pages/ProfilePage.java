package pages;

import fileutil.FileUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.io.IOException;

public class ProfilePage extends FileUtil {
    private final WebDriver driver;
    private final By LASTNAME_FIELD = By.xpath("//*[@id=\"elm_17\"]");
    private final By FIRSTNAME_FIELD = By.xpath("//*[@id=\"elm_15\"]");
    private final By PHONE_NUMBER_FIELD = By.xpath("//*[@id=\"elm_31\"]");
    private final By ADDRESS_FIELD = By.xpath("//*[@id=\"elm_19\"]");
    private final By CITY_FIELD = By.xpath("//*[@id=\"elm_23\"]");
    private final By ZIP_CODE_FIELD = By.xpath("//*[@id=\"elm_29\"]");


    public ProfilePage(WebDriver driver){
        this.driver = driver;
    }
    public void updateNames() throws IOException {
        driver.findElement(LASTNAME_FIELD).clear();
        driver.findElement(FIRSTNAME_FIELD).clear();
        driver.findElement(LASTNAME_FIELD).sendKeys(util("modifiedlastname"));
        driver.findElement(FIRSTNAME_FIELD).sendKeys(util("modifiedfirstname"));
    }

    public void setCity() throws IOException {
        driver.findElement(CITY_FIELD).sendKeys(util("city"));

    }

    public void setProfileData() throws IOException {
        updateNames();
        setCity();
        driver.findElement(PHONE_NUMBER_FIELD).sendKeys(util("phone"));
        driver.findElement(ADDRESS_FIELD).sendKeys(util("address"));
        driver.findElement(ZIP_CODE_FIELD).sendKeys(util("zip"));
    }

    public String getCurrentPageUrl(){
        return driver.getCurrentUrl();
    }


}
