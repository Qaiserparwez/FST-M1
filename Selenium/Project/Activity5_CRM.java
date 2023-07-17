package Activities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

public class Activity5_CRM {
    @Test
    public void testAssertGetColors() throws InterruptedException {
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
        //Page Confirmation message
        String message = driver.findElement(By.className("hidden-xs")).getText();
        System.out.println("Login message: " + message);
        // Find the  navigation and print its colour
        String ToolBar = driver.findElement(By.id("toolbar")).getCssValue("color");
        System.out.println(ToolBar);
        String ToolBar1 = driver.findElement(By.id("toolbar")).getText();
        System.out.println(ToolBar1);

        driver.quit();
    }
}
