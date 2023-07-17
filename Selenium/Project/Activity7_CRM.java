package Activities;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import org.testng.annotations.Test;

import java.time.Duration;

public class Activity7_CRM {
    @Test
    public void testAssertAdditionalInfo() throws InterruptedException {
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
        //Initialize Actions Object
        Actions builder = new Actions(driver);
        //Navigate to Sales.
        WebElement Sales = driver.findElement(By.id("grouptab_0"));
        builder.moveToElement(Sales).build().perform();
        //System.out.println("Menu Item is exist as " + MenuCheck);
        //Thread.sleep(3000);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        //Navigate to Sales >>Lead

        WebElement Leads = driver.findElement(By.id("moduleTab_9_Leads"));
        Leads.click();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        Thread.sleep(3000);
        //Navigate to Additional info icon
        WebElement icon = driver.findElement(By.xpath("//span[@class='suitepicon suitepicon-action-info']"));
        icon.click();
        Thread.sleep(3000);
        //Locate the popup
        WebElement popupElement = driver.findElement(By.xpath("//span[@class='phone']")); // Replace with the appropriate locator for the popup element

        builder.moveToElement(popupElement).build().perform();
       // Retrieve the text or content of the popup
        String tooltipMessage = popupElement.getText();
        System.out.println("Mobile:" + tooltipMessage);


       //System.out.println("Menu Item is exist as " + MenuCheck1);
        //Thread.sleep(3000);

        //Close the browser
        driver.quit();
    }

}
