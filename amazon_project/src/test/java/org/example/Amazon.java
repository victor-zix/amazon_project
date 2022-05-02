package org.example;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Amazon {

//  constructor

    public WebDriver driver;

    public Amazon(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }
//  locators

    @FindBy(xpath = "//*[contains(@id, 'searchDropdownBox')]")
    private WebElement searchDropdownBox;

    @FindBy(xpath = "//*[contains(@id, 'searchDropdownBox')]/option[contains(@value, 'search-alias=stripbooks-intl-ship')]")
    private WebElement filterBook;

    @FindBy(xpath = "//input[contains(@id, 'twotabsearchtextbox')]")
    private WebElement searchField;

    @FindBy(xpath = "//input[contains(@id, 'nav-search-submit-button')]")
    private WebElement searchSubmitBtn;

    //  methods
    public void clickAllButton() {
        searchDropdownBox.click();
    }

    public void clickBookButton() {
        filterBook.click();
    }

    public void inputInSearchTextBox(String inputJava) {
        searchField.sendKeys(inputJava);
    }

    public void clickSearchButton() {
        searchSubmitBtn.click();
    }

//  locators for cycle
    @FindBy(xpath = "//div[@data-component-type=\"s-search-result\"][1]//h2/a/span")
    private WebElement anyBookName;


//  locators for book -> Head First Java, 2nd Edition
    @FindBy(xpath = "//span[text()='Head First Java, 2nd Edition']")
    private WebElement bookName;

    @FindBy(xpath = "//a[contains(@href, '/Kathy-Sierra/e')]")
    private WebElement bookAuthorOne;

    @FindBy(xpath = "//a[contains(@href, '/Bert-Bates/e')]")
    private WebElement bookAuthorTwo;

    @FindBy(xpath = "//div/div/div[2]/a[2][contains(@href, 'Head-First-Java')]/span[1]")
    private WebElement bookPrice;

    @FindBy(xpath = "//div[2]/div[contains(@data-asin, '0596009208')]/div/div/div/div/div/div[1]/div/div[1]/div/span/div/span[contains(@id, 'best-seller')]")
    private WebElement bestSellerTag;


    public String getBookName() {
        String bookNameJ = bookName.getText();
        return bookNameJ;
    }

    public String getBookAuthorOne() {
        String bookAuthorOneJ = bookAuthorOne.getText();
        return bookAuthorOneJ;
    }

    public String getBookAuthorTwo() {
        String bookAuthorTwoJ = bookAuthorTwo.getText();
        return bookAuthorTwoJ;
    }

    public String getBookPrice() {
        String bookPriceJ = bookPrice.getText();
        return bookPriceJ;
    }
}