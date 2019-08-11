package org.fasttrackit;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class WishListTest {
    @Test
    public void wishListTest() {
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://fasttrackit.org/selenium-test/");

        WebElement headerPage=driver.findElement(By.cssSelector("#header"));
        WebElement headerCategory =driver.findElement(By.cssSelector("#header-nav"));
        WebElement saleCategory=driver.findElement(By.cssSelector("#nav > ol > li.level0.nav-5.parent"));
        saleCategory.click();
        WebElement firstProduct=driver.findElement(By.cssSelector("body > div > div.page > div.main-container.col3-layout > div > div.col-wrapper > div.col-main > div.category-products > ul > li:nth-child(1) > div > h2 > a"));
        WebElement addToWishListFProduct=driver.findElement(By.cssSelector("body > div > div.page > div.main-container.col3-layout > div > div.col-wrapper > div.col-main > div.category-products > ul > li:nth-child(1) > div > div.actions > ul > li:nth-child(1) > a"));
        addToWishListFProduct.click();

        driver.quit();
    }
}

