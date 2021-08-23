package pages;

import fileutil.FileUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.io.IOException;

public class ProfilePage extends FileUtil {
    private  WebDriver driver;
    private final By LASTNAME_FIELD = By.xpath("//*[@id=\"elm_17\"]");
    private final By FIRSTNAME_FIELD = By.xpath("//*[@id=\"elm_15\"]");
    private final By PHONE_NUMBER_FIELD = By.xpath("//*[@id=\"elm_31\"]");
    private final By ADDRESS_FIELD = By.xpath("//*[@id=\"elm_19\"]");
    private final By CITY_FIELD = By.xpath("//*[@id=\"elm_23\"]");
    private final By ZIP_CODE_FIELD = By.xpath("//*[@id=\"elm_29\"]");



    public ProfilePage(WebDriver driver){
        this.driver = driver;
    }


    public String[] updateNames() throws IOException {
        driver.findElement(LASTNAME_FIELD).clear();
        driver.findElement(FIRSTNAME_FIELD).clear();
        driver.findElement(LASTNAME_FIELD).sendKeys(util("modifiedlastname"));
        driver.findElement(FIRSTNAME_FIELD).sendKeys(util("modifiedfirstname"));
        String[] names = new String[2];
        names[0] = driver.findElement(LASTNAME_FIELD).getAttribute("value");
        names[1] = driver.findElement(FIRSTNAME_FIELD).getAttribute("value");
        return names;
    }

    public String setCity() throws IOException {
        driver.findElement(CITY_FIELD).sendKeys(util("city"));
        return driver.findElement(CITY_FIELD).getAttribute("value");
    }

    public String[] setProfileData() throws IOException {
        updateNames();
        setCity();
        driver.findElement(PHONE_NUMBER_FIELD).sendKeys(util("phone"));
        driver.findElement(ADDRESS_FIELD).sendKeys(util("address"));
        driver.findElement(ZIP_CODE_FIELD).sendKeys(util("zip"));
        String[] data = new String[6];
        data[0] = driver.findElement(LASTNAME_FIELD).getAttribute("value");
        data[1] = driver.findElement(FIRSTNAME_FIELD).getAttribute("value");
        data[2] = driver.findElement(CITY_FIELD).getAttribute("value");
        data[3] = driver.findElement(ADDRESS_FIELD).getAttribute("value");
        data[4] = driver.findElement(PHONE_NUMBER_FIELD).getAttribute("value");
        data[5] = driver.findElement(ZIP_CODE_FIELD).getAttribute("value");
        return data;
    }

    public String getCurrentPageUrl(){
        return driver.getCurrentUrl();
    }
}
