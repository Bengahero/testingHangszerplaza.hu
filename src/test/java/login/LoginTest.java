package login;

import base.BaseTest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import java.io.IOException;

public class LoginTest extends BaseTest {
    private static final By PROFIL_BUTTON_AFTER_LOGIN = By.xpath("//*[@id=\"sw_dropdown_303\"]/a/span");

    //Bejelentkezés

    @Test
    public void successfullLogin() throws InterruptedException, IOException {
        homePage.logIn();
        String expected = "Fiókom";
        String result = driver.findElement(PROFIL_BUTTON_AFTER_LOGIN).getText();
        Assertions.assertEquals(expected,result);


    }
}
