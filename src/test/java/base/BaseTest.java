package base;

//junit 5.

import io.github.bonigarcia.wdm.WebDriverManager;
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
    public void setUp() throws IOException {
        Properties properties = new Properties();
        FileInputStream fis = new FileInputStream("src/main/java/datadriven.properties");
        properties.load(fis);
        WebDriverManager.chromedriver().setup();
        ChromeOptions ops = new ChromeOptions();
        ops.addArguments("--no-sandbox");
        ops.addArguments("--window-size=1920,1080");
        ops.addArguments("--disable-notifications");
        ops.addArguments("--disable-extensions");
        ops.addArguments("start-maximized");
        ops.addArguments("--incognito");
        ops.addArguments("--headless");
        driver = new ChromeDriver(ops);
        driver.get(properties.getProperty("url"));
        driver.manage().window().maximize();
        homePage = new HomePage(driver);




    }
}
