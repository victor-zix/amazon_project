package org.example;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AmazonTestTwo {

//  constructor

public WebDriver driver;
public AmazonTestTwo(WebDriver driver) {
    PageFactory.initElements(driver, this);
    this.driver = driver; }


//  locators

@FindBy(xpath = "//*[contains(@aria-describedby, 'searchDropdownDescription')]")
private WebElement searchDropdownDescription;

@FindBy(xpath = "//*[contains(@aria-describedby, 'searchDropdownDescription')]/option[contains(@value, 'stripbooks-intl-ship')]")
private WebElement filterBook;

@FindBy(xpath = "//input[contains(@id, 'twotabsearchtextbox')]")
private WebElement searchField;

@FindBy(xpath = "//input[contains(@id, 'nav-search-submit-button')]")
private WebElement searchSubmitBtn;

//  methods
public void clickAllButton() {
    searchDropdownDescription.click(); }

public void clickBookButton() {
    filterBook.click(); }

public void inputInSearchTextBox(String inputJava) {
    searchField.sendKeys(inputJava); }

public void clickSearchButton() {
    searchSubmitBtn.click(); }


    //  locators
@FindBy(xpath = "//span[text()='Head First Java, 2nd Edition']")
private WebElement bookName;

@FindBy(xpath = "//a[contains(@href, '/Kathy-Sierra/e')]")
private WebElement bookAuthorOne;

@FindBy(xpath = "//a[contains(@href, '/Bert-Bates/e')]")
private WebElement bookAuthorTwo;

@FindBy(xpath = "//a[contains(@href, 'Head-First-Java-Kathy-Sierra')]/span/span/span[contains(@class, 'a-price-whole')]")
private WebElement bookPrice;

public String getBookName() {
    String bookNameJ = bookName.getText();
    return bookNameJ; }

public String getBookAuthorOne() {
    String bookAuthorOneJ = bookAuthorOne.getText();
    return bookAuthorOneJ; }

public String getBookAuthorTwo() {
    String bookAuthorTwoJ = bookAuthorTwo.getText();
    return bookAuthorTwoJ; }

public String getBookPrice() {
    String bookPriceJ = bookPrice.getText();
    return bookPriceJ; }

}
