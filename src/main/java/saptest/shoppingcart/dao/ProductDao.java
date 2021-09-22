package saptest.shoppingcart.dao;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import saptest.shoppingcart.model.Product;

public interface ProductDao extends JpaRepository<Product, Long> {
    Optional<Product> findById(Long id);
}
