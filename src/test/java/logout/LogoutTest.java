package logout;

import base.BaseTest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import java.io.IOException;

public class LogoutTest extends BaseTest {
    private final By LOGIN_BUTTON_AFTER_LOGOUT = By.xpath("//*[@id=\"sw_dropdown_303\"]/a");

    //Kijelentkezés

    @Test
    public void succesfullLogOut() throws InterruptedException, IOException {
        homePage.logOut();
        String expected = "Bejelentkezés / Regisztráció";
        String result = driver.findElement(LOGIN_BUTTON_AFTER_LOGOUT).getText();
        Assertions.assertEquals(expected,result);

    }

}
