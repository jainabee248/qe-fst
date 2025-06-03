import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.By;

public class Activity1Xpath {
    public static void main(String[] args) {
        // Create a new instance of the Firefox driver
        WebDriver driver = new FirefoxDriver();

        // Open the browser to the specified URL
        driver.get("https://training-support.net");

        // Print the title of the homepage
        System.out.println("Home Page Title: " + driver.getTitle());

        // Click on the "About Us" link using XPath
        driver.findElement(By.xpath("//a[contains(text(), 'About Us')]")).click();

        // Print the title of the About Us page
        String aboutTitle = driver.getTitle();
        System.out.println("About Us Page Title: " + aboutTitle);

        // Close the browser
        driver.quit();
    }
}

