package org.fasttrackit;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class WishListTest {

    WebDriver driver;

    @Before
    public void initDriver(){
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
        driver = new ChromeDriver();
    }

    @Test
    public void wishListTest() {
        driver.get("https://fasttrackit.org/selenium-test/");

        WebElement headerPage=driver.findElement(By.cssSelector("#header"));
        WebElement headerCategory =driver.findElement(By.cssSelector("#header-nav"));
        WebElement saleCategory=driver.findElement(By.cssSelector("#nav > ol > li.level0.nav-5.parent"));
        saleCategory.click();
        WebElement firstProduct=driver.findElement(By.cssSelector("body > div > div.page > div.main-container.col3-layout > div > div.col-wrapper > div.col-main > div.category-products > ul > li:nth-child(1) > div > h2 > a"));
        WebElement addToWishListFProduct=driver.findElement(By.cssSelector("body > div > div.page > div.main-container.col3-layout > div > div.col-wrapper > div.col-main > div.category-products > ul > li:nth-child(1) > div > div.actions > ul > li:nth-child(1) > a"));
        addToWishListFProduct.click();

        WebElement loginToAccountMessage =driver.findElement(By.cssSelector(".page-title h1"));
        Assert.assertEquals("LOGIN OR CREATE AN ACCOUNT",loginToAccountMessage.getText());

        WebElement emailBox=driver.findElement(By.cssSelector("#email"));
        emailBox.sendKeys("madisonqa16@gmail.com");

        WebElement passwordBox=driver.findElement(By.cssSelector("#pass"));
        passwordBox.sendKeys("123abc");

        driver.findElement(By.cssSelector("#send2")).click();

        Assert.assertEquals("MY WISHLIST",driver.findElement(By.cssSelector(".page-title.title-buttons h1")).getText());

    }

    @After
    public void quit(){
        driver.quit();
    }
}

