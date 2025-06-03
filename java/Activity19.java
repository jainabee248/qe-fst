import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.Alert;

public class Activity19{
    public static void main(String[] args) {
        // Set up the Firefox driver
        WebDriver driver = new FirefoxDriver();

        
            // Open the alerts page
            driver.get("https://training-support.net/webelements/alerts");

            // Print the page title
            System.out.println("Page title is: " + driver.getTitle());

            // Find and click the Confirm Alert button
            WebElement confirmButton = driver.findElement(By.id("confirmation"));
            confirmButton.click();

            // Switch to alert and print the text
            Alert confirmAlert = driver.switchTo().alert();
            System.out.println("Alert text (OK): " + confirmAlert.getText());

            // Accept the alert (click OK)
            confirmAlert.accept();

            // Click the Confirm Alert button again for Cancel
            confirmButton.click();
            confirmAlert = driver.switchTo().alert();
            System.out.println("Alert text (Cancel): " + confirmAlert.getText());

            // Dismiss the alert (click Cancel)
            confirmAlert.dismiss();
         
            // Close the browser
            driver.quit();
        
    }
}