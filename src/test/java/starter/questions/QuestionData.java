package starter.questions;

import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.TextContent;
import starter.ui.myaccount.MyAccountForm;

public class QuestionData {

    public static Question<String> welcomeMessage() {
        return actor -> (String) TextContent.of(MyAccountForm.MY_ACCOUNT_MESSAGE_LABEL).answeredBy(actor);
    }

    public static Question<String> title() {
        return actor -> (String) TextContent.of(MyAccountForm.MY_ACCOUNT_TITLE_LABEL).answeredBy(actor);
    }
}
