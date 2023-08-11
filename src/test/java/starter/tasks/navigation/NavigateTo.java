package starter.tasks.navigation;

import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Open;
import starter.ui.login.LoginPage;

public class NavigateTo {
    public static Performable theLoginPage() {
        return Task.where("{0} opens the login page",
                Open.browserOn().the(LoginPage.class));
    }
}
