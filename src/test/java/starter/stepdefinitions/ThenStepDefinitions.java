package starter.stepdefinitions;

import io.cucumber.java.en.Then;
import net.serenitybdd.screenplay.ensure.Ensure;
import starter.conf.SessionVariables;

import static org.hamcrest.core.IsEqual.equalTo;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;

import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;

public class ThenStepDefinitions {

    @Then("^he should get (.*)")
    public void he_should_get_foo(String toCompare) {
        String valueRecovered = theActorInTheSpotlight().recall(SessionVariables.FOO.toString());
        theActorInTheSpotlight().attemptsTo(
                Ensure.that(valueRecovered).isEqualTo(toCompare)
        );
    }
}
