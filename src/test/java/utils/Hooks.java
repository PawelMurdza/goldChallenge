package utils;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;

public class Hooks extends CommonMethods {

    @BeforeAll
    public static void loadBrowser(){
        driver = setupBrowser();
    }

    @AfterAll
    public static void closeBrowser(){
        if (driver != null) {
            driver.quit(); // Use quit to close all browser windows
        }
    }

    @AfterEach
    void takeScreenshots(){
        takeScreenshot();
    }
}
