package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

import java.util.Iterator;
import java.util.Set;

public class UserAggrementPage {
    private WebDriver driver;

    public UserAggrementPage(WebDriver driver){
        this.driver = driver;
    }
    public void scrollThroughPage(){
        String parent=driver.getWindowHandle();
        Set<String> s=driver.getWindowHandles();
        Iterator<String> I1= s.iterator();

        while(I1.hasNext()) {

            String child_window=I1.next();

            if(!parent.equals(child_window)) {
                driver.switchTo().window(child_window);
            }
        }

        JavascriptExecutor js = (JavascriptExecutor) driver;
        for(int i=0;i<2000;i++){
            js.executeScript("window.scrollBy(0,8)", "");
        }

        driver.switchTo().window(parent);
    }
}
