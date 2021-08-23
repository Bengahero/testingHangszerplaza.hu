package logout;

import base.BaseTest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import java.io.IOException;

public class LogoutTest extends BaseTest {

    //Kijelentkezés
    @Test
    public void succesfullLogOut() throws InterruptedException, IOException {

        String expected = "Bejelentkezés / Regisztráció";
        String result = homePage.logOut();
        Assertions.assertEquals(expected,result);
    }
}
