package com.epam.ta.pageobject;

import com.epam.ta.driver.Driver;
import com.epam.ta.util.Waiter;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public abstract class AbstractPage {

    protected WebDriver driver;

    protected abstract AbstractPage openPage();

    protected AbstractPage() {
        this.driver = Driver.getDriver();
    }

    protected void sendText(WebElement element, String text) {
        highlightElement(element);
        element.sendKeys(text);
    }

    protected void clickOnElement(WebElement element) {
        highlightElement(element);
        element.click();
    }

    protected void dragAndDropElement(WebElement element, WebElement target) {
        new Actions(driver).dragAndDrop(element, target).build().perform();
    }

    protected void openContextMenuAndClick(WebElement element, WebElement target) {
        Waiter.waitForElementToBeClickable(driver, element);
        new Actions(driver).contextClick(element).build().perform();
        Waiter.waitForElementToBeClickable(driver, target);
        new Actions(driver).click(target).build().perform();
    }

    protected void highlightElement(WebElement element) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].style.border='3px solid green'", element);
    }

    protected void unHighlightElement(WebElement element) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].style.border='0px'", element);
    }
}
