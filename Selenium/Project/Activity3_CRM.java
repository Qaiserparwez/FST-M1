package Activities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

public class Activity3_CRM {
    @Test

    public void testAssertFooterText() {
        WebDriverManager.firefoxdriver().setup();
        WebDriver driver = new FirefoxDriver();
        driver.get("http://alchemy.hguy.co/crm");
        System.out.println("The Title is:" +driver.getTitle());
        WebElement footerText = driver.findElement(By.id("admin_options"));

        System.out.println("copyright text in the footer: " + footerText.getText());

        driver.quit();
    }
}
