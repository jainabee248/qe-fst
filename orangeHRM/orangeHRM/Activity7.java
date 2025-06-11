package orangeHRM;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class Activity7{
    WebDriver driver;
    WebDriverWait wait;
    Actions actions;

    @BeforeClass
    public void setUp() {
        driver = new FirefoxDriver();
        driver.get("https://alchemy.hguy.co/orangehrm/");

        driver.findElement(By.id("txtUsername")).sendKeys("orange");
        driver.findElement(By.id("txtPassword")).sendKeys("orangepassword123");
        driver.findElement(By.id("btnLogin")).click();

        // Initialize WebDriverWait and Actions
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        actions = new Actions(driver);
    }

    @Test
    public void addQualifications() {
        // Hover over My Info
        WebElement myInfoMenu = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("menu_pim_viewMyDetails")));
        Actions actions = new Actions(driver);
        actions.moveToElement(myInfoMenu).perform();

        // Click on My Info to navigate
        myInfoMenu.click();
        myInfoMenu.click();

        // Wait for the left-hand sidenav to appear
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("sidenav")));

        // Click on Qualifications
        WebElement qualificationsLink = wait.until(ExpectedConditions.visibilityOfElementLocated(By.partialLinkText("Qualif")));
        qualificationsLink.click();

        // Wait for Add Work Experience button
        WebElement addButton = wait.until(ExpectedConditions.elementToBeClickable(By.id("addWorkExperience")));
        addButton.click();

        // Fill in the experience details
        driver.findElement(By.id("experience_employer")).sendKeys("Tech Solutions");
        driver.findElement(By.id("experience_jobtitle")).sendKeys("QA Engineer");

        driver.findElement(By.id("experience_from_date")).clear();
        driver.findElement(By.id("experience_from_date")).sendKeys("2025-06-15");
        driver.findElement(By.id("experience_to_date")).clear();
        driver.findElement(By.id("experience_to_date")).sendKeys("2025-06-20");
        try {
            Thread.sleep(3000); // 3 seconds
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        driver.findElement(By.id("btnWorkExpSave")).click();

        // Assert that the new work experience is present
        //boolean recordExists = driver.findElements(By.xpath("//table[@class='table hover']/tbody/tr/td[2][contains(text(), 'Tech Solutions')]")).size() > 0;
        //Assert.assertTrue(recordExists, "New work experience record was not added successfully.");

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("sectionWorkExperience")));

        boolean recordExists = driver.findElements(
                By.xpath("//div[@id='sectionWorkExperience']//table[contains(@class,'hover')]//a[contains(text(), 'Tech Solutions')]")
        ).size() > 0;

        Assert.assertTrue(recordExists, "New work experience record was not added successfully.");

    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }
}
