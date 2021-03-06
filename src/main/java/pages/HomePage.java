package pages;

import fileutil.FileUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.IOException;
import java.util.Set;

public class HomePage extends FileUtil {
    WebDriver driver;

    // for registration
    private final By REGISTER_MENU = By.xpath("//a[@href='https://hangszerplaza.hu/profil-frissitese/']");
    private final By REGISTER_BUTTON = By.xpath("//*[@id=\"account_info_303\"]/div/a[2]");

    // for login
    private final By LOGIN_BUTTON = By.xpath("//*[@id=\"account_info_303\"]/div/a[1]");
    private final By ANOTHER_LOGIN_BUTTON = By.xpath("//*[@id=\"popup303_login_popup_form_container\"]/form/div[4]/div[1]/button");
    private final By EMAIL_TEXT_FIELD = By.xpath("//*[@id=\"login_popup303\"]");
    private final By PASSWORD_TEXT_FIELD = By.xpath("//*[@id=\"psw_popup303\"]");
    private final By MY_PROFILE_BUTTON = By.xpath("//*[@id=\"sw_dropdown_303\"]/a/span");
    private final By MY_PROFILE_DATA = By.xpath("//*[@id=\"account_info_303\"]/ul/li[2]/a");
    private final By PROFIL_BUTTON_AFTER_LOGIN = By.className("ty-account-info__title");
    private final By LOGIN_BUTTON_AFTER_LOGOUT = By.xpath("//*[@id=\"sw_dropdown_303\"]/a");

    // for logout
    private final By LOGOUT_BUTTON = By.xpath("//*[@id=\"account_info_303\"]/div/a");

    //for searching
    private final By SEARCH_BAR = By.xpath("//*[@id=\"search_input\"]");

    // constructor
    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    // methods
    public String logIn() throws InterruptedException, IOException {
        clickRegisterMenu();
        clickLoginButton();
        setEmailAddress();
        setPassword();
        clickOnAnotherLoginButton();
        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.elementToBeClickable(MY_PROFILE_BUTTON));
        Thread.sleep(5000);
        return driver.findElement(PROFIL_BUTTON_AFTER_LOGIN).getText();
    }

    public void clickRegisterMenu() {
        driver.findElement(REGISTER_MENU).click();
    }

    public RegisterPage clickRegisterButton() throws InterruptedException {
        Thread.sleep(1000);
        driver.findElement(REGISTER_BUTTON).click();
        return new RegisterPage(driver);
    }

    public void clickLoginButton() throws InterruptedException {
        Thread.sleep(1000);
        driver.findElement(LOGIN_BUTTON).click();
    }

    public void setEmailAddress() throws IOException {
        driver.findElement(EMAIL_TEXT_FIELD).sendKeys(util("email"));
    }

    public void setPassword () throws IOException {
        driver.findElement(PASSWORD_TEXT_FIELD).sendKeys(util("password"));
    }

    public void clickOnAnotherLoginButton() throws InterruptedException {
        Thread.sleep(1000);
        driver.findElement(ANOTHER_LOGIN_BUTTON).click();
    }

    public ProfilePage clickOnMyProfile() throws InterruptedException {
        Thread.sleep(1000);
        driver.findElement(MY_PROFILE_BUTTON).click();
        driver.findElement(MY_PROFILE_DATA).click();
        return new ProfilePage(driver);
    }

    public String logOut() throws InterruptedException, IOException {
        logIn();
        WebDriverWait wait = new WebDriverWait(driver, 20);
        wait.until(ExpectedConditions.elementToBeClickable(MY_PROFILE_BUTTON));
        driver.findElement(MY_PROFILE_BUTTON).click();
        driver.findElement(LOGOUT_BUTTON).click();
        return driver.findElement(LOGIN_BUTTON_AFTER_LOGOUT).getText();
    }

    public SearchPage searching (String item) throws InterruptedException {
        Thread.sleep(1000);
        driver.findElement(SEARCH_BAR).sendKeys(item + Keys.ENTER);
        return new SearchPage(driver);
    }

    public void scrollThroughPage(){
        String parent=driver.getWindowHandle();
        Set<String> s=driver.getWindowHandles();

        for (String child_window : s) {
            if (!parent.equals(child_window)) {
                driver.switchTo().window(child_window);
            }
        }
        JavascriptExecutor js = (JavascriptExecutor) driver;
        for(int i=0;i<500;i++){
            js.executeScript("window.scrollBy(0,8)", "");
        }
    }
}
