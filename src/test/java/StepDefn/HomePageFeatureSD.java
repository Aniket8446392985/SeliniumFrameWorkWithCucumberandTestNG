package StepDefn;

import io.cucumber.java.en.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

public class SearchFeatureTest
{
    WebDriver driver;
    String ProductName;
    String OfferPageProductName;
    String OfferPageWindow;

    String HomePagewindow;
    @Given("User is on home page")
    public void user_is_on_home_page()
    {
        driver = new ChromeDriver();
        driver.get("https://rahulshettyacademy.com/seleniumPractise/#/");
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
    }
    @When("User search product with shorter keyword like {string}")
    public void user_search_product_with_shorter_keyword_like(String ShortName)
    {
        driver.findElement(By.xpath("//input[@class=\"search-keyword\"]"))
                .sendKeys(ShortName);
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        ProductName=driver.findElement(By.xpath("//div/h4[contains(text(),'Tomato - 1 Kg')]"))
                .getText().split("-")[0].trim();
        System.out.println(ProductName);
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);

    }
    @When("User search same short product {string} on offer page")
    public void user_search_same_short_keyword_on_offer_page(String ShortNameOfferPage)
    {
        driver.findElement(By.xpath("//a[normalize-space()='Top Deals']")).click();
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);

        Set<String> windowID=driver.getWindowHandles();
        List<String> WindowList= new ArrayList<>(windowID);

        System.out.println(WindowList.get(0));
        HomePagewindow=WindowList.get(0);
        OfferPageWindow=WindowList.get(1);

        driver.switchTo().window(OfferPageWindow);
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);

        driver.findElement(By.xpath("//div/input[@id=\"search-field\" and @type=\"search\"]")).sendKeys(ShortNameOfferPage);
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);

        OfferPageProductName=driver.findElement(By.xpath("//tbody/tr/td[contains(text(),\"Tomato\")]")).getText();
        System.out.println(OfferPageProductName);

    }
    @Then("Both Search results should match")
    public void both_search_results_should_match()
    {
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        Assert.assertEquals(ProductName,OfferPageProductName);
    }

}
