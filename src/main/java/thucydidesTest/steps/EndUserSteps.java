package thucydidesTest.steps;

import thucydidesTest.pages.DictionaryPage;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.pages.Pages;
import net.thucydides.core.steps.ScenarioSteps;

import static ch.lambdaj.Lambda.join;
import org.fest.assertions.Assert;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.hasItem;

public class EndUserSteps extends ScenarioSteps {

    DictionaryPage dictionaryPage;

    @Step
    public void enters(String keyword) {
        dictionaryPage.enter_keywords(keyword);
    }

    @Step
    public void starts_search() {
        dictionaryPage.lookup_terms();
    }

    @Step
    public void should_see_definition(String definition) {
        assertThat(dictionaryPage.getDefinitions(), hasItem(containsString(definition)));
    }

    @Step
    public void is_the_home_page() {
        dictionaryPage.open();
    }

    @Step
    public void looks_for(String term) {
        enters(term);
        starts_search();
    }
    //-------------------------------------------------------------------------

    @Step
    public void enter_first_name(String name) {
        dictionaryPage.addFirstName(name);
    }
    
     @Step
    public void enter_second_name(String name) {
        dictionaryPage.addSecondName(name);
    }
    
     @Step
    public void press_button(String buttonName) {
        dictionaryPage.pressButton(buttonName);
    }
    

    @Step
    public void get_vip_count(String count) {
        assertThat("Не равно бля", dictionaryPage.getVIPcount().equals(count));
    }

}
