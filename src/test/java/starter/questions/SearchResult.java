package starter.questions;

import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.Text;
import starter.ui.search.SearchResultList;

import java.util.Collection;

public class SearchResult {
    public static Question<Collection<String>> titles() {
        return Text.ofEach(SearchResultList.RESULT_TITLES).describedAs("the results displayed");
    }
}
