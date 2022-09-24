package pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import utils.Global_Variables;

public class Login_PO extends Base_PO{

    public Login_PO()
    {
        super();
    }
    private @FindBy(id = "text")
    WebElement username_textfield;

    private @FindBy(xpath = "//input[@id = 'password']")
    WebElement password_textfield;

    private @FindBy(xpath = "//button[@id = 'login-button']")
    WebElement loginbutton;
    public void open_WebDriver_Univ_LOgin_Page()
    {
        navigateTo_URL(Global_Variables.WEBDRIVER_UNIV_HOMEPAGE_URL + "/Login-Portal/index.html");
    }

    public void setusername(String username)
    {
        sendKeys(username_textfield, username);
    }
    public void setpasword(String password)
    {
        sendKeys(password_textfield, password);
    }
    public void clickon_login_button()
    {
        waitforWebelementAndClick(loginbutton);
    }
    public void validate_Successfull_Login_Message()
    {
        waitForAlert_And_ValidateText("validation succeeded");
    }
    public void validate_UnSuccessfull_Login_Message()
    {
        waitForAlert_And_ValidateText("validation failed");
    }
}
