package orangeHRM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Activity1 {
    WebDriver driver;

    @BeforeClass
    public void setUp() {
        // Initialize the FirefoxDriver
        driver = new FirefoxDriver();

        // Open the OrangeHRM page
        driver.get("https://alchemy.hguy.co/orangehrm/");
    }

    @Test
    public void verifyHomePageTitle() {
        // Get the title of the page
        String pageTitle = driver.getTitle();

        // Print the page title
        System.out.println("Page Title is: " + pageTitle);

        // Verify the title matches "OrangeHRM"
        Assert.assertEquals(pageTitle, "OrangeHRM", "Title does not match!");
        System.out.println("Title verified successfully!");
    }

    @AfterClass
    public void tearDown() {
        // Close the browser
        driver.quit();
    }
}
