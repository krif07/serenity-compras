package starter.dashboard;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;

public class WelcomeMessage implements Question<String> {

    public static Question<String> value() {
        return new WelcomeMessage();
    }

    @Override
    public String answeredBy(Actor actor) {
        return BrowseTheWeb.as(actor).find(MyAccountForm.MY_ACCOUNT_MESSAGE_LABEL).waitUntilVisible().getText();
    }
}
