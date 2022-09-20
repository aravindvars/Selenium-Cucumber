package stepDefinitions;


import io.cucumber.java.en.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import static driver.DriverFactory.getDriver;


public class Login {
    private WebDriver driver = getDriver();
    @Given("I enter Webdriver Login page")
    public void i_enter_webdriver_login_page() {
        driver.get("http://www.webdriveruniversity.com/Login-Portal/index.html");
    }

    @When("I enter username of {word}")
    public void i_enter_username(String username) {
        driver.findElement(By.xpath("//input[@id = 'text']")).sendKeys(username);
    }

    @And("I enter password of {}")
    public void i_enter_password(String password) {
        driver.findElement(By.xpath("//input[@id = 'password']")).sendKeys(password);
    }

    @And("I click on Login")
    public void i_click_on_login() throws InterruptedException {
        driver.findElement(By.xpath("//button[@id = 'login-button']")).click();

    }

//    @Then("I should be presented with Validation successful message")
//    public void i_should_be_presented_with_validation_successful_message()  {
//        String successmessage = driver.switchTo().alert().getText();
//        Assert.assertEquals(successmessage,"validation succeeded");
//        driver.switchTo().alert().accept();
//
//    }
//    @Then("I should be presented with Validation unsuccessful message")
//    public void i_should_be_presented_with_validation_unsuccessful_message() {
//        String unsuccessmessage = driver.switchTo().alert().getText();
//        Assert.assertEquals(unsuccessmessage,"validation failed");
//        driver.switchTo().alert().accept();
//    }
    @Then("I should be presented with {}")
    public void i_should_be_presented_login_message(String expectedMessage) {
        String loginMessage = driver.switchTo().alert().getText();
        Assert.assertEquals(loginMessage,expectedMessage);
        driver.switchTo().alert().accept();
    }
}
