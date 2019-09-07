import Pages.YandexVideoPage;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.util.List;

import static java.lang.Thread.sleep;

public class AllVideoTest {

    WebDriver driver;

    @Before
    public void setUp(){

        System.setProperty("webdriver.chrome.driver", "src\\resourses\\chromedriver.exe");
        driver = new ChromeDriver();

        YandexVideoPage obj = new YandexVideoPage(driver);
        obj.getUrl();

    }

    @After
    public void tearDown(){
        driver.close();
    }

    @Test
    public void checkPreviewPlayingTest(){

        YandexVideoPage obj = new YandexVideoPage(driver);
        obj.findSearchField();

        obj.clickSearchButton();

        List<WebElement> elementList= driver.findElements(YandexVideoPage.elementList);
        System.out.println(elementList.size());

        //all elements
        int i;
        for (i=0; i<=elementList.size(); i++) {
            Actions act = new Actions(driver);
            act.moveToElement(elementList.get(i)).build().perform();

            try {
                sleep(10000);
            } catch (Exception e) {
                e.printStackTrace();
            }

            try {
                driver.findElement(YandexVideoPage.preview);
                System.out.println("DA");

            } catch (Exception e) {
                System.out.println("HET");
                e.printStackTrace();
            }
        }
    }
}
