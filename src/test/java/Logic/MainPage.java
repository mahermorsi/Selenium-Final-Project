package Logic;

import Infrastructure.API.WrapApiResponse;
import Infrastructure.ConfigurationReader;
import Infrastructure.UI.BasePage;
import Logic.Enum.Products;
import Utils.DateTimeFormat;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import java.io.IOException;
import java.net.http.HttpResponse;
import java.util.HashMap;
import static Utils.ApiResponseParser.getItemJsonData;


public class MainPage extends BasePage {
    private final By SUM_SHEKELS = By.xpath("//*[@id=\"onlineCartHeader\"]/div[1]/div[2]/span/span[1]");
    private final By SUM_AGOROT = By.xpath("//*[@id=\"onlineCartHeader\"]/div[1]/div[2]/span/span[1]/sup");

    public MainPage(WebDriver driver) {
        super(driver);

    }

    public WrapApiResponse<ItemApiResponse> add3ProductsToCart() throws IOException {
        ConfigurationReader.initializeConfig("config.json");
        ApiCalls apiCalls = new ApiCalls();
        WrapApiResponse<ItemApiResponse> itemResult;
        String store = "279";
        int isClub = 0;
        String supplyAt = DateTimeFormat.getCurrentDateTime();
        HashMap<String,String> items = new HashMap<>();
        items.put(Products.FINISH.getId(), "1.00");
        items.put(Products.TEA.getId(),"1.00");
        items.put(Products.CHEESE.getId(),"1.00");
        ItemBodyRequest jsonBody = new ItemBodyRequest(store,isClub,supplyAt,items,null);
        itemResult= apiCalls.addItemsToCart(jsonBody.toString());
        itemResult.setData(getItemJsonData(itemResult.getData()));
        return itemResult;
    }

    public HttpResponse removeAllProductFromCart() throws IOException, InterruptedException {
        ApiCalls apiCalls = new ApiCalls();
        HttpResponse emptyItemResult;
        emptyItemResult = apiCalls.removeAllItemsFromCart(null);
        return emptyItemResult;

    }
    public String validateProductCount() {
        return driver.findElement(By.xpath("//*[@id=\"onlineCartHeader\"]/div[1]/div[1]/span[1]")).getText();
    }

    public double getTotalPrice() {
        String sumShekels = driver.findElement(SUM_SHEKELS).getText();
        String sumAgorot = driver.findElement(SUM_AGOROT).getText();
        double shekels = Double.parseDouble(sumShekels);
        double agorot = Double.parseDouble(sumAgorot);
        return (shekels + (agorot / 100));
    }
}