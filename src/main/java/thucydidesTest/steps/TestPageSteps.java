package thucydidesTest.steps;

import static com.thoughtworks.selenium.SeleneseTestBase.*;
import java.util.NoSuchElementException;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;
import static org.hamcrest.MatcherAssert.assertThat;
import org.openqa.selenium.WebDriver;
import thucydidesTest.clasess.Category;
import thucydidesTest.clasess.Gender;
import thucydidesTest.clasess.Person;
import thucydidesTest.pages.TestPage;

public class TestPageSteps extends ScenarioSteps {

    private TestPage testPage;

    //-------------------------- *** STEPS *** -----------------------------------
    @Step
    public void enter_main_page() {
        testPage.open();
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
    public void assert_value_of_the_counter_VIP_count(String count) {
        String number = testPage.getValueOfTheCounterVIPCount();
        assertEquals(count, number);
    }

    @Step
    public void check_database_sate(String state) {
        assertEquals(state, testPage.getConnectionSate(state));
    }

    //-------------------------- *** BUTTONS *** ------------------------
    @Step
    public void press_button(String buttonName) {
        testPage.pressButton(buttonName);
    }

    @Step
    public void press_button_connection() {
        testPage.pressButtonConnection();
    }

    @Step
    public void assert_that_button_is_disabled(String button) {
        assertTrue("Button " + button + " is enabled!", testPage.isButtonDisabled(button));
    }

    @Step
    public void assert_that_button_is_enabled(String button) {
        assertTrue("Button" + button + " is disabled!",
                !testPage.isButtonDisabled(button));
    }

    //-------------------------- *** PERSONS *** ---------------------------
    @Step
    public void add_def_person(String firstName, String lastName) {
        Person person = new Person(firstName, lastName);
        testPage.addDefPerson(person);
    }

    @Step
    public void add_person_to_database(String firstName, String lastName, Category cat, Gender gen) {
        Person person = new Person(firstName, lastName, cat, gen);
        testPage.addDefPerson(person);
    }

    @Step
    public void assert_that_person_is_displayed_in_database(String parametr, String value) {
        assertTrue("Person with " + parametr
                + " and value " + value
                + " doesn't display", testPage.isPersonDisplayInDataBase(parametr, value));

    }

    @Step
    public void assert_that_person_is_displayed_in_database(String firstName, String lastName, Category cat, Gender gen) {
        Person person = new Person(firstName, lastName, cat, gen);
        assertTrue("Person: " + person + " doesn't display",
                testPage.comparePeople(person));
    }

    @Step
    public void select_person(String firstName, String lastName, Category cat, Gender gen) {
        Person person = new Person(firstName, lastName, cat, gen);
        try {
            testPage.selectPerson(person);
        } catch (NoSuchElementException ex) {
            assertTrue("PERSON NOT FOUND ", false);
        }
    }

    @Step
    public void check_number_of_people_in_database(String number) {
        Integer countPersons = testPage.findAllPeopleInDatabase().size();
        assertEquals(number, countPersons.toString());
    }
    //-------------------------- *** POPUP *** ---------------------------

    @Step
    public void check_popup_message(String message) {
        WebDriver popupDriver = testPage.switchToPopUp();
        String popupMessage = testPage.getPopupMessage(popupDriver);

        assertEquals(popupMessage, message);
    }

    @Step
    public void press_button_in_popup(String button) {
        WebDriver popupDriver = testPage.switchToPopUp();
        testPage.pressPopupButton(popupDriver, button);
    }

    @Step
    public void close_popup() {
        WebDriver popupDriver = testPage.switchToPopUp();
        testPage.closePopup(popupDriver);
    }

}
