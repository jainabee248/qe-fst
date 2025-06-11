package orangeHRM;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Activity6 {
    WebDriver driver;
    WebDriverWait wait;

    @BeforeClass
    public void setUp() {
        driver = new FirefoxDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.get("https://alchemy.hguy.co/orangehrm/");

        // Login
        driver.findElement(By.id("txtUsername")).sendKeys("orange");
        driver.findElement(By.id("txtPassword")).sendKeys("orangepassword123");
        driver.findElement(By.id("btnLogin")).click();
    }

    @Test
    public void verifyDirectoryMenuTest() {
        // Wait for Directory menu item to be visible
        WebElement directoryMenu = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("menu_directory_viewDirectory")));

        // Scroll to Directory menu item
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", directoryMenu);

        // Check if Directory menu item is displayed
        Assert.assertTrue(directoryMenu.isDisplayed(), "Directory menu item is not visible.");

        // Check if Directory menu item is clickable
        wait.until(ExpectedConditions.elementToBeClickable(directoryMenu));
        System.out.println("Directory menu item is clickable.");

        // Click the Directory menu item
        directoryMenu.click();
        directoryMenu.click();

        // Wait for the page to load and verify URL (optional but recommended)
        wait.until(ExpectedConditions.or(
                ExpectedConditions.urlContains("/directory/viewDirectory"),
                ExpectedConditions.titleContains("Search Directory")
        ));

        // Wait for the heading to appear
        WebElement heading = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='head']/h1")));

        // Verify that the heading matches "Search Directory"
        String pageHeading = heading.getText();
        System.out.println("Page heading: " + pageHeading);
        Assert.assertEquals(pageHeading, "Search Directory", "Heading does not match expected text.");
    }

    @AfterClass
    public void tearDown() {

        driver.quit();
    }
}
