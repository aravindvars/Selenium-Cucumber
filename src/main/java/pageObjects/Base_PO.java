package pageObjects;

import driver.DriverFactory;
import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Base_PO {
    public Base_PO()
    {
        PageFactory.initElements(getDriver(), this); //Intialise all PageObjects which extend Base_PO
    }
    public WebDriver getDriver()
    {
        return DriverFactory.getDriver();
    }

    public void navigateTo_URL(String url)
    {
        getDriver().get(url);
    }
    public String getRandonNumber(int count)
    {
        return RandomStringUtils.randomNumeric(count);
    }

    public String getRandonString(int count)
    {
        return RandomStringUtils.randomAlphabetic(count);
    }

    public void sendKeys(By by, String textToSend)
    {
        WebDriverWait wait  = new WebDriverWait(getDriver(), Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(by)).sendKeys(textToSend);
    }
    public void sendKeys(WebElement element, String textToSend)
    {
        WebDriverWait wait  = new WebDriverWait(getDriver(), Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(element)).sendKeys(textToSend);
    }
    public void waitAndClick(By by)
    {
        WebDriverWait wait  = new WebDriverWait(getDriver(), Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(by)).click();
    }
    public void waitAndClick(WebElement element)
    {
        WebDriverWait wait  = new WebDriverWait(getDriver(), Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(element)).click();
    }
}
