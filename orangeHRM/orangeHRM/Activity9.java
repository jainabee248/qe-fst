package orangeHRM;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class Activity9 {
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
    public void retrieveEmergencyContacts() {
        // Hover over My Info
        WebElement myInfoMenu = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("menu_pim_viewMyDetails")));
        actions.moveToElement(myInfoMenu).perform();

        // Click on My Info to navigate
        myInfoMenu.click();
        myInfoMenu.click();

        // Wait for the left-hand menu (sidenav) to appear
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("sidenav")));

        // Click on Emergency Contacts link
        WebElement emergencyContactsLink = wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Emergency Contacts")));
        emergencyContactsLink.click();

        // Wait for the emergency contacts table to be visible
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("emgcontact_list")));

        // Retrieve and print emergency contacts table data
        List<WebElement> rows = driver.findElements(By.xpath("//table[@id='emgcontact_list']/tbody/tr"));
        System.out.println("Emergency Contacts:");
        for (WebElement row : rows) {
            List<WebElement> cells = row.findElements(By.tagName("td"));
            for (WebElement cell : cells) {
                System.out.print(cell.getText() + "\t");
            }
            System.out.println();
        }
        assert rows.size() > 0 : "No emergency contacts found!";
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }
}
