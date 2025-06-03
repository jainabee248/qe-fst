import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;


public class Activity5 {
    public static void main(String[] args) {
        // Set up Firefox driver
        WebDriver driver = new FirefoxDriver();

        // Open the dynamic controls page
        driver.get("https://training-support.net/webelements/dynamic-controls");

        // Get and print the title of the page
        String title = driver.getTitle();
        System.out.println("Page Title: " + title);

        // Find the checkbox input element
        WebElement checkbox = driver.findElement(By.xpath("//input[@type='checkbox']"));

        // Check if the checkbox is visible
        System.out.println("Checkbox is displayed: " + checkbox.isDisplayed());

        // Click the "toggle button" button
        WebElement removeButton = driver.findElement(By.xpath("//button[text()='Toggle Checkbox']"));
        removeButton.click();
        
        WebElement checkbox1 = driver.findElement(By.xpath("//input[@type='checkbox']"));

        // Check if the checkbox is visible
        System.out.println("Checkbox is displayed again: " + checkbox1.isDisplayed());

       

        // Close the browser
        driver.quit();
    }
}

