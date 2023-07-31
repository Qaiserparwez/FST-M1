package Activities;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.testng.Assert;
import org.testng.annotations.Test;


import java.time.Duration;
import java.time.Instant;
import java.util.List;





public class Activity_9_CRM {

    @Test
    public void testAssertTableTraverse2() throws InterruptedException {
        WebDriver driver = new FirefoxDriver();
        System.setProperty(FirefoxDriver.SystemProperty.BROWSER_LOGFILE, "/dev/null");
        WebDriverManager.firefoxdriver().setup();

        //Open the url

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
        //Navigate to Sales >>Leads Page
        System.out.println("*********** Navigating to Leads module *******");
        WebElement leads = driver.findElement(By.id("moduleTab_9_Leads"));
        leads.click();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        Thread.sleep(3000);
        Instant wait;
        //wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h2[@class='module-title-text']")));
        for(int r=1; r<11;r++)
        {
            String name = driver.findElement (By.xpath("//table[contains(@class,'responsive')]/tbody/tr["+r+"]/td[3]")).getText();
            String user = driver.findElement (By.xpath("//table[contains(@class,'responsive')]/tbody/tr["+r+"]/td[8]")).getText();
            System.out.println("Name displayed in Row number "+r+" is: "+name+" and respective User ID is: "+user);

        }
        //List<WebElement> table = driver.findElements(By.xpath("//table[contains(@class,'responsive')]/tbody/tr/td"));
        //close the browser
        //for(WebElement cell : table) {
            //String name = cell.getText();

            //String user = cell.getText();
            //System.out.println("Name: " + name);
            //System.out.println("User: " + user);

        System.out.println("Run Completed");
        //close the browser
        driver.quit();
        }


    }

