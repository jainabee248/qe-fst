import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

public class Activity10 {
    public static void main(String[] args) throws InterruptedException {
        

        // Initialize the FirefoxDriver
        WebDriver driver = new FirefoxDriver();

        // Initialize Actions class
        Actions actions = new Actions(driver);

        // Open the target URL
        driver.get("https://training-support.net/webelements/drag-drop");
        System.out.println("Page title is: " + driver.getTitle());

        // Locate the elements
        WebElement football = driver.findElement(By.id("ball"));
        WebElement dropzone1 = driver.findElement(By.id("dropzone1"));
        WebElement dropzone2 = driver.findElement(By.id("dropzone2"));

        // Perform drag and drop to dropzone1
        actions.clickAndHold(football).moveToElement(dropzone1).release().perform();

        // Wait for 2 seconds to allow the action to complete
       
        
        //Thread.sleep(2000);

        // Check if the ball was dropped in dropzone1
        String dropText1 = dropzone1.findElement(By.className("dropzone-text")).getText();
        if (dropText1.equals("Dropped!")) {
            System.out.println("Ball was dropped in Dropzone 1");
        }

        // Perform drag and drop to dropzone2
        actions.clickAndHold(football).moveToElement(dropzone2).release().perform();

        // Wait for 2 seconds to allow the action to complete
        //Thread.sleep(2000);

        // Check if the ball was dropped in dropzone2
        String dropText2 = dropzone2.findElement(By.className("dropzone-text")).getText();
        if (dropText2.equals("Dropped!")) {
            System.out.println("Ball was dropped in Dropzone 2");
        }

        // Close the browser
        driver.quit();
    }
}
