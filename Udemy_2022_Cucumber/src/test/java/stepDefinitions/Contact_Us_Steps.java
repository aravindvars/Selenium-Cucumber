package stepDefinitions;

import io.cucumber.java.en.*;
import org.openqa.selenium.WebDriver;
import pageObjects.Base_PO;
import pageObjects.Contact_Us_PO;


public class Contact_Us_Steps extends Base_PO {
    private WebDriver driver = getDriver();

    public Contact_Us_PO contact_us_po;

    public Contact_Us_Steps(Contact_Us_PO contact_us_po)
    {
    this.contact_us_po = contact_us_po;
    }

    @Given("I access webDriver university contact us page")
    public void i_access_web_driver_university_contact_us_page() {
    contact_us_po.navigate_To_WebDriver_Univ_Contact_us_Page();
    }

    @When("I enter a unique first name")
    public void i_enter_a_unique_first_name() {
        contact_us_po.setUnique_Firstname();
    }
    @And("I enter a unique last name")
    public void i_enter_a_unique_last_name() {
        contact_us_po.setUnique_Lastname();
    }
    @And("I enter a unique email address")
    public void i_enter_a_unique_email_address() {
        contact_us_po.setUniqueEmail();

    }
    @And("I enter a unique comment")
    public void i_enter_a_unique_comment() {
        contact_us_po.setComment();
    }
    @When("I click on Submit")
    public void i_click_on_submit()
    {
        contact_us_po.click_on_Submit_Button();
    }

    @Then("I should be displayed with a Thank you message")
    public void i_should_be_displayed_with_a_thank_you_message() {
        contact_us_po.validate_Successful_Message_Text();
    }
    @When("I enter a specific first name {word}")
    public void i_enter_a_specific_first_name_joe(String firstName) {
    contact_us_po.setSpecific_Firstname(firstName);
    }
    @When("I enter a specific last name {word}")
    public void i_enter_a_specific_last_name_blogs(String lastName) throws InterruptedException {
        contact_us_po.setSpecific_Lastname(lastName);

    }
    @When("I enter a specific email address {word}")
    public void i_enter_a_specific_email_address_joeblogs_mail_com(String email) {
        contact_us_po.setSPecific_email(email);
    }

    @When("I enter a specific comment {string}")
    public void i_enter_a_specific_comment(String string) {
        contact_us_po.setSPecific_comment(string);
    }


}
