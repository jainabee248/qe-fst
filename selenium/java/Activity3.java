import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Activity3 {
    public static void main(String[] args) {
       
        WebDriver driver = new FirefoxDriver();

       
        driver.get("https://training-support.net/webelements/login-form/");

       
        String pageTitle = driver.getTitle();
        System.out.println("Page Title: " + pageTitle);

        
        WebElement usernameField = driver.findElement(By.xpath("//input[@id='username']"));
        usernameField.sendKeys("admin");

        
        WebElement passwordField = driver.findElement(By.xpath("//input[@id='password']"));
        passwordField.sendKeys("password");

        // Find and click the "Log in" button using XPath
        WebElement loginButton = driver.findElement(By.xpath("//button[text()='Submit']"));
        loginButton.click();

        // Get and print the login confirmation message using XPath
        String message = driver.findElement(By.xpath("//h1[contains(text(), 'Success')]")).getText();
        System.out.println(message);

        // Close the browser
        driver.quit();
    }
}

