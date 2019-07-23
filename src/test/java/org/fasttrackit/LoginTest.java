package org.fasttrackit;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class LoginTest {
    @Test
    public void validLoginTest(){
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
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

        driver.quit();
    }
    @Test
    public void invalidEmailLoginTest(){
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
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

        driver.quit();

    }
     @Test
    public void invalidPasswordLoginTest(){
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://fasttrackit.org/selenium-test/");
        WebElement accountButton=driver.findElement(By.cssSelector("#header > div > div.skip-links > div > a > span.label"));
        accountButton.click();

        WebElement loginLink=driver.findElement(By.cssSelector("#header-account > div > ul > li.last > a"));
        loginLink.click();

        WebElement emailBox=driver.findElement(By.cssSelector("#email"));
        emailBox.sendKeys("madisonqa16@gmail.com");

        WebElement passwordBox=driver.findElement(By.cssSelector("#pass"));
        passwordBox.sendKeys("abc123");

        driver.findElement(By.cssSelector("#send2")).click();

        driver.quit();
    }

}
