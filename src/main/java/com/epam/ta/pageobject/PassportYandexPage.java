package com.epam.ta.pageobject;

import com.epam.ta.businessobject.User;
import com.epam.ta.reporting.MyLogger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PassportYandexPage extends AbstractPage {

    private static final String PAGE_URL = "https://passport.yandex.ru/";

    @FindBy(xpath = "//input[@name='login']")
    WebElement userLogin;

    @FindBy(xpath = "//input[@name='passwd']")
    WebElement userPassword;

    @FindBy(xpath = "//button[@type='submit']")
    WebElement enterButton;

    @FindBy(xpath = "//div[@data-t='phone_skip']/button")
    WebElement bindPhoneSkipButton;

    public PassportYandexPage() {
        super();
        PageFactory.initElements(this.driver, this);
    }

    @Override
    public PassportYandexPage openPage() {
        driver.navigate().to(PAGE_URL);
        MyLogger.info("Passport Yandex page is opened");
        return this;
    }

    public YandexDiskFilesPage enterCredentials(User user) {
        sendText(userLogin, user.getName());
        clickOnElement(enterButton);
        sendText(userPassword, user.getPassword());
        clickOnElement(enterButton);
        MyLogger.info("User is logged in yandex.disk");
        return new YandexDiskFilesPage();
    }
}
