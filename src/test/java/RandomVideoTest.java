
import Pages.YandexVideoPage;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.util.List;
import java.util.Random;

import static java.lang.Thread.sleep;

public class RandomVideoTest {
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

        //random element
        List<WebElement> elementList= driver.findElements(YandexVideoPage.elementList);
        Random r = new Random();
        int randomValue = r.nextInt(elementList.size());

        System.out.println("Selected Element Number " + randomValue);
        System.out.println("List size " + elementList.size());

        WebElement rndElemnt = elementList.get(randomValue);

        Actions act = new Actions(driver);
        act.moveToElement(rndElemnt).build().perform();

        try {
            sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        try {
            driver.findElement(YandexVideoPage.preview);
            System.out.println("DA");

        } catch (Exception e) {
            System.out.println("HET");
        }

        driver.close();
    }

}