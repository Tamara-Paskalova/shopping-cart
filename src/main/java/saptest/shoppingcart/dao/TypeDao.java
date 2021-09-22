package saptest.shoppingcart.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import saptest.shoppingcart.model.Type;

public interface TypeDao extends JpaRepository<Type, Long> {
    Type findByTypeValue(Type.TypeValue value);
}
