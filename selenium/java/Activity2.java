import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Activity2 {
    public static void main(String[] args) {
        // Set up Firefox driver
        WebDriver driver = new FirefoxDriver();

        // Open the login page
        driver.get("https://training-support.net/webelements/login-form/");

        // Get and print the title of the page
        String pageTitle = driver.getTitle();
        System.out.println("Page Title: " + pageTitle);

        // Find the username field and enter "admin"
        WebElement usernameField = driver.findElement(By.id("username"));
        usernameField.sendKeys("admin");

        // Find the password field and enter "password"
        WebElement passwordField = driver.findElement(By.id("password"));
        passwordField.sendKeys("password");

        // Find and click the "Log in" button using any locator
        WebElement loginButton = driver.findElement(By.xpath("//button[text()='Submit']"));
        loginButton.click();

        // Get and print the login confirmation message
        WebElement confirmationMessage = driver.findElement(By.xpath("//h2"));
        System.out.println("Login message: " + confirmationMessage.getText());


        // Close the browser
        driver.quit();
    }
}
