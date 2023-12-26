package Logic;

import Infrastructure.UI.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class SearchPom extends BasePage {

    private final String SEARCH_BOX = "//*[@id=\"destination\"]";
    private final String DAIRY_CATEGORY = "//*[@id=\"main-menu-1\"]";
    private final String FILTER = "//*[@id=\"search\"]/div[2]/div/div[1]/div/div[1]/div/div[1]/div[3]/div[2]";
    private final String FITNESS_BRAND = "//*[@id=\"__layout\"]/div/div[1]/div[1]/div[3]/div[3]/div/div[1]/div[2]/div/div[4]/div[2]/label/span";
    private final String BREAD = "לחם";

    public SearchPom(WebDriver driver) {
        super(driver);
    }

    public void searchForAProduct() {
        driver.findElement(By.xpath(SEARCH_BOX)).sendKeys(BREAD);
        driver.findElement(By.xpath(SEARCH_BOX)).sendKeys(Keys.ENTER);
    }

    public boolean checkElement() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"result-search\"]/div/span[2]")));
        return BREAD.contains(driver.findElement(By.xpath("//*[@id=\"result-search\"]/div/span[2]")).getText());
    }

    public void navigateToDairy() {
        driver.findElement(By.xpath(DAIRY_CATEGORY)).click();
    }

    public boolean checkDairyUrl() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement dairyLabel;
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"main-content\"]/div[1]/div[1]/div[2]/h2")));
        dairyLabel = driver.findElement(By.xpath("//*[@id=\"main-content\"]/div[1]/div[1]/div[2]/h2"));
        return dairyLabel.getText().equals("חלב טרי");
    }

    public void filterByBrand() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(FILTER)));
        driver.findElement(By.xpath(FILTER)).click();
        driver.findElement(By.xpath(FITNESS_BRAND)).click();
    }

    public boolean validateFilterResult() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        String FITNESS_FILTER = "//*[@id=\"main-content\"]/div[2]/div/nav/div[1]/span";
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(FITNESS_FILTER)));
        return driver.findElement(By.xpath(FITNESS_FILTER)).isDisplayed();
    }

}
