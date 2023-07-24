package Activities;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.options.UiAutomator2Options;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import io.appium.java_client.android.nativekey.KeyEvent;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.List;

public class GoogleChrome {
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
        options.setAppPackage("com.android.chrome");
        options.setAppActivity("com.google.android.apps.chrome.Main");
        options.noReset();

        // Server Address
        URL serverURL = new URL("http://localhost:4723/wd/hub");

        // Driver Initialization
        driver = new AndroidDriver(serverURL, options);
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        // Open the page in Chrome

        driver.get("https://v1.training-support.net/selenium");
    }
    @Test
    public void Chrome() {
        String UiScrollable = "UiScrollable(UiSelector().scrollable(true))";

        // Wait for page to load
        wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.xpath("//android.view.View[@text='Selenium']")));

        // Just scroll


        driver.findElement(AppiumBy.androidUIAutomator("UiScrollable(new UiSelector()).flingForward()"));
        // Find all the image elements on the page//To-Do List

        driver.findElement(AppiumBy.androidUIAutomator(UiScrollable + ".scrollTextIntoView(\"To-Do List \uF0AE Elements get added at run time \")")).click();
        String[] taskList = new String[3];

        taskList[0]="Add tasks to list";
        taskList[1]="Get number of tasks";
        taskList[2]="Clear the list";
        // Add All tasks
        for (String ac : taskList) {
            wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.xpath("//android.widget.EditText[@resource-id='taskInput']"))).click();
            wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.xpath("//android.widget.EditText[@resource-id='taskInput']"))).sendKeys(ac);
            wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.xpath("//android.widget.Button[@text=\"Add Task\"]")));
            driver.pressKey(new KeyEvent(AndroidKey.TAB));
            driver.pressKey(new KeyEvent(AndroidKey.ENTER));
        }

    }
    @AfterClass

    public void tearDown() {

        // Close the app

        driver.quit();

    }
}