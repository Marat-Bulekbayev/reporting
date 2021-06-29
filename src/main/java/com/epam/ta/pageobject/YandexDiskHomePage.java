package com.epam.ta.pageobject;

import com.epam.ta.reporting.MyLogger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class YandexDiskHomePage extends AbstractPage {

    private static final String PAGE_URL = "https://disk.yandex.ru/";

    @FindBy(xpath = "//a[@class='button button_login header__login-link']")
    WebElement enterButton;

    public YandexDiskHomePage() {
        super();
        PageFactory.initElements(this.driver, this);
    }

    @Override
    public YandexDiskHomePage openPage() {
        driver.navigate().to(PAGE_URL);
        MyLogger.info("YandexDisk home page is opened");
        return this;
    }

    public PassportYandexPage loginToDisk() {
        enterButton.click();
        MyLogger.info("User clicked on Enter button and navigated to Passport Yandex page");
        return new PassportYandexPage();
    }
}
