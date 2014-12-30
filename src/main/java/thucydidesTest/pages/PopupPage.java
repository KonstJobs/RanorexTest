/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package thucydidesTest.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 *
 * @author Конст
 */
public class PopupPage extends TestPage {

    private String popupHadler;
    private WebDriver popupDriver;

    public PopupPage(WebDriver popupDriver) {
        System.out.println("IN CONSTRUCTOR");
        this.popupDriver = popupDriver;
    }

    public PopupPage() {
    }

    public void pressPopupButton(String button) {
        String xpath = "//button[text()='" + button + "']";
        popupDriver.findElement(By.xpath(xpath)).click();
        getDriver().switchTo().window(parentHandler);
    }

    public String getPopupMessage() {
        String xpath = "//div[@id='alertTextOK' or @id='alertTextOKCancel']";
        String text = popupDriver.findElement(By.xpath(xpath)).getText();
        //getDriver().close();
        System.out.println("BEFORE");
        getDriver().switchTo().window(parentHandler);
        
        System.out.println("AFTER");
        return text;
    }

}
