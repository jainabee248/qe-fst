package orangeHRM;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Activity2 {
    WebDriver driver;

    @BeforeClass
    public void setUp() {
        // Initialize the FirefoxDriver
        driver = new FirefoxDriver();

        // Open the OrangeHRM page
        driver.get("https://alchemy.hguy.co/orangehrm/");
    }

    @Test
    public void printHeaderImageURL() {
        // Locate the header image using XPath
        WebElement headerImage = driver.findElement(By.xpath("//div[@id='divLogo']//img"));

        // Get the src attribute (URL of the image)
        String imageUrl = headerImage.getDomAttribute("src");
        

        // Print the image URL
        System.out.println("Header Image URL is: " + imageUrl);
    }

    @AfterClass
    public void tearDown() {
        // Close the browser
        driver.quit();
    }
}
