package searching;

import base.BaseTest;
import fileutil.FileUtil;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import pages.SearchPage;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;


public class SearchTest extends BaseTest {
    FileUtil fileutil = new FileUtil();

    // Adatok listázása

    @Test
    public void successfullSearch() throws IOException, InterruptedException {
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
        int lines = 0;
        try {
            BufferedReader reader = new BufferedReader(new FileReader("search.txt"));
            while (reader.readLine() != null) lines++;
            reader.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        Assertions.assertEquals(66, lines);
    }
}
