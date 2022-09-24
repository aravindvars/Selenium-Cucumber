package pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.testng.Assert;
import utils.Global_Variables;

public class Contact_Us_PO extends Base_PO {
    private @FindBy(how = How.XPATH, using = "//form[@id='contact_form']/input[@name='first_name']")
    WebElement firstname_textfield;
    private @FindBy(xpath = "//input[@name = 'last_name']")
    WebElement lastname_textfield;
    private @FindBy(xpath = "//input[@name = 'email']")
    WebElement email_Testfield;
    private @FindBy(xpath = "//textarea[@name='message']")
    WebElement comment_Textfield;
    private @FindBy(xpath = "//input[@value='SUBMIT']")
    WebElement submit_button;
    private @FindBy(xpath = "//div[@id = 'contact_reply']/h1")
    WebElement successful_Submission_Message;

    public Contact_Us_PO() {
        super();
    }

    public void navigate_To_WebDriver_Univ_Contact_us_Page() {
        navigateTo_URL(Global_Variables.WEBDRIVER_UNIV_HOMEPAGE_URL + "/Contact-Us/contactus.html");
    }

    public void setUnique_Firstname() {
        sendKeys(firstname_textfield, "FN" + getRandonNumber(5));
    }

    public void setUnique_Lastname() {
        sendKeys(lastname_textfield, "LN" + getRandonNumber(5));
    }

    public void setUniqueEmail() {
        sendKeys(email_Testfield, "em" + getRandonNumber(10) + "@gmail.com");
    }

    public void setComment() {
        sendKeys(comment_Textfield, "Hello World" + getRandonString(25));
    }

    public void click_on_Submit_Button() {
        waitforWebelementAndClick(submit_button);
    }

    public void setSpecific_Firstname(String firstname) {
        sendKeys(firstname_textfield, firstname);
    }

    public void setSpecific_Lastname(String lastname) {
        sendKeys(lastname_textfield, lastname);
    }

    public void setSPecific_email(String email) {
        sendKeys(email_Testfield, email);
    }

    public void setSPecific_comment(String comment) {
        sendKeys(comment_Textfield, comment);
    }

    public void validate_Successful_Message_Text()
    {
    waitfor(successful_Submission_Message);
        Assert.assertEquals(successful_Submission_Message.getText(),"Thank You for your Message!");
    }
}
