package Activities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;


import java.time.Instant;

public class Activity_3_Java {
    public static void main(String[] args) throws InterruptedException {
        // Setup the Firefox driver(GeckoDriver)
        System.setProperty(FirefoxDriver.SystemProperty.BROWSER_LOGFILE, "/dev/null");
        WebDriverManager.firefoxdriver().setup();

        // Create a new instance of the Firefox driver
        WebDriver driver = new FirefoxDriver();
        // Open the page
        driver.get("https://www.training-support.net/selenium/login-form");
        // Print the title of the page
        System.out.println("Home page title: " + driver.getTitle());
        Thread.sleep(3000);

        // Find the username field and enter the username from xpath

        driver.findElement(By.xpath("//input[@id='username']")).sendKeys("admin");
        // Find the password field and enter the password
        driver.findElement(By.xpath("//input[@id='password']")).sendKeys("password");
        Thread.sleep(3000);
        // Find the login button and click it
        driver.findElement(By.xpath("//button[text()='Log in']")).click();




        // Print the confirmation message
        String message = driver.findElement(By.xpath("//input[@id='action-confirmation']")).getText();
        System.out.println("Login message: " + message);
        Thread.sleep(3000);

        // Close the browser
        driver.close();
    }
}
