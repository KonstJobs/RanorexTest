package thucydidesTest.steps;

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
    public void get_vip_count(String count) {
        String number = testPage.getVIPcount();
        assertThat("Actual number of vips: " + number + "", number.equals(count));
    }

    @Step
    public void check_database_sate(String state) {
        assertThat("Connection fail", testPage.getConnectionSate(state).equalsIgnoreCase(state));
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
    public void is_button_disabled(String button) {
        assertThat("Button" + button + " is enabled!",
                testPage.isButtonDisabled(button));
    }

    @Step
    public void is_button_enabled(String button) {

        assertThat("Button" + button + " is disabled!",
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
    public void person_should_display_in_database(String parametr, String value) {
        assertThat("fucking assertion", testPage.isPersonDisplayInDataBase(parametr, value));

    }

    @Step
    public void person_should_display_in_database(String firstName, String lastName, Category cat, Gender gen) {
        Person person = new Person(firstName, lastName, cat, gen);
        assertThat("one more fucking assertion",
                testPage.comparePersons(person));
    }

    public void count_persons_on_the_page(String count) {
        Integer countPersons = testPage.findAllPersonsInDatabase().size();
        assertThat("Count persons on the page: " + countPersons,
                count.equals(countPersons.toString()));
    }
    //-------------------------- *** POPUP *** ---------------------------

    @Step
    public void get_popup_message(String message) {
        WebDriver popupDriver = testPage.switchToPopUp();
        String popupMessage = testPage.getPopupMessage(popupDriver);

        assertThat("PopupMessge was: " + popupMessage,
                popupMessage.equals(message));
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
