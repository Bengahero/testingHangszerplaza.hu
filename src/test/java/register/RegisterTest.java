package register;

import base.BaseTest;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import pages.RegisterPage;
import pages.UserAggrementPage;

import java.io.IOException;

public class RegisterTest extends BaseTest {

    //Regisztróció, adatkezlési nyilatkozat használata
    @Disabled
    @Test
    public void registrationTest() throws IOException, InterruptedException {
        homePage.clickRegisterMenu();
        RegisterPage registerPage = homePage.clickRegisterButton();
        registerPage.giveEmailAddress();
        registerPage.givePassword();
        registerPage.confirmPassword();
        UserAggrementPage userAggrementPage = registerPage.clickOnUserAggrement();
        userAggrementPage.scrollThroughPage();
        registerPage.clickCheckbox();
    }
}
