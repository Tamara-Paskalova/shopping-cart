package saptest.shoppingcart.dto.response;

import java.io.Serializable;
import java.util.List;
import lombok.Data;

@Data
public class ShoppingCartResponseDto implements Serializable {
    private Long id;
    private List<ProductResponseDto> products;
    private double price;
}
