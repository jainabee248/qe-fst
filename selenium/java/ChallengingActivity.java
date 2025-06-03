import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ChallengingActivity {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));

        driver.get("https://www.google.com");

        // Search for "cheese" and submit
        driver.findElement(By.name("q")).sendKeys("cheese\n");

        // Wait for the results stats to appear (contains 'About' and 'results')
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[contains(text(),'About') and contains(text(),'results')]")));

        // Try to locate the "Tools" element regardless of tag name, by text
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[text()='Tools' or contains(text(),'Tools')]"))).click();

        // Wait 2 seconds to let page update
        Thread.sleep(2000);

        // Wait again for the results stats text after clicking Tools
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[contains(text(),'About') and contains(text(),'results')]")));

        // Get the text of the results stats element
        String results = driver.findElement(By.xpath("//div[contains(text(),'About') and contains(text(),'results')]")).getText();

        System.out.println("Results after clicking Tools: " + results);

        driver.quit();
    }
}