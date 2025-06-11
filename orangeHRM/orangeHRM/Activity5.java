package orangeHRM;

import java.time.Duration;
import org.openqa.selenium.By;
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

public class Activity5 {
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
    public void editUserInformationTest() {
        // Navigate to My Info (click only once)
        WebElement myInfoTab = wait.until(
                ExpectedConditions.elementToBeClickable(By.id("menu_pim_viewMyDetails"))
        );
        myInfoTab.click();
        myInfoTab.click();

        // Wait until the Edit button becomes available on the Personal Details panel
        WebElement editButton = wait.until(
                ExpectedConditions.elementToBeClickable(By.id("btnSave"))
        );
        editButton.click(); // Enables the fields

        // Now fill in form fields...
        String newFirstName = "Jainabee";
        WebElement firstNameField = wait.until(
                ExpectedConditions.elementToBeClickable(By.id("personal_txtEmpFirstName"))
        );
        firstNameField.clear();
        firstNameField.sendKeys(newFirstName);

        // ... [Last name, gender, nationality, DOB same as before] ...
        // Update Last Name
        String newLastName = "Dudekula";
        WebElement lastNameField = driver.findElement(By.id("personal_txtEmpLastName"));
        lastNameField.clear();
        lastNameField.sendKeys(newLastName);

        // Select Gender
        driver.findElement(By.id("personal_optGender_2")).click(); // Female option

        // Select Nationality
        String newNationality = "Indian";
        WebElement nationalityDropdown = driver.findElement(By.id("personal_cmbNation"));
        Select nationality = new Select(nationalityDropdown);
        nationality.selectByVisibleText(newNationality);

        // Update Date of Birth
        String newDOB = "1995-10-10";
        WebElement dobField = driver.findElement(By.id("personal_DOB"));
        dobField.clear();
        dobField.sendKeys(newDOB);



        // Click Save again
        driver.findElement(By.id("btnSave")).click();

        // Verify the updates
        Assert.assertEquals(
                driver.findElement(By.id("personal_txtEmpFirstName")).getAttribute("value"),
                newFirstName, "First name didn't update"
        );
        // additional assertions...
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }
}
