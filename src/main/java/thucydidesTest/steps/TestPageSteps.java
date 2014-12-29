package thucydidesTest.steps;

import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;
import static org.hamcrest.MatcherAssert.assertThat;
import thucydidesTest.clasess.Category;
import thucydidesTest.clasess.Gender;
import thucydidesTest.clasess.Person;
import thucydidesTest.clasess.PersonBuilder;
import thucydidesTest.pages.TestPage;

public class TestPageSteps extends ScenarioSteps {

    private TestPage testPage;

    //-------------------------------------------------------------------------
    @Step
    public void enter_main_page() {
        testPage.open();
    }

    @Step
    public void test_popup(String message) {
        assertThat("Wrong popup messege", testPage.popup().equals(message));
    }

    @Step
    public void enter_first_name(String name) {
        testPage.addFirstName(name);
    }

    @Step
    public void enter_last_name(String name) {
        testPage.addLastName(name);
    }

    @Step
    public void press_button(String buttonName) {
        testPage.pressButton(buttonName);
    }

    @Step
    public void get_vip_count(String count) {
        assertThat("Vip count isn't correct", testPage.getVIPcount().equals(count));
    }

    @Step
    public void add_persons(String firstName, String lastName) {
        testPage.addPerson(firstName, lastName);
    }

    @Step
    public void add_def_persons(String firstName, String lastName) {
        PersonBuilder personBuilder = new PersonBuilder();
        Person person = personBuilder.createDefPerson(firstName, lastName);
        testPage.addPerson(person);
    }

    public void add_def_persons(String firstName, String lastName, Category category, Gender gender) {
        PersonBuilder personBuilder = new PersonBuilder();
        Person person = personBuilder.createPerson(firstName, lastName, category, gender);
        testPage.addPerson(person);
    }

    public void press_button_connection() {
        testPage.pressButtonConnection();
    }

    public void check_sate(String state) {
        assertThat("Connection fail", testPage.getConnectionSate(state).equalsIgnoreCase(state));
    }

}
