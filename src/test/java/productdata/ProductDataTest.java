package productdata;

import base.BaseTest;
import fileutil.FileUtil;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import pages.CartPage;
import pages.CheckOutPage;
import pages.ProductPage;
import pages.SearchPage;

import java.io.IOException;

public class ProductDataTest extends BaseTest {
    FileUtil fileutil = new FileUtil();
    //Adatok lementése felületről


    @Test
    public void productDataDownload() throws IOException, InterruptedException {
        SearchPage searchPage = homePage.searching((fileutil.util("firstsearchitem")));
        ProductPage productPage = searchPage.clickOnProduct();
        String result = productPage.getProductData();
        Assertions.assertTrue(result.contains("Elixir Optiweb"));
    }

    // Adat vagy adatok törlése

    @Test
    public void addProductToCartAndRemove() throws IOException, InterruptedException {
        SearchPage searchPage = homePage.searching(fileutil.util("secondsearchitem"));
        ProductPage productPage = searchPage.clickOnProduct();
        productPage.addToCart();
        CheckOutPage checkOutPage = productPage.checkOut();
        CartPage cartPage = checkOutPage.deleteProduct();
        String expected = "Az Ön kosara üres.";
        Assertions.assertEquals(expected, cartPage.cartMessage());

    }
}
