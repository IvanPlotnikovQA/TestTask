package test.pampadu.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.Color;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class CalculatorOSAGO {

    @Test
    public void searchForACar(){
        ChromeDriver driver = new ChromeDriver();
        driver.get("https://b2c.pampadu.ru/index.html#49a973bd-2d7c-4b9b-9c28-d986d7757983");

        WebElement inputMain = (new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.presenceOfElementLocated(
                        By.xpath("//input[@class = 'gos-input-main']"))));
        inputMain.sendKeys("А888АА");

        WebElement inputReg = driver.findElement(By.xpath("//input[@class = 'gos-input-region']"));
        inputReg.sendKeys("01");

        WebElement btn = driver.findElement(By.xpath("//span[@class = 'v-btn__content']"));
        btn.click();

        WebElement element = (new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.presenceOfElementLocated(
                        By.xpath("//input[@id= 'input-25']"))));

        Assert.assertEquals(element.getAttribute("_value"), "Audi");

        driver.quit();
    }

    @Test
    public void searchForACarNotReg(){
        ChromeDriver driver = new ChromeDriver();
        driver.get("https://b2c.pampadu.ru/index.html#49a973bd-2d7c-4b9b-9c28-d986d7757983");

        WebElement inputMain = (new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.presenceOfElementLocated(
                        By.xpath("//input[@class = 'gos-input-main']"))));
        inputMain.sendKeys("А888АА");

        WebElement btn = driver.findElement(By.xpath("//span[@class = 'v-btn__content']"));
        btn.click();

        WebElement inputBar = driver.findElement(By.xpath("//div[@class = 'layout gos-input align-center']"));

        Assert.assertTrue(inputMain.isDisplayed());
        Assert.assertEquals(Color.fromString(inputBar.getCssValue("background-color")).asRgb(), "rgb(254, 212, 203)");

        driver.quit();
    }


    @Test
    public void CheckingTheButtonIDontRememberOrHaventReceivedItYet() {
        ChromeDriver driver = new ChromeDriver();
        driver.get("https://b2c.pampadu.ru/index.html#49a973bd-2d7c-4b9b-9c28-d986d7757983");

        WebElement btn = (new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.presenceOfElementLocated(
                        By.xpath("//span[@class= 'gos-sign-link c-pointer']"))));
        btn.click();

        WebElement inputElement = driver.findElement(By.xpath("//input[@type = 'hidden']"));

        String inputValue = inputElement.getAttribute("value");

        if (inputValue.isEmpty()) {
            System.out.println("Test passed!");
        } else {
            System.out.println("Test failed!");
        }

        driver.quit();
    }

    @Test
    public void CheckIsEmptuInput() {
        ChromeDriver driver = new ChromeDriver();
        driver.get("https://b2c.pampadu.ru/index.html#49a973bd-2d7c-4b9b-9c28-d986d7757983");

        WebElement btn = (new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.presenceOfElementLocated(
                        By.xpath("//button"))));
        btn.click();

        WebElement input = driver.findElement(By.xpath("//input[@class = 'gos-input-main']"));
        WebElement inputBar = driver.findElement(By.xpath("//div[@class = 'layout gos-input align-center']"));

        Assert.assertTrue(input.isDisplayed());
        Assert.assertEquals(Color.fromString(inputBar.getCssValue("background-color")).asRgb(), "rgb(254, 212, 203)");

        driver.quit();
    }



}
