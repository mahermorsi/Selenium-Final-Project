package Logic;

import Infrastructure.UI.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class DashboardPage extends BasePage {
    // LOCATORS
    //Duration timeout = Duration.ofSeconds(5);
    private static final By FULL_NAME_INPUT =By.xpath("//a[@id='dashboard']//span[@class='m-text black dashboard-link']");
    public DashboardPage(WebDriver driver) {
        super(driver);
    }
    public boolean isFirstNameUpdated(String name){
        return this.driver.findElements(FULL_NAME_INPUT).getFirst().getText().contains(name);
    }
    public boolean isLastNameUpdated(String lastName){
        return this.driver.findElements(FULL_NAME_INPUT).getLast().getText().contains(lastName);
    }
}
