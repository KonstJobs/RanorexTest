package thucydidesTest.pages;

import java.util.List;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import net.thucydides.core.annotations.DefaultUrl;
import org.openqa.selenium.By;
import net.thucydides.core.pages.PageObject;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import net.thucydides.core.pages.WebElementFacade;
import net.thucydides.core.webdriver.stubs.WindowStub;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import thucydidesTest.clasess.Person;

@DefaultUrl("http://www.ranorex.com/web-testing-examples/vip")
public class TestPage extends PageObject {

    
    String parentHandler;

    //------------------------  * Buttons *  ----------------------------
    @FindBy(id = "connect")
    private WebElement buttonConnect;

    @FindBy(id = "Load")
    private WebElement buttonLoad;

    @FindBy(id = "Save")
    private WebElement buttonSave;

    @FindBy(id = "Clear")
    private WebElement buttonClear;

    @FindBy(id = "Add")
    private WebElement buttonAdd;

    //------------------------  * Fields *  ----------------------------
    @FindBy(id = "FirstName")
    private WebElement fieldFristName;

    @FindBy(id = "LastName")
    private WebElement fieldLastName;

    @FindBy(id = "Category")
    private WebElement selectElement;

    @FindBy(id = "count")
    private WebElement fieldVipCount;

    @FindBy(id = "connection")
    private WebElement fieldConnection;

    //------------------------  * Methods *  ----------------------------
    public void addPerson(Person person) {

        fieldFristName.sendKeys(person.getFirstName());
        fieldLastName.sendKeys(person.getLastName());
        selectCategory(person);
        selectGender(person);
        buttonAdd.click();
    }

    private void selectCategory(Person person) {

        Select select = new Select(selectElement);
        String category = person.getCategory().getModifiedCategory();
        select.selectByVisibleText(category);

    }

    private void selectGender(Person person) {

        String gender = person.getGender().getModifiedGender();
        find(By.xpath("//input[@value='" + gender + "']")).click();

    }

    public String getVIPcount() {

        Pattern p = Pattern.compile("\\d+");
        Matcher m = p.matcher(fieldVipCount.getText());
        m.find();
              return m.group();
    }

    public void addFirstName(String name) {
        fieldFristName.sendKeys(name);
    }

    public void addLastName(String name) {
        fieldLastName.sendKeys(name);
    }

    public void pressButton(String buttonName) {
        find(By.id(buttonName)).click();
    }

    public void addDefaultPerson(String firstName, String lastName) {
        fieldFristName.sendKeys(firstName);
        fieldLastName.sendKeys(lastName);
        buttonAdd.click();
    }

    public void pressButtonConnection() {
        buttonConnect.click();
    }

    public String getConnectionSate(String state) {

        new WebDriverWait(getDriver(), 5).
                until(ExpectedConditions.
                        textToBePresentInElement(fieldConnection, state));

        return fieldConnection.getText();
    }

    // ---------------------- *** WORK WITH POPUP *** --------------------------
    public WebDriver switchToPopUp() {

        WebDriver popupDriver = null;
        parentHandler = getDriver().getWindowHandle();
        Set<String> allHendlers = getDriver().getWindowHandles();
        for (String currentHandler : allHendlers) {
            popupDriver = getDriver().switchTo().window(currentHandler);
            if (popupDriver.getTitle().equals("VIP Database")) {
                break;
            }
        }
        return popupDriver;
    }

    public void pressPopupButton(WebDriver popupDriver, String button) {
        String xpath = "//button[text()='" + button + "']";
        popupDriver.findElement(By.xpath(xpath)).click();
        getDriver().switchTo().window(parentHandler);
    }

    public String getPopupMessage(WebDriver popupDriver) {
        String xpath = "//div[@id='alertTextOK' or @id='alertTextOKCancel']";
        String text = popupDriver.findElement(By.xpath(xpath)).getText();
        // getDriver().close();
        getDriver().switchTo().window(parentHandler);
        System.out.println("MESSAGE ***  " + text);
        return text;
    }

    /*------------------------------------------------------------------------*/
    
    
    
    /*---------------------- *** AssertPesons *** --------------------*/
    public void findPerson(int index) {

        for (int i = 1; i <= index; i++) {
            String xpath = "//tr[td/input[@id='VIP']][" + i + "]/td[text()]";
            List<WebElementFacade> list = findAll(By.xpath(xpath));

            for (WebElementFacade elem : list) {
                System.out.println("ELEM : " + elem.getText());
            }
            System.out.println("NEXT ________");
        }
    }

}
