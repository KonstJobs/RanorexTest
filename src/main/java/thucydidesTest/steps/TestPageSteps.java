package thucydidesTest.steps;

import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;
import static org.hamcrest.MatcherAssert.assertThat;
import thucydidesTest.pages.TestPage;

public class TestPageSteps extends ScenarioSteps {

    private TestPage testPage;

    //-------------------------------------------------------------------------
    @Step
    public void enter_main_page() {
        testPage.open();
    }

    @Step
    public void test_popup() {
        testPage.popup();
    }

    @Step
    public void enter_first_name(String name) {
        testPage.addFirstName(name);
    }

    @Step
    public void enter_second_name(String name) {
        testPage.addSecondName(name);
    }

    @Step
    public void press_button(String buttonName) {
        testPage.pressButton(buttonName);
    }

    @Step
    public void get_vip_count(String count) {
        assertThat("Vip count inst correct", testPage.getVIPcount().equals(count));
    }

}
