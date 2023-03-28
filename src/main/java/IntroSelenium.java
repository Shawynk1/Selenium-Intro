import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;


public class IntroSelenium {
    public static void main(String[] args) {
        String initialURL = "https://rahulshettyacademy.com/";
        // Invoking Browser
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");

        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Shawy\\Desktop\\Selenium\\chromedriver_win32\\chromedriver.exe");
        ChromeDriver driver = new ChromeDriver(options);
        driver.get(initialURL);
        String title = driver.getTitle();
        System.out.println(title);
        System.out.println(driver.getCurrentUrl().equals(initialURL));

        driver.close();
        driver.quit();
    }
}
