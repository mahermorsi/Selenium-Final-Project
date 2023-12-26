package Logic;

import Infrastructure.API.WrapApiResponse;
import Infrastructure.ConfigurationReader;
import Infrastructure.UI.BasePage;
import Logic.Enum.Products;
import Utils.DateTimeFormat;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.IOException;
import java.net.http.HttpResponse;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;

import static Utils.ApiResponseParser.getItemJsonData;


public class MainPage extends BasePage {
    Duration timeout = Duration.ofSeconds(10);
    private final By SUM_SHEKELS = By.xpath("//*[@id=\"onlineCartHeader\"]/div[1]/div[2]/span/span[1]");
    private final By SUM_AGOROT = By.xpath("//*[@id=\"onlineCartHeader\"]/div[1]/div[2]/span/span[1]/sup");
    private final By CART_COUNT = By.xpath("//div[@id='market']/ul/li");
    private final By VALIDATE_USER_ELEMENT = By.xpath("//span[contains(text(),'maher')]");
    private final By LOGIN_BUTTON = By.xpath("//div[@id='login-user']");

    public MainPage(WebDriver driver) {
        super(driver);

    }

    public WrapApiResponse<ItemApiResponse> addProductsToCart(List<Products> products) throws IOException {
        ConfigurationReader.initializeConfig("config.json");
        ApiCalls apiCalls = new ApiCalls();
        WrapApiResponse<ItemApiResponse> itemResult;
        String store = "279";
        int isClub = 0;
        String supplyAt = DateTimeFormat.getCurrentDateTime();
        HashMap<String,String> items = new HashMap<>();
        for (Products product : products) {
            items.put(product.getId(), "1.00");
        }
        ItemBodyRequest jsonBody = new ItemBodyRequest(store,isClub,supplyAt,items,null);
        itemResult= apiCalls.addItemsToCart(jsonBody.toString());
        itemResult.setData(getItemJsonData(itemResult.getData()));
        return itemResult;
    }

    public HttpResponse removeAllProductsFromCart() throws IOException, InterruptedException {
        ApiCalls apiCalls = new ApiCalls();
        HttpResponse emptyItemResult;
        emptyItemResult = apiCalls.removeAllItemsFromCart(null);
        return emptyItemResult;
    }
    public int validateProductCount() {
       return driver.findElements(CART_COUNT).size();
    }

    public double getTotalPrice() {
        String sumShekels = driver.findElement(SUM_SHEKELS).getText();
        String cleanedString = sumShekels.replace(" ₪", "");
        return (Double.parseDouble(cleanedString));
    }
    public boolean validateLogIn() {
        driver.manage().window().fullscreen();
        return new WebDriverWait(this.driver,timeout).until(ExpectedConditions.visibilityOfElementLocated(VALIDATE_USER_ELEMENT)).isDisplayed();
    }
    public void clickLogIn() {
        new WebDriverWait(this.driver, timeout)
                .until(ExpectedConditions
                        .elementToBeClickable(LOGIN_BUTTON)).click();
    }
}