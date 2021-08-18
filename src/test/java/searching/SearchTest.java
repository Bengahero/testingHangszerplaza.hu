package searching;

import base.BaseTest;
import fileutil.FileUtil;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import pages.SearchPage;

import java.io.IOException;


public class SearchTest extends BaseTest {
    FileUtil fileutil = new FileUtil();

    // Adatok listázása

    @Test
    public void successfullSearch() throws IOException {
        SearchPage searchPage = homePage.searching(fileutil.util("thirdsearchitem"));
        homePage.scrollThroughPage();
        String expected = "Termékek száma: 22";
        Assertions.assertEquals(expected, searchPage.getSearchResultText());
    }

    // Többoldalas lista bejárása

    @Test
    public void multiplePageSearch() throws InterruptedException, IOException {
        SearchPage searchPage = homePage.searching(fileutil.util("fourthsearchitem"));
        searchPage.clickOnNextAndCaptureNames();

    }
}
