package stepDefinitions;
import io.cucumber.java.en.*;
import org.openqa.selenium.WebDriver;
import pageObjects.Base_PO;
import pageObjects.Login_PO;


public class Login extends Base_PO {
    private WebDriver driver = getDriver();

    private Login_PO login_po; //this line of code is used to inject the Login_PO page into this stepDefinition
    public Login(Login_PO login_po)
    {
        this.login_po = login_po;
    }
    @Given("I enter Webdriver Login page")
    public void i_enter_webdriver_login_page() {
        login_po.open_WebDriver_Univ_LOgin_Page();
    }

    @When("I enter username of {word}")
    public void i_enter_username(String username) {
        login_po.setusername(username);
    }

    @And("I enter password of {}")
    public void i_enter_password(String password) {
       login_po.setpasword(password);
    }

    @And("I click on Login")
    public void i_click_on_login() throws InterruptedException {
        login_po.clickon_login_button();

    }

    @Then("I should be see successful login message")
    public void i_should_be_presented_with_successful_login_message()  {
        login_po.validate_Successfull_Login_Message();


    }
    @Then("I should be see unsuccessful login message")
    public void i_should_be_presented_with_validation_unsuccessful_message() {
        login_po.validate_UnSuccessfull_Login_Message();

    }
    @Then("I should be presented with {}")
    public void i_should_be_presented_login_message(String expectedMessage) {
        waitForAlert_And_ValidateText(expectedMessage);

    }
}
