import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class Activity16 {
    public static void main(String[] args) {

        // Start Firefox browser
        WebDriver driver = new FirefoxDriver();

        // Open the target web page
        driver.get("https://training-support.net/webelements/selects");

        // Print the page title
        System.out.println("Page title is: " + driver.getTitle());

        // Find the dropdown menu
        WebElement dropdown = driver.findElement(By.cssSelector("select.h-10"));

        // Create a Select object to handle the dropdown
        Select select = new Select(dropdown);

        // Select option "Two" by visible text
        select.selectByVisibleText("Two");
        System.out.println("Selected option: " + select.getFirstSelectedOption().getText());

        // Select the 4th option (index starts at 0)
        select.selectByIndex(3);
        System.out.println("Selected option: " + select.getFirstSelectedOption().getText());

        // Select option using value "four"
        select.selectByValue("four");
        System.out.println("Selected option: " + select.getFirstSelectedOption().getText());

        // Print all options in the dropdown on one line
        System.out.print("All dropdown options: ");
        List<WebElement> options = select.getOptions();
        for (int i = 0; i < options.size(); i++) {
            System.out.print(options.get(i).getText());
            if (i < options.size() - 1) {
                System.out.print(", ");
            }
        }
        System.out.println(); // New line after printing all options

        // Close the browser
        driver.quit();
    }
}
