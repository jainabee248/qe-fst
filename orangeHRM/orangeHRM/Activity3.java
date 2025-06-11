package orangeHRM;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Activity3 {
    WebDriver driver;

    @BeforeClass
    public void setUp() {
        driver = new FirefoxDriver();
        driver.get("https://alchemy.hguy.co/orangehrm/");
    }

    @Test
    public void loginTest() {
        // Enter credentials
        driver.findElement(By.id("txtUsername")).sendKeys("orange");
        driver.findElement(By.id("txtPassword")).sendKeys("orangepassword123");

        // Click login
        driver.findElement(By.id("btnLogin")).click();

        // Verify homepage by checking for the dashboard heading
        String heading = driver.findElement(By.tagName("h1")).getText();
        if (heading.contains("Dashboard")) {
            System.out.println("Login Successful!");
        } else {
            System.out.println("Login Failed!");
        }

        // Assert (optional, for test result)
        Assert.assertTrue(heading.contains("Dashboard"), "Login failed - Dashboard heading not found.");
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }
}
