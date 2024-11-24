import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class WebDriverFactory {
    public static WebDriver getWebDriver() {
        switch (System.getProperty("browser")) {
            case "yandex":
                System.setProperty("webdriver.chrome.driver", "src/main/resources/yandexdriver");
                String browserPath = System.getProperty("browserPath");
                if (browserPath != null) {
                    ChromeOptions yandexOptions = new ChromeOptions();
                    yandexOptions.setBinary(browserPath);
                }
                return new ChromeDriver();
            case "chrome":
                WebDriverManager.chromedriver().setup();
                return new ChromeDriver();
            default:
                throw new RuntimeException("Incorrect BrowserName");
        }
    }
}