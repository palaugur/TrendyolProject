package Pages;

import Utilities.GWD;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPageElements extends Parent {

    public LoginPageElements() {
        PageFactory.initElements(GWD.getDriver(), this);
    }

    @FindBy(css = "div[class='link account-user'] > p[class='link-text']")
    public WebElement myAccount;
    @FindBy(css = "div[class='login-button']")
    public WebElement logIn;
    @FindBy(id = "login-email")
    public WebElement username;
    @FindBy(id = "login-password-input")
    public WebElement password;
    @FindBy(css = "button[type='submit']")
    public WebElement logInBtn;

    @FindBy(css = "span[class='message']")
    public WebElement notificationMessage;

    @FindBy(xpath = "//p[text()='Hesabım']")
    public WebElement myAccountAfterLogin;


    public WebElement getWebElement(String strButton) {
        switch (strButton) {
            case "myAccount":
                return myAccount;
            case "logIn":
                return logIn;
            case "username":
                return username;
            case "logInBtn":
                return logInBtn;
            case "notificationMessage":
                return notificationMessage;
            case "password":
                return password;
            case "myAccountAfterLogin":
                return myAccountAfterLogin;

        }
        return null;

    }
}
