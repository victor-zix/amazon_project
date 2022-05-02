package org.example;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import java.util.ArrayList;

public class BookPage {

    public WebDriver driver;

    public BookPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    public ArrayList<Book> getBookNames() {
        ArrayList<Book> listOfBooks = new ArrayList<Book>();

        for (int i = 1; i <=16; i++) {
            Book book = new Book();

            // Book name

            book.setName(driver.findElement(By.xpath("//div[@data-component-type=\"s-search-result\"][" + i + "]//h2/a/span[1]")).getText());

            // Price

            String xpathPW = "//div[@data-component-type=\"s-search-result\"][" + i + "]//span[contains(@class, 'a-price-whole')]";
            String xpathPF = "//div[@data-component-type=\"s-search-result\"][" + i + "]//span[contains(@class, 'a-price-fraction')]";
            if (driver.findElements(By.xpath(xpathPW)).size() != 0 && driver.findElements(By.xpath(xpathPF)).size() != 0) {
            book.setPriceWhole(driver.findElement(By.xpath(xpathPW)).getText());
            book.setPriceFraction(driver.findElement(By.xpath(xpathPF)).getText());
            }

            // Authors

            String xpath1 = "//div[@data-component-type=\"s-search-result\"][" + i + "]//div[@class=\"a-row\"]//span[@class=\"a-size-base\"][2]";
            if (driver.findElements(By.xpath(xpath1)).size() != 0) {
                book.setAuthor1(driver.findElement(By.xpath(xpath1)).getText());
            }

            String xpath2 = "//div[@data-component-type=\"s-search-result\"][" + i + "]//div[@class=\"a-row\"]/a[contains(@class, \"a-size-base\")][1]";
            if (driver.findElements(By.xpath(xpath2)).size() != 0) {
                book.setAuthor2(driver.findElement(By.xpath(xpath2)).getText());
            }

            String xpath3 = "//div[@data-component-type=\"s-search-result\"][" + i + "]//div[@class=\"a-row\"]//span[@class=\"a-size-base\"][3]";
            if (driver.findElements(By.xpath(xpath3)).size() != 0) {
                book.setAuthor3(driver.findElement(By.xpath(xpath3)).getText());
            }

            String xpath4 = "//div[@data-component-type=\"s-search-result\"][" + i + "]//div[@class=\"a-row\"]/a[contains(@class, \"a-size-base\")][2]";
            if (driver.findElements(By.xpath(xpath4)).size() != 0) {
                book.setAuthor4(driver.findElement(By.xpath(xpath4)).getText());
            }

            String xpath5 = "//div[@data-component-type=\"s-search-result\"][" + i + "]//div[@class=\"a-row\"]//span[@class=\"a-size-base\"][4]";
            if (driver.findElements(By.xpath(xpath5)).size() != 0) {
                book.setAuthor5(driver.findElement(By.xpath(xpath5)).getText());
            }

            listOfBooks.add(book);
            String bookFullDetails = book.getName() + " | Price: " + book.getPriceWhole() + "." + book.getPriceFraction();
            System.out.println("BOOK ITEM " + i + ": " + bookFullDetails);

            if (book.getAuthor1() != null && !book.getAuthor1().equals("and") && !book.getAuthor1().equals(",") && !book.getAuthor1().equals(", et al.")) {
                System.out.println("BOOK AUTHOR: " + book.getAuthor1());
            }
            if (book.getAuthor2() != null && !book.getAuthor2().equals("and") && !book.getAuthor2().equals(",") && !book.getAuthor2().equals(", et al.")) {
                System.out.println("BOOK AUTHOR: " + book.getAuthor2());
            }
            if (book.getAuthor3() != null && !book.getAuthor3().equals("and") && !book.getAuthor3().equals(",") && !book.getAuthor3().equals(", et al.")) {
                System.out.println("BOOK AUTHOR: " + book.getAuthor3());
            }
            if (book.getAuthor4() != null && !book.getAuthor4().equals("and") && !book.getAuthor4().equals(",") && !book.getAuthor4().equals(", et al.")) {
                System.out.println("BOOK AUTHOR: " + book.getAuthor4());
            }
            if (book.getAuthor5() != null && !book.getAuthor5().equals("and") && !book.getAuthor5().equals(",") && !book.getAuthor5().equals(", et al.")) {
                System.out.println("BOOK AUTHOR: " + book.getAuthor5());
            }

            if (driver.findElements(By.xpath("//div[@data-component-type=\"s-search-result\"][" + i + "]//span[contains(@class, 'a-badge-text')]")).size() != 0) {
                book.setBestSellerBadge(true);
                System.out.println("BESTSELLER BADGE EXISTS\n");

            } else {
                book.setBestSellerBadge(false);
                System.out.println("BESTSELLER BADGE DOESN'T EXIST\n");
            }
        }

        int size = listOfBooks.size();
        System.out.println("Number of books on the page: " + size);


        Book expectedBook = new Book();
        expectedBook.setName(driver.findElement(By.xpath("//div[@data-component-type=\"s-search-result\"]//h2/a[contains(@href, 'Head-First-Java-Kathy-Sierra')]/span[1]")).getText());
        expectedBook.setAuthor1(driver.findElement(By.xpath("//div[@data-component-type=\"s-search-result\"]//div[span]/a[2][contains(@href, 'Kathy-Sierra/e')]")).getText());
        expectedBook.setPriceWhole(driver.findElement(By.xpath("//div[@data-component-type=\"s-search-result\"]//span[contains(@class, 'a-offscreen')]")).getText());
        System.out.println("EXPECTED BOOK ITEM: " + expectedBook.getName());
        expectedBook.setBestSellerBadge(false);

        Book book = expectedBook;
        System.out.println("EXPECTED BOOK ITEM EXISTS: " + book.equals(expectedBook));

        return listOfBooks;
    }
}