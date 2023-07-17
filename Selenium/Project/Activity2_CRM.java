package Activities;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Activity2_CRM {
    @Test

    public void testAssertImageFunctions() {
        WebDriverManager.firefoxdriver().setup();
        WebDriver driver = new FirefoxDriver();
        driver.get("http://alchemy.hguy.co/crm");
        System.out.println("The Title is:" +driver.getTitle());

        WebElement headerImage = driver.findElement(By.xpath("//img[@alt='SuiteCRM']"));
        //String imageUrl = headerImage.getAttribute("SuiteCRM");
        String imageUrl = headerImage.getAttribute("src");

        System.out.println("URL of the header image: " + imageUrl);

        driver.quit();
    }

}
