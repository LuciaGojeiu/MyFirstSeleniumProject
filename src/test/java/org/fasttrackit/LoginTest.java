package org.fasttrackit;

import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class LoginTest {

    private static WebDriver driver;
    @BeforeClass
    public static void initDriver(){
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
        driver = new ChromeDriver();
    }

    @Test
    public void validLoginTest(){
        driver.get("https://fasttrackit.org/selenium-test/");

        WebElement accountButton=driver.findElement(By.cssSelector("#header > div > div.skip-links > div > a > span.label"));
        accountButton.click();

        WebElement loginLink=driver.findElement(By.cssSelector("#header-account > div > ul > li.last > a"));
        loginLink.click();

        WebElement emailBox=driver.findElement(By.cssSelector("#email"));
        emailBox.sendKeys("madisonqa16@gmail.com");

        WebElement passwordBox=driver.findElement(By.cssSelector("#pass"));
        passwordBox.sendKeys("123abc");

        driver.findElement(By.cssSelector("#send2")).click();

        WebElement helloText=driver.findElement(By.cssSelector(".welcome-msg .hello"));
        Assert.assertEquals("Hello, Madison Ella Smith!",helloText.getText());

        driver.findElement(By.cssSelector("a[href*='account']  .label")).click();
        Assert.assertTrue(driver.findElement(By.cssSelector("a[title='Log Out']")).isDisplayed());

    }
    @Test
    public void invalidEmailLoginTest(){
        driver.get("https://fasttrackit.org/selenium-test/");
        WebElement accountButton=driver.findElement(By.cssSelector("#header > div > div.skip-links > div > a > span.label"));
        accountButton.click();

        WebElement loginLink=driver.findElement(By.cssSelector("#header-account > div > ul > li.last > a"));
        loginLink.click();

        WebElement emailBox=driver.findElement(By.cssSelector("#email"));
        emailBox.sendKeys("madisonqa@gmail.com");

        WebElement passwordBox=driver.findElement(By.cssSelector("#pass"));
        passwordBox.sendKeys("123abc");

        driver.findElement(By.cssSelector("#send2")).click();

        WebElement invalidLoginText=driver.findElement(By.cssSelector(".error-msg span"));
        Assert.assertEquals("Invalid login or password.",invalidLoginText.getText());

        driver.findElement(By.cssSelector("a[href*='account']  .label")).click();
        Assert.assertTrue(driver.findElement(By.cssSelector("a[title='Log In")).isDisplayed());
    }

    @AfterClass
    public static void quit(){
        driver.quit();
    }

}
