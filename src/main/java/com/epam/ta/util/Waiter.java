package com.epam.ta.util;

import com.epam.ta.reporting.MyLogger;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

import java.time.Duration;

public class Waiter {

    private static final int MAX_TIME_OUT = 20;
    private static final int MIN_POLLING_TIME = 2;

    private Waiter(){}

    public static void waitForElementToBeClickable(WebDriver driver, WebElement element) {
        Wait wait = new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(MAX_TIME_OUT))
                .pollingEvery(Duration.ofSeconds(MIN_POLLING_TIME))
                .ignoring(NoSuchElementException.class);

        try {
            wait.until(ExpectedConditions.elementToBeClickable(element));
        } catch (Exception e) {
            MyLogger.error(e.getLocalizedMessage(), e);
        }
    }
}
