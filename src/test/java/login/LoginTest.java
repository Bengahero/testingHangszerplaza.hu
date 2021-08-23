package login;

import base.BaseTest;
import io.qameta.allure.Allure;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.io.ByteArrayInputStream;
import java.io.IOException;

public class LoginTest extends BaseTest {
    private static final By PROFIL_BUTTON_AFTER_LOGIN = By.className("ty-account-info__title");

    //Bejelentkezés
    @Test
    public void successfullLogin() throws InterruptedException, IOException {
        homePage.logIn();
        Allure.addAttachment("Google Image", new ByteArrayInputStream(((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES)));
        String expected = "Fiókom";
        String result = driver.findElement(PROFIL_BUTTON_AFTER_LOGIN).getText();
        Assertions.assertEquals(expected,result);


    }
}
