  package org.fasttrackit;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class RegisterTest {
    @Test
    public void registerTest(){
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://fasttrackit.org/selenium-test/");
        WebElement accountButton=driver.findElement(By.cssSelector("#header > div > div.skip-links > div > a > span.label"));
        accountButton.click();

        WebElement registerLink=driver.findElement(By.cssSelector("#header-account > div > ul > li:nth-child(5)"));
        registerLink.click();

        driver.findElement(By.id("firstname")).sendKeys("Madison");
        driver.findElement(By.id("middlename")).sendKeys("Ella");
        driver.findElement(By.id("lastname")).sendKeys("Smith");
        driver.findElement(By.name("email")).sendKeys("madisonqa16@gmail.com");
        driver.findElement(By.name("password")).sendKeys("123abc");
        driver.findElement(By.name("confirmation")).sendKeys("123abc");
        driver.findElement(By.name("is_subscribed")).click();
        driver.quit();

    }

}
