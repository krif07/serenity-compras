package starter.stepdefinitions;

import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;

import starter.builder.Login;
import starter.ui.myaccount.MyAccountForm;
import starter.questions.QuestionData;
import starter.tasks.login.DoLogin;
import starter.tasks.navigation.NavigateTo;

import static org.hamcrest.core.IsEqual.equalTo;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorCalled;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;

public class LoginStepDefinitions {

    String name;

    @Before
    public void setTheStage() {
        OnStage.setTheStage(new OnlineCast());
    }

    @Given("^(.*) is on the login page")
    public void user_is_on_the_login_page(String name) {
        this.name = name;
        theActorCalled(name).attemptsTo(
                NavigateTo.theLoginPage()
        );
    }
    @When("he sends their valid credentials")
    public void he_sends_their_valid_credentials() {
        theActorCalled(this.name).attemptsTo(
                DoLogin.withCredentials("krif07@gmail.com", "backtira1")
        );
    }

    @When("he sends his valid credentials using builder")
    public void he_sends_his_valid_credentials_using_builder() {
        theActorCalled(this.name).attemptsTo(
                Login
                        .with()
                        .username("krif07@gmail.com")
                        .and()
                        .password("backtira1")
                        .and()
                        .doLogin()
        );
    }

    @Then("he should have access to manage his account")
    public void he_should_have_access_to_manage_his_account() {

        theActorInTheSpotlight().should(
                seeThat("The welcome message should be ",
                        QuestionData.welcomeMessage(),
                        equalTo("Welcome to your account. Here you can manage all of your personal information and orders.")
                ),
                seeThat("The title should be ",
                        QuestionData.title(),
                        equalTo("My account")
                ),
                seeThat("The welcome message should be ",
                        QuestionData.welcomeMessage(),
                        equalTo("Welcome to your account. Here you can manage all of your personal information and orders.")
                ),
                seeThat("The title should be ",
                        QuestionData.title(),
                        equalTo("My account")
                )
        );
        theActorInTheSpotlight().attemptsTo(
                Click.on(MyAccountForm.LEFT_MENU.ADD_ADDRESS)
        );
    }

}
