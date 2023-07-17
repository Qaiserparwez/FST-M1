package Activities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

public class Activity4_CRM {
    @Test
    public void testAssertLoginSite() throws InterruptedException {
        WebDriverManager.firefoxdriver().setup();
        //Open the url
        WebDriver driver = new FirefoxDriver();
        driver.get("http://alchemy.hguy.co/crm");
        System.out.println("The Title is:" +driver.getTitle());
        Thread.sleep(3000);
        // Find the username field and enter the username
       driver.findElement(By.id("user_name")).sendKeys("admin");
        // Find the password field and enter the password
        driver.findElement(By.id("username_password")).sendKeys("pa$$w0rd");
        Thread.sleep(3000);
        //Find the login button and click it
        driver.findElement(By.id("bigbutton")).click();
        String message = driver.findElement(By.className("hidden-xs")).getText();
        System.out.println("Login message: " + message);
        //close your browser
        driver.quit();
    }


}
