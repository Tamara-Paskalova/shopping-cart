package saptest.shoppingcart.dto.response;

import java.io.Serializable;
import lombok.Data;

@Data
public class ProductResponseDto implements Serializable {
    private Long id;
    private String name;
    private String description;
    private double price;
    private TypeResponseDto type;
}
