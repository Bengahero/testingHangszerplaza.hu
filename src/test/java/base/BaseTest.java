package base;

//junit 5.

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import pages.HomePage;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;


public class BaseTest {
    public WebDriver driver;
    public HomePage homePage;

    //Alapbeállítások

    @BeforeEach
    public void setUp() throws IOException{
        Properties properties = new Properties();
        FileInputStream fis = new FileInputStream("src/main/java/datadriven.properties");
        properties.load(fis);
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--no-sandbox");
        options.addArguments("--window-size=1920,1080");
        options.addArguments("--disable-notifications");
        options.addArguments("--disable-extensions");
        options.addArguments("start-maximized");
        options.addArguments("--disable-dev-shm-usage");
        options.addArguments("--headless");
        options.addArguments("--proxy-server='direct://");
        options.addArguments("--proxy-bypass-list=*");
        options.addArguments("--disable-gpu");
        options.addArguments("--incognito");
        options.addArguments("--disable-blink-features");
        options.addArguments("--disable-blink-features=AutomationControlled");
        driver = new ChromeDriver(options);
        driver.get(properties.getProperty("url"));
        homePage = new HomePage(driver);
    }
    @AfterEach
    public void tearDown(){
        driver.quit();
    }
}
