package stepDefinitions;

import io.cucumber.java.en.*;
import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import static driver.DriverFactory.getDriver;


public class Contact_Us_Steps {
    private WebDriver driver = getDriver();


    public String getRandonNumber(int count)
    {
        return RandomStringUtils.randomNumeric(count);
    }

    public String getRandonString(int count)
    {
        return RandomStringUtils.randomAlphabetic(count);
    }
    @Given("I access webDriver university contact us page")
    public void i_access_web_driver_university_contact_us_page() {
        driver.get("http://www.webdriveruniversity.com/Contact-Us/contactus.html");

    }

    @When("I enter a unique first name")
    public void i_enter_a_unique_first_name() {
        driver.findElement(By.xpath("//form[@id='contact_form']/input[@name='first_name']")).sendKeys("FN"+getRandonNumber(5));

    }
    @And("I enter a unique last name")
    public void i_enter_a_unique_last_name() {
        driver.findElement(By.xpath("//input[@name = 'last_name']")).sendKeys("LN"+getRandonNumber(5));

    }
    @And("I enter a unique email address")
    public void i_enter_a_unique_email_address() {
        driver.findElement(By.xpath("//input[@name = 'email']")).sendKeys("em"+getRandonNumber(10)+"@gmail.com");

    }
    @And("I enter a unique comment")
    public void i_enter_a_unique_comment() {
        driver.findElement(By.xpath("//textarea[@name='message']")).sendKeys("Comment"+getRandonString(25));
    }
    @When("I click on Submit")
    public void i_click_on_submit() {
        driver.findElement(By.xpath("//input[@value='SUBMIT']")).click();
    }

    @Then("I should be displayed with a Thank you message")
    public void i_should_be_displayed_with_a_thank_you_message() {
        String text = driver.findElement(By.xpath("//div[@id = 'contact_reply']/h1")).getText();
        Assert.assertEquals(text,"Thank You for your Message!");
    }
    @When("I enter a specific first name {word}")
    public void i_enter_a_specific_first_name_joe(String firstName) {
driver.findElement(By.xpath("//form[@id='contact_form']/input[@name='first_name']")).sendKeys(firstName);
    }
    @When("I enter a specific last name {word}")
    public void i_enter_a_specific_last_name_blogs(String lastName) throws InterruptedException {
        driver.findElement(By.xpath("//input[@name = 'last_name']")).sendKeys(lastName);

    }
    @When("I enter a specific email address {word}")
    public void i_enter_a_specific_email_address_joeblogs_mail_com(String email) {
        driver.findElement(By.xpath("//input[@name = 'email']")).sendKeys(email);
    }

    @When("I enter a specific comment {string}")
    public void i_enter_a_specific_comment(String string) {
        driver.findElement(By.xpath("//textarea[@name='message']")).sendKeys(string);
    }


}
