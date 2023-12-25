package Logic;

import Infrastructure.API.WrapApiResponse;
import Infrastructure.ConfigurationReader;
import Infrastructure.UI.BasePage;
import Logic.Enum.Products;
import Utils.DateTimeFormat;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

public class MainPage extends BasePage {
    private final WebElement PARENT_PRODUCT_LIST = driver.findElement(By.xpath("//*[@id=\"market\"]/ul"));
    private List<WebElement> ChildrenProductList = PARENT_PRODUCT_LIST.findElements(By.tagName("li"));
    private String sumShekels = driver.findElement(By.xpath("//*[@id=\"onlineCartHeader\"]/div[1]/div[2]/span/span[1]")).getText();
    private String sumAgorot = driver.findElement(By.xpath("//*[@id=\"onlineCartHeader\"]/div[1]/div[2]/span/span[1]/sup")).getText();
    private WebElement itemPriceShekels = driver.findElement(By.xpath("//span[@class='currency-wrap']/span"));
    private WebElement itemPriceAgorot = driver.findElement(By.xpath("//span[@class='currency-wrap']/span/sup[@class='sub-price']"));
    private String cartCounter = driver.findElement(By.xpath("//*[@id=\"onlineCartHeader\"]/div[1]/div[1]/span[1]")).getText();

    public MainPage(WebDriver driver) {
        super(driver);
    }

    public void add3ProductsToCart() throws IOException {
        ConfigurationReader.initializeConfig("config.json");
        ApiCalls apiCalls = new ApiCalls();
        WrapApiResponse itemResult;
        String store = "279";
        int isClub = 0;
        String supplyAt = DateTimeFormat.getCurrentDateTime();
        HashMap<String,String> items = new HashMap<>();
        items.put(Products.FINISH.getId(), "2.00");
        items.put(Products.TEA.getId(),"3.00");
        items.put("164854","1.00");
        ItemBodyRequest jsonBody = new ItemBodyRequest(store,isClub,supplyAt,items,null);
        itemResult= apiCalls.addItemsToCart(jsonBody.toString());
        itemResult.setData(getItemJsonData(itemResult.getData()));
    }

    public void removeAllProductFromCart() throws IOException, InterruptedException {
        ApiCalls apiCalls = new ApiCalls();
        WrapApiResponse<ItemApiResponse> emptyItemResult;
        ItemBodyRequest emptyItemJsonBody = new ItemBodyRequest("279",0,DateTimeFormat.getCurrentDateTime(),new HashMap<String,String>	(),null);
        emptyItemResult = (WrapApiResponse<ItemApiResponse>) apiCalls.removeAllItemsFromCart(emptyItemJsonBody.toString());
        System.out.println(emptyItemResult);
    }
    public int validateProductCount() {
        return ChildrenProductList.size();
    }

    public Double getTotalPrice() {
        Double shekels = Double.parseDouble(sumShekels);
        Double agorot = Double.parseDouble(sumAgorot);
        Double totalSum = (shekels + (agorot / 100)) - 29.90;
        return totalSum;
    }

    public double sumOfAllProductsInCart() {
        final AtomicReference<Double> shekelsSum = new AtomicReference<>(0.0);
        final AtomicReference<Double> agorotSum = new AtomicReference<>(0.0);

        ChildrenProductList.forEach(product -> {
            String productShekel = product.findElement((By) itemPriceShekels).getText();
            String productAgorot = product.findElement((By) itemPriceAgorot).getText();
            shekelsSum.updateAndGet(currentSum -> currentSum + Double.parseDouble(productShekel));
            agorotSum.updateAndGet(currentSum -> currentSum + Double.parseDouble(productAgorot) / 100);
        });

        double totalSum = shekelsSum.get() + agorotSum.get();
        return totalSum;
    }

}