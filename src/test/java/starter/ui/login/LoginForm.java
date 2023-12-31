package starter.ui.login;

import org.openqa.selenium.By;

public class LoginForm {
    public static By EMAIL_ADDRESS_FIELD = By.id("email");
    public static By PASSWORD_FIELD = By.id("passwd");
    public static By FORGOT_YOUR_PASSWORD_LINK = By.cssSelector(".lost_password a");
    public static By SIGN_IN_BUTTON = By.id("SubmitLogin");
}
