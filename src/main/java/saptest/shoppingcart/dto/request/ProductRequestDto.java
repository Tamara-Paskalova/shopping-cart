package saptest.shoppingcart.dto.request;

import lombok.Data;

@Data
public class ProductRequestDto {
    private String name;
    private String description;
    private double price;
    private TypeRequestDto type;
}
