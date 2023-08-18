package starter.builder;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import starter.ui.login.LoginForm;

public class Login implements Task {

    private String username;
    private String password;
    private boolean forgotYourPassword;

    public Login(String username, String password, boolean forgotYourPassword) {
        this.username = username;
        this.password = password;
        this.forgotYourPassword = forgotYourPassword;
    }

    public static LoginWith with(){
        return new LoginWith();
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        if(forgotYourPassword) {
            actor.attemptsTo(
                    Click.on(LoginForm.FORGOT_YOUR_PASSWORD_LINK)
            );
        } else {
            actor.attemptsTo(
                    Enter.theValue(username).into(LoginForm.EMAIL_ADDRESS_FIELD),
                    Enter.theValue(password).into(LoginForm.PASSWORD_FIELD),
                    Click.on(LoginForm.SIGN_IN_BUTTON)
            );
        }
    }

    public static class LoginWith {
        private String username;
        private String password;
        private boolean forgotYourPassword;

        public LoginWith username(String username){
            this.username = username;
            return this;
        }

        public LoginWith and() {
            return this;
        }

        public LoginWith password(String password) {
            this.password = password;
            return this;
        }

        public LoginWith forgotYourPassword(boolean forgotYourPassword) {
            this.forgotYourPassword = forgotYourPassword;
            return this;
        }

        public Performable doLogin(){
            return new Login(username, password, forgotYourPassword);
        }
    }
}
