package Activities;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Activity1_CRM {

    @Test

    public void testAssertFunctions() {
        WebDriverManager.firefoxdriver().setup();
        WebDriver driver = new FirefoxDriver();
        driver.get("http://alchemy.hguy.co/crm");
        System.out.println("The Title is:" +driver.getTitle());
        //String ExpectedString = driver.getTitle();
        //System.out.println(ExpectedString);
        String ActualString = "SuiteCRM";
        System.out.println("DONE2");
        Assert.assertEquals(driver.getTitle(), ActualString);
        driver.quit();
    }

    }

