package utils;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import test.PageInitializer;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.time.Duration;

public class CommonMethods extends PageInitializer {

    public static WebDriver driver;

    public static WebDriver setupBrowser() {

        //setup ChromeDriver
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-search-engine-choice-screen");
        options.addArguments("--start-maximized");

        //uncomment option below to run in headless mode - no visible browser
        //options.addArguments("--headless");

        driver = new ChromeDriver(options);
        driver.navigate().to(Constants.GOOGLE_URL);
        initializePageObjects();
        return driver;
    }

    public static void sendText(WebElement element, String text) {
        getWait().until(ExpectedConditions.elementToBeClickable(element));
        element.clear();
        element.sendKeys(text);
    }

    public static void click(WebElement element) {
        getWait().until(ExpectedConditions.elementToBeClickable(element));
        element.click();
    }

    public static WebDriverWait getWait() {
        return new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public static void waitForTextToChange(WebElement element, String initialText) {
        getWait().until((ExpectedCondition<Boolean>) d -> {
            String currentText = element.getText();
            return currentText != null && !currentText.equals(initialText);
        });
    }

    void takeScreenshot() {
        if (driver instanceof TakesScreenshot screenshotTaker) {
            File screenshot = screenshotTaker.getScreenshotAs(OutputType.FILE);
            try {
                Path destinationPath = Path.of("target", "reports", "screenshots", "test-screenshot" + ".png");
                Files.createDirectories(destinationPath.getParent());  // Ensure the directory exists
                Files.copy(screenshot.toPath(), destinationPath, StandardCopyOption.REPLACE_EXISTING);
                System.out.println("Screenshot saved: " + destinationPath.toAbsolutePath());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
