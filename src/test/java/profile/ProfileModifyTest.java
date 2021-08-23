package profile;

import base.BaseTest;
import io.qameta.allure.Allure;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import pages.ProfilePage;

import java.io.ByteArrayInputStream;
import java.io.IOException;

public class ProfileModifyTest extends BaseTest {


    // Belépés a profil oldalra
    @Test
    public void enterMyProfileTest() throws InterruptedException, IOException {
        homePage.logIn();
        ProfilePage profilePage = homePage.clickOnMyProfile();
        String expected = "https://hangszerplaza.hu/profil-frissitese/";
        Assertions.assertEquals(expected, profilePage.getCurrentPageUrl());
    }

    // Új adat bevitel
    @Test
    public void setCityTest() throws InterruptedException, IOException {
        homePage.logIn();
        ProfilePage profilePage = homePage.clickOnMyProfile();
        String expected = "Los Angeles";
        Allure.addAttachment("Google Image", new ByteArrayInputStream(((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES)));
        Assertions.assertEquals(expected,profilePage.setCity());
    }

    //Meglévő adat módosítása
    @Test
    public void updateNamesTest() throws InterruptedException, IOException {
        homePage.logIn();
        ProfilePage profilePage = homePage.clickOnMyProfile();
        String[] expected = {"Medve", "Miki"};
        Allure.addAttachment("Google Image", new ByteArrayInputStream(((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES)));
        Assertions.assertArrayEquals(expected, profilePage.updateNames());
    }

    //Ismételt és sorozatos adatbevitel adatforrásból
    @Test
    public void setProfileDataTest() throws IOException, InterruptedException {
        homePage.logIn();
        ProfilePage profilePage = homePage.clickOnMyProfile();
        String[] expected = {"Medve", "Miki", "Los Angeles", "Heaven Street 7.", "+36012345678", "90001"};
        Allure.addAttachment("Google Image", new ByteArrayInputStream(((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES)));
        Assertions.assertArrayEquals(expected, profilePage.setProfileData());
    }
}
