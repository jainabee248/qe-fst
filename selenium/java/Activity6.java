import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Activity6 {
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

        // Check if the checkbox is selected
        System.out.println("Checkbox selected (before click): " + checkbox.isSelected());

        // Click the checkbox to select it
        checkbox.click();

        // Check if the checkbox is selected again
        System.out.println("Checkbox selected (after click): " + checkbox.isSelected());

        // Close the browser
        driver.quit();
    }
}

