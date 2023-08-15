package starter.stepdefinitions;

import io.cucumber.java.en.When;
import starter.conf.SessionVariables;

import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
public class WhenStepDefinitions {

    @When("^he tries to remember (.*)")
    public void he_tries_to_remember(String toRemember) {
        theActorInTheSpotlight().remember(SessionVariables.FOO.toString(), toRemember);
    }

}
