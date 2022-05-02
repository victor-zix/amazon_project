package org.example;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import java.time.Duration;

import org.openqa.selenium.By;
//import java.util.concurrent.TimeUnit;

public class AmazonPageMainTest {
    public static Amazon amazon;
    public static WebDriver driver;
    public static BookPage book;


@BeforeClass
public static void setup() {

    // Get driver path and settings

    System.setProperty("webdriver.chrome.driver", ConfProperties.getProperty("chromedriver"));

    // Create a copy of class object

    driver = new ChromeDriver();
    amazon = new Amazon(driver);
    book = new BookPage(driver);

    // Activate full screen mode

    driver.manage().window().maximize();

    // Set timeout = 10 sec

    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    driver.get(ConfProperties.getProperty("loginpage")); }

@Test
public void amazonPageMainTest() {

    // Get access to methods of the class AmazonTestOne to interact with the elements of the page

    amazon.clickAllButton();
    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    amazon.clickBookButton();
    amazon.inputInSearchTextBox(ConfProperties.getProperty("booksearchrequest"));
    amazon.clickSearchButton();

    // Save details of the book from the search page: book name, author, price, bestseller badge in the list

    book.getBookNames();

    // Get access to methods of the class AmazonTestTwo to interact with the elements of the search page, in this case "Head First Java, 2nd Edition"

    String bookname = amazon.getBookName();
    Assert.assertEquals(ConfProperties.getProperty("bookname"), bookname);

    String bookauthorone = amazon.getBookAuthorOne();
    Assert.assertEquals(ConfProperties.getProperty("bookauthorone"), bookauthorone);

    String bookauthortwo = amazon.getBookAuthorTwo();
    Assert.assertEquals(ConfProperties.getProperty("bookauthortwo"), bookauthortwo);

    String bookprice = amazon.getBookPrice();
    Assert.assertEquals(ConfProperties.getProperty("bookprice"), bookprice);

    // Separate  verification that the book "Head First Java, 2nd Edition" is a bestseller: IS = 1, не IS NOT = 0. The value should set before running this test.

    Assert.assertEquals(0, driver.findElements(By.xpath("//div[2]/div[contains(@data-asin, '0596009208')]/div//span/div/span[contains(@id, 'best-seller')]")).size());
}


@AfterClass
public static void tearDown() {
    driver.quit(); }}

/*
Notes:
Method to switch to other frame  - 1
driver.switchTo().frame(0);

Method to switch to other frame  - 2
WebElement fr = driver.findElementById("theIframe");
driver.switchTo().frame(fr);
*/
