package org.example;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;

public class AmazonTestOne {
    public static AmazonTestTwo amazonTestTwo;;
    public static WebDriver driver;


@BeforeClass
public static void setup() {
    //определение пути до драйвера и его настройка
    System.setProperty("webdriver.chrome.driver", ConfProperties.getProperty("chromedriver"));
    //создание экземпляра драйвера
    driver = new ChromeDriver();
    amazonTestTwo = new AmazonTestTwo(driver);
    //окно разворачивается на полный экран
    driver.manage().window().maximize();
    //задержка на выполнение теста = 10 сек.
    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    driver.get(ConfProperties.getProperty("loginpage")); }

@Test
public void amazonTestOne() {

//получение доступа к методам класса AmazonTestOne для взаимодействия с элементами страницы
    amazonTestTwo.clickAllButton();
    amazonTestTwo.clickBookButton();
    amazonTestTwo.inputInSearchTextBox("Java");
    amazonTestTwo.clickSearchButton();


//получение доступа к методам класса AmazonTestOne для взаимодействия с данными о книге
    String bookname = amazonTestTwo.getBookName();
    Assert.assertEquals(ConfProperties.getProperty("bookname"), bookname);

    String bookauthorone = amazonTestTwo.getBookAuthorOne();
    Assert.assertEquals(ConfProperties.getProperty("bookauthorone"), bookauthorone);

    String bookauthortwo = amazonTestTwo.getBookAuthorTwo();
    Assert.assertEquals(ConfProperties.getProperty("bookauthortwo"), bookauthortwo);

    String bookprice = amazonTestTwo.getBookPrice();
    Assert.assertEquals(ConfProperties.getProperty("bookprice"), bookprice);

    boolean t = driver.findElement(By.xpath("/html/body/div[1]/div[2]/div[1]/div[1]/div/span[3]/div[2]/div[3]")).isDisplayed();
    if (t) {
        System.out.println("Element is displayed");
    } else {
        System.out.println("Element is not displayed");
    }

}

@AfterClass
public static void tearDown() {
    driver.quit(); } }


//Method to switch to other frame  - 1
//driver.switchTo().frame(0);


//Method to switch to other frame  - 2
//WebElement fr = driver.findElementById("theIframe");
//driver.switchTo().frame(fr);