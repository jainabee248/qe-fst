package orangeHRM;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class Activity4 {
    WebDriver driver;
    WebDriverWait wait;

    @BeforeClass
    public void setUp() {
        // Set system property for GeckoDriver (update the path accordingly)
       // System.setProperty("webdriver.gecko.driver", "path/to/geckodriver");

        // Initialize WebDriver and WebDriverWait
        driver = new FirefoxDriver();
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        // Open OrangeHRM
        driver.get("https://alchemy.hguy.co/orangehrm/");

        // Login
        driver.findElement(By.id("txtUsername")).sendKeys("orange");
        driver.findElement(By.id("txtPassword")).sendKeys("orangepassword123");
        driver.findElement(By.id("btnLogin")).click();
    }

    @Test
    public void addEmployee() {
        // Navigate to PIM module
        driver.findElement(By.id("menu_pim_viewPimModule")).click();

        // Click Add Employee
        wait.until(ExpectedConditions.elementToBeClickable(By.id("menu_pim_addEmployee"))).click();

        // Fill in details
        String firstName = "Jainabee";
        String lastName = "Dudekula";

        driver.findElement(By.id("firstName")).sendKeys(firstName);
        driver.findElement(By.id("lastName")).sendKeys(lastName);

        // Capture the auto-generated employee ID for verification
        String employeeId = driver.findElement(By.id("employeeId")).getAttribute("value");
        System.out.println("Generated Employee ID: " + employeeId);

        // Click Save
        driver.findElement(By.id("btnSave")).click();

        // Verify that the Personal Details page loaded
        WebElement profileHeader = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("profile-pic")));
        String profileName = profileHeader.getText();
        System.out.println("Added Employee Name: " + profileName);

        Assert.assertTrue(profileName.contains(firstName), "First name does not match in the profile header.");

        // Navigate back to Employee List to verify
        driver.findElement(By.id("menu_pim_viewEmployeeList")).click();

        // Wait for the Employee List table to load
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("resultTable")));

        // Search for the newly added employee
        driver.findElement(By.id("empsearch_id")).sendKeys(employeeId);
        driver.findElement(By.id("searchBtn")).click();

        // Verify that the employee appears in the search results
        List<WebElement> rows = driver.findElements(By.xpath("//table[@id='resultTable']/tbody/tr"));
        Assert.assertTrue(rows.size() >= 1, "No employee found in the search results.");

        String resultName = rows.get(0).findElement(By.xpath("./td[3]/a")).getText();
        System.out.println("Employee listed in search results: " + resultName);

        Assert.assertTrue(resultName.contains(firstName), "Employee name does not match in the Employee List.");
    }

    @AfterClass
    public void tearDown() {
        // Close the browser
        driver.quit();
    }
}
