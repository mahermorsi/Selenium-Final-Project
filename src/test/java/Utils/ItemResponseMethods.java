package Utils;

import Infrastructure.API.WrapApiResponse;
import Logic.ItemApiResponse;

public class ItemResponseMethods {
    public static double getSumOfProductsPrices(WrapApiResponse<ItemApiResponse> itemResult){
        return itemResult.getData().getItems().stream()
                .mapToDouble(item -> item.getPrice() * item.getQuantity())
                .sum();
    }
}
