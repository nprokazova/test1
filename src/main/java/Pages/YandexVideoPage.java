package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class YandexVideoPage {

    public static WebDriver driver;

    public static final String url = "https://yandex.ru/portal/video";
    public static final String hurricane = "Ураган";

    public  static  final By searchfd = By.xpath("//*[@class='input__control']");
    public  static  final By searchbtn = By.xpath("//*[@class='websearch-button__text']");
    public  static  final By elementList= By.xpath("//*[@class='serp-controller__content']//*[@class='thumb-image__shadow']");
    public  static  final By oneElement = By.xpath("(//*[@class='serp-controller__content']//*[@class='thumb-image__preview thumb-preview__target'])");
    public  static  final By preview = By.xpath("//*[@class='serp-controller__content']//*[@class='thumb-image__preview thumb-preview__target thumb-preview__target_playing']");

    public YandexVideoPage (WebDriver driver){

        this.driver = driver;

    }

    //Get the Page URL
    public void getUrl(){

        driver.get(url);

    }

    //Find the search field
    public static void findSearchField(){

        driver.findElement(searchfd).sendKeys(hurricane);

    }

    //Find the search field
    public void clickSearchButton(){

        driver.findElement(searchbtn).click();

    }

    //Find one element
    public void findOneElement(){

        driver.findElement(oneElement);

    }

    //Find the "preview" property
    public String findPreviewProperty(){

        return    driver.findElement(preview).getText();

    }
}
