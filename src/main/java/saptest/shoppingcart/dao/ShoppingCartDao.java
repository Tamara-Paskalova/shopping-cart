package saptest.shoppingcart.dao;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import saptest.shoppingcart.model.ShoppingCart;

public interface ShoppingCartDao extends JpaRepository<ShoppingCart, Long> {
    Optional<ShoppingCart> findById(Long id);
}
