package Activities;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class Activity2 {
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



        // Open the page in Chrome

        driver.get("https://v1.training-support.net");

    }



    // Test method

    @Test

    public void chromeTest() throws InterruptedException {

        // Find heading on the page

        //driver.manage().timeouts().implicitlyWait(TimeOut, TimeUnit.10);
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//android.view.View[@text='Training Support']"))).getText();
        //Thread.sleep(3000);
        //String pageHeading = driver.findElement(AppiumBy.xpath("//android.view.View[@text='Training Support']")).getText();



        // Print to console

        //System.out.println("Heading: " + pageHeading);



        // Find and click the About Us link

        driver.findElement(AppiumBy.xpath("//android.view.View[@resource-id='about-link']")).click();



        // Find heading of new page and print to console
        Thread.sleep(3000);

        String aboutPageHeading = driver.findElement(AppiumBy.xpath("//android.view.View[@text='About Us']")).getText();

        //WebDriverWait wait1 = new WebDriverWait(driver,Duration.ofSeconds(10));
        //wait1.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//android.view.View[@text='About Us']"))).getText();
        Thread.sleep(3000);
        System.out.println(aboutPageHeading);
        //System.out.println();



    }





    // Tear down method

    @AfterClass

    public void tearDown() {

        // Close the app

        driver.quit();

    }
}
