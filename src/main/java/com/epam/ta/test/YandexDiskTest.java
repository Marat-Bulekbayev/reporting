package com.epam.ta.test;

import com.epam.ta.businessobject.User;
import com.epam.ta.driver.Driver;
import com.epam.ta.pageobject.YandexDiskHomePage;
import com.epam.ta.util.TestListener;
import com.epam.ta.util.UserCreator;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners({TestListener.class})
public class YandexDiskTest {

    private static final User YANDEX_DISK_USER = UserCreator.createUser();

    @Test
    public void testMoveToAlbumContextMenu() {
        boolean isFavoritesAlbumDisplayed = new YandexDiskHomePage()
                .openPage()
                .loginToDisk()
                .enterCredentials(YANDEX_DISK_USER)
                .moveFileToAlbum()
                .isFavoritesAlbumDisplayed();

        Assert.assertTrue(isFavoritesAlbumDisplayed, "Favorites album is not displayed");
    }

    @AfterClass
    public void cleanUp() {
        Driver.closeDriver();
    }
}
