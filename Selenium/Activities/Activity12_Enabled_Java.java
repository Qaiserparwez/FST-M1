package Activities;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Activity12_Enabled_Java {
    public static void main(String[] args) throws InterruptedException {
        // Set up Firefox driver
        WebDriverManager.firefoxdriver().setup();
        // Create a new instance of the Firefox driver
        WebDriver driver = new FirefoxDriver();
        // Create the Wait object
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        // Open the page
        driver.get("https://www.training-support.net/selenium/dynamic-controls");
        // Print the title of the page
        System.out.println("Home page title: " + driver.getTitle());

        // Find the text field
        WebElement textbox = driver.findElement(By.id("input-text"));
        // Check if it is enabled
        System.out.println("Input field is enabled: " + textbox.isEnabled());
        // Click the toggle button to enable it
        Thread.sleep(3000);
        driver.findElement(By.id("toggleInput")).click();
        // Check if the text field is enabled
        Thread.sleep(3000);
        System.out.println("Input field is enabled: " + textbox.isEnabled());

        // Close the browser
        driver.quit();
    }
}
