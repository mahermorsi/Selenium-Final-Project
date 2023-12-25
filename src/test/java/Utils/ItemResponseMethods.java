package Utils;

import Infrastructure.API.WrapApiResponse;
import Logic.ItemApiResponse;

public class ItemResponseMethods {
    public static double getSumOfProductsPrices(WrapApiResponse<ItemApiResponse> itemResult){
        double sumOfTotalPrices = itemResult.getData().getItems().stream()
                .mapToDouble(item -> item.getPrice() * item.getQuantity())
                .sum();
        return sumOfTotalPrices;
    }
}
