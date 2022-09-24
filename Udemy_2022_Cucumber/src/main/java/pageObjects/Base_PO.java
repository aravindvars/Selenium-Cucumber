package pageObjects;

import driver.DriverFactory;
import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import utils.Global_Variables;

import java.time.Duration;

public class Base_PO extends Global_Variables {
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
        WebDriverWait wait  = new WebDriverWait(getDriver(), Duration.ofSeconds(Global_Variables.DEFAULT_TIMEOUT));
        wait.until(ExpectedConditions.elementToBeClickable(by)).sendKeys(textToSend);
    }
    public void sendKeys(WebElement element, String textToSend)
    {
        WebDriverWait wait  = new WebDriverWait(getDriver(), Duration.ofSeconds(Global_Variables.DEFAULT_TIMEOUT));
        wait.until(ExpectedConditions.elementToBeClickable(element)).sendKeys(textToSend);
    }
    public void waitAndClick(By by)
    {
        WebDriverWait wait  = new WebDriverWait(getDriver(), Duration.ofSeconds(Global_Variables.DEFAULT_TIMEOUT));
        wait.until(ExpectedConditions.elementToBeClickable(by)).click();
    }
    public void waitforWebelementAndClick(WebElement element)
    {
        WebDriverWait wait  = new WebDriverWait(getDriver(), Duration.ofSeconds(Global_Variables.DEFAULT_TIMEOUT));
        wait.until(ExpectedConditions.elementToBeClickable(element)).click();
    }
    public void waitfor(By by)
    {
        WebDriverWait wait  = new WebDriverWait(getDriver(), Duration.ofSeconds(Global_Variables.DEFAULT_TIMEOUT));
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(by));
    }
    public void waitfor(WebElement element)
    {
        WebDriverWait wait  = new WebDriverWait(getDriver(), Duration.ofSeconds(Global_Variables.DEFAULT_TIMEOUT));
        wait.until(ExpectedConditions.visibilityOf(element));
    }
    public void waitForAlert_And_ValidateText(String text)
    {
        WebDriverWait wait  = new WebDriverWait(getDriver(), Duration.ofSeconds(Global_Variables.DEFAULT_TIMEOUT));
        wait.until(ExpectedConditions.alertIsPresent());
        String login_Message = getDriver().switchTo().alert().getText();
        Assert.assertEquals(login_Message, text);
    }
}
