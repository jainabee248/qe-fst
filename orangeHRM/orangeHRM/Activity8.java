package orangeHRM;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class Activity8 {
    WebDriver driver;
    WebDriverWait wait;

    @BeforeClass
    public void setUp() {
        driver = new FirefoxDriver();
        driver.get("https://alchemy.hguy.co/orangehrm/");

        driver.findElement(By.id("txtUsername")).sendKeys("orange");
        driver.findElement(By.id("txtPassword")).sendKeys("orangepassword123");
        driver.findElement(By.id("btnLogin")).click();

        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    @Test
    public void applyLeave()  {
        // Navigate to Apply Leave
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("menu_leave_viewLeaveModule"))).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("menu_leave_applyLeave"))).click();

        // Fill leave form
        // Select the Leave Type dropdown
        WebElement leaveTypeDropdown = driver.findElement(By.id("applyleave_txtLeaveType"));
        Select leaveType = new Select(leaveTypeDropdown);
        leaveType.selectByVisibleText("DayOff");

        WebElement fromDate = driver.findElement(By.id("applyleave_txtFromDate"));
        fromDate.clear();
        fromDate.sendKeys("2025-06-20");
        fromDate.sendKeys(Keys.ENTER);

        WebElement toDate = driver.findElement(By.id("applyleave_txtToDate"));
        toDate.clear();
        toDate.sendKeys("2025-06-22");
        toDate.sendKeys(Keys.ENTER);
        try {
            Thread.sleep(3000); // 3 seconds
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        driver.findElement(By.id("applyBtn")).click();

        // Navigate to My Leave page to check the status
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("menu_leave_viewMyLeaveList"))).click();

        // Wait for the table to load
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("resultTable")));

        // Print table rows for debugging
        List<WebElement> rows = driver.findElements(By.xpath("//table[@id='resultTable']/tbody/tr"));
       // System.out.println("Number of leave records found: " + rows.size());

        // Check if the applied leave exists
        boolean leaveFound = false;
        for (WebElement row : rows) {
            String rowText = row.getText();
            System.out.println("Row text: " + rowText);
            if (rowText.contains("2025-06-20") && rowText.contains("DayOff")) {
                leaveFound = true;
                break;
            }
        }

        // Assert that the leave record was found
        Assert.assertTrue(leaveFound, "Applied leave record was not found in My Leave page!");
        System.out.println("leave request found");
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }
}

