package login;

import base.BaseTest;
import io.qameta.allure.Allure;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.io.ByteArrayInputStream;
import java.io.IOException;

public class LoginTest extends BaseTest {

    //Bejelentkezés
    @Test
    public void successfullLogin() throws InterruptedException, IOException {
        Allure.addAttachment("Google Image", new ByteArrayInputStream(((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES)));
        String expected = "Fiókom";
        String result = homePage.logIn();
        Assertions.assertEquals(expected,result);

    }
}
