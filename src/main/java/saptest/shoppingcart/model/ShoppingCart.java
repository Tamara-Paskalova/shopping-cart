package saptest.shoppingcart.model;

import java.math.BigDecimal;
import java.util.List;
import java.util.Objects;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@ToString
@RequiredArgsConstructor
public class ShoppingCart {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToMany
    private List<Product> products;
    private BigDecimal totalPrice;

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        ShoppingCart cart = (ShoppingCart) o;
        return Objects.equals(id, cart.id)
                && Objects.equals(products, cart.products)
                && Objects.equals(totalPrice, cart.totalPrice);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, products, totalPrice);
    }
}
