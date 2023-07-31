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
import java.time.Instant;
import java.util.List;

public class Activity8_CRM {
    @Test
    public void testAssertTableTraverse() throws InterruptedException {
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
        //Navigate to Sales >>Account Page
        System.out.println("*********** Navigating to Accounts module *********");

        WebElement account = driver.findElement(By.id("moduleTab_9_Accounts"));
        account.click();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        Thread.sleep(3000);
        List<WebElement> thirdRow = driver.findElements(By.xpath("//table[contains(@class,'responsive')]/tbody/tr[position() mod 2 =1][position()<6]/td[3]"));
        //List<WebElement> elements = driver.findElements(By.xpath("//table[contains(@class,'responsive')]/tbody/tr[position() mod 2 =1][position()<6]/td[3]"));
        System.out.println("The size of the list elements is: " + thirdRow.size());
        for (WebElement cell : thirdRow) {
            String name = cell.getText();
            System.out.println("The Names of the first 5 Odd Rows are: " + name);

        }
        System.out.println("Run Completed");
        //Close the browser
        driver.quit();

    }
}
