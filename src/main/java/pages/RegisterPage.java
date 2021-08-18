package pages;
import fileutil.FileUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.io.IOException;

public class RegisterPage extends FileUtil {
    private WebDriver driver;
    private final By EMAIL_FIELD = By.xpath("//*[@id=\"email\"]");
    private final By PASSWORD_FIELD = By.xpath("//*[@id=\"password1\"]");
    private final By CONFIRM_PASSWORD_FIELD = By.xpath("//*[@id=\"password2\"]");
    private final By GDPR_LINK = By.xpath("//*[@id=\"gdpr_agreements_user_registration_label\"]/a");
    private final By CHECK_BOX = By.xpath("//*[@id=\"gdpr_agreements_user_registration\"]");


    public RegisterPage(WebDriver driver){
        this.driver = driver;
    }
    public void giveEmailAddress() throws IOException {
        driver.findElement(EMAIL_FIELD).sendKeys(util("email"));
    }
    public void givePassword() throws IOException {
        driver.findElement(PASSWORD_FIELD).sendKeys(util("password"));
    }
    public void confirmPassword() throws IOException {
        driver.findElement(CONFIRM_PASSWORD_FIELD).sendKeys(util("confirm"));
    }
    public UserAggrementPage clickOnUserAggrement(){
        driver.findElement(GDPR_LINK).click();
        return new UserAggrementPage(driver);
    }
    public void clickCheckbox(){
        driver.findElement(CHECK_BOX).click();
    }

    }
