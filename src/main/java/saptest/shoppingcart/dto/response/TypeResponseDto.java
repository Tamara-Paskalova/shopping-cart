package saptest.shoppingcart.dto.response;

import java.io.Serializable;
import lombok.Data;

@Data
public class TypeResponseDto implements Serializable {
    private Long id;
    private String typeValue;
}
