package profile;

import base.BaseTest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import pages.ProfilePage;

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
        profilePage.setCity();

    }

    //Meglévő adat módosítása

    @Test
    public void updateNamesTest() throws InterruptedException, IOException {
        homePage.logIn();
        ProfilePage profilePage = homePage.clickOnMyProfile();
        profilePage.updateNames();
    }

    //Ismételt és sorozatos adatbevitel adatforrásból

    @Test
    public void setProfileDataTest() throws IOException, InterruptedException {
        homePage.logIn();
        ProfilePage profilePage = homePage.clickOnMyProfile();
        profilePage.setProfileData();
    }
}
