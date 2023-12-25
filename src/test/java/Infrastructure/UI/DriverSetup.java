package Infrastructure.UI;
import Infrastructure.ConfigurationReader;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DriverSetup {
    private WebDriver driver;

    public void setupDriver(String driverName) {
        ConfigurationReader.initializeConfig("config.json");
        this.driver = switch (driverName.toLowerCase()) {
            case "chrome" -> {
                System.setProperty("webdriver.chrome.driver", ConfigurationReader.getChromePath());
                yield new ChromeDriver();
            }
            case "firefox" -> {
                System.setProperty("webdriver.gecko.driver", "path/to/geckodriver");
                yield new FirefoxDriver();
            }
            default -> throw new IllegalArgumentException("Invalid driver name: " + driverName);
        };
    }

    public WebDriver getDriver() {
        return this.driver;
    }

    public void closeDriver() {
        driver.quit();
        driver.close();
    }
    public void navigateToURL(String URL) {

        driver.get(URL);
    }
}