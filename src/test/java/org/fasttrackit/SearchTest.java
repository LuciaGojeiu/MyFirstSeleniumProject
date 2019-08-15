package org.fasttrackit;


import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class SearchTest {
    WebDriver driver;
    @Before
    public void initDriver(){
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
        driver = new ChromeDriver();
    }
   @Test
    public void searchValidTest() {
        driver.get("https://fasttrackit.org/selenium-test/");
        driver.findElement(By.id("search")).sendKeys("sunglasses");
        driver.findElement(By.cssSelector(".button.search-button")).click();
        Assert.assertTrue(driver.findElement(By.cssSelector(".toolbar .sorter .sort-by label")).isDisplayed());
        driver.findElement(By.cssSelector(".actions .button.btn-cart")).click();
        Assert.assertEquals("SHOPPING CART",driver.findElement(By.cssSelector(".page-title.title-buttons h1")).getText());
        Assert.assertTrue(driver.findElement(By.cssSelector(".checkout-types.top .button.btn-proceed-checkout.btn-checkout")).isDisplayed());
        driver.findElement(By.cssSelector(".checkout-types.top .button.btn-proceed-checkout.btn-checkout")).click();
        Assert.assertEquals(driver.findElement(By.cssSelector(".col-1 h3")).getText(),"CHECKOUT AS A GUEST OR REGISTER");
        driver.findElement(By.id("login:guest")).click();
        driver.findElement(By.id("onepage-guest-register-button")).click();
        driver.findElement(By.id("billing:firstname")).sendKeys("Madison");
        driver.findElement(By.id("billing:middlename")).sendKeys("Ella");
        driver.findElement(By.id("billing:lastname")).sendKeys("Smith");
        driver.findElement(By.id("billing:email")).sendKeys("madisonqa16@gmail.com");
        driver.findElement(By.id("billing:street1")).sendKeys("Westwind");
        driver.findElement(By.id("billing:city")).sendKeys("Los Angeles");
        Select drpRegion=new Select(driver.findElement(By.id("billing:region_id")));
        drpRegion.selectByVisibleText("California");
        driver.findElement(By.id("billing:postcode")).sendKeys("12345");
        Select drpCountry=new Select(driver.findElement(By.id("billing:country_id")));
        drpCountry.selectByValue("US");
        driver.findElement(By.id("billing:telephone")).sendKeys("12345678");
        driver.findElement(By.id("billing:use_for_shipping_yes")).click();
        driver.findElement(By.cssSelector("#billing-buttons-container .button")).click();

   }
    @After
    public void quit(){
        driver.quit();
    }

}

