package Activities;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

public class GoogleKeep {
    // Driver Declaration
    AndroidDriver driver;
    WebDriverWait wait;

    // Set up method
    @BeforeClass
    public void setUp() throws MalformedURLException {
        // Desired Capabilities
        UiAutomator2Options options = new UiAutomator2Options();
        options.setPlatformName("android");
        options.setAutomationName("UiAutomator2");
        options.setAppPackage("com.google.android.keep");
        options.setAppActivity(".activities.BrowseActivity");
        options.noReset();

        // Server Address
        URL serverURL = new URL("http://localhost:4723/wd/hub");

        // Driver Initialization
        driver = new AndroidDriver(serverURL, options);
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }
    @Test
    public void KeepTest(){
        // Find and click the add button
        driver.findElement(AppiumBy.accessibilityId("New text note")).click();
        // Find the element to Title portion
        driver.findElement(AppiumBy.id("editable_title")).sendKeys("Project Title");
        //edit_note_text
        // Find the element to Description portion
        driver.findElement(AppiumBy.id("edit_note_text")).sendKeys("Description of the title");
        //press the back button
        driver.findElement(AppiumBy.accessibilityId("Navigate up")).click();
        //assertion
        String messageTitle = driver.findElement(AppiumBy.xpath("//android.widget.TextView[@text='Project Title']")).getText();
        Assert.assertEquals(messageTitle, "Project Title");


    }
    // Tear down method

    @AfterClass

    public void tearDown() {

        // Close the app

        driver.quit();

    }


}

