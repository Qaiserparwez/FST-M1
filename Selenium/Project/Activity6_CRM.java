package Activities;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;

public class Activity6_CRM {
    @Test
    public void testAssertMenuChecking() throws InterruptedException {
        WebDriverManager.firefoxdriver().setup();
        //Open the url
        WebDriver driver = new FirefoxDriver();
        driver.get("http://alchemy.hguy.co/crm");
        System.out.println("The Title is:" + driver.getTitle());
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
        Thread.sleep(3000);
        //Instant wait;
        //wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("hidden-xs")));

        //Locate Menu Item
        String MenuCheck = driver.findElement(By.id("grouptab_3")).getText();

        System.out.println("Menu Item is exist as " + MenuCheck);

        //Close te browser
        driver.quit();

    }
}