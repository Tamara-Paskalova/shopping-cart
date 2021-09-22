package saptest.shoppingcart.service.impl;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import org.springframework.stereotype.Service;
import saptest.shoppingcart.dao.ShoppingCartDao;
import saptest.shoppingcart.model.Product;
import saptest.shoppingcart.model.ShoppingCart;
import saptest.shoppingcart.model.Type;
import saptest.shoppingcart.service.ShoppingCartService;

@Service
public class ShoppingCartServiceImpl implements ShoppingCartService {
    private static final BigDecimal DISCOUNT = BigDecimal.valueOf(0.9);
    private final ShoppingCartDao cartDao;

    public ShoppingCartServiceImpl(ShoppingCartDao cartDao) {
        this.cartDao = cartDao;
    }

    @Override
    public void addProduct(Product product, ShoppingCart cart) {
        cart.getProducts().add(product);
    }

    @Override
    public void removeProduct(Product product, ShoppingCart cart) {
        cart.getProducts().remove(product);
        cartDao.save(cart);
    }

    @Override
    public ShoppingCart registerNewShoppingCart() {
        ShoppingCart cart = new ShoppingCart();
        return cartDao.save(cart);
    }

    @Override
    public ShoppingCart getById(Long cartId) {
        return cartDao.findById(cartId).get();
    }

    @Override
    public void calculate(ShoppingCart shoppingCart) {
        Map<Type.TypeValue, List<Product>> map = shoppingCart.getProducts()
                .stream()
                .collect(Collectors.groupingBy(product -> product.getType().getTypeValue()));
        BigDecimal price = BigDecimal.ZERO;
        for (Map.Entry<Type.TypeValue, List<Product>> pair : map.entrySet()) {
            List<Product> list = pair.getValue();
            price = price.add(list.stream()
                    .map(product -> list.size() > 2
                            ? product.getPrice().multiply(DISCOUNT)
                            : product.getPrice())
                    .reduce(BigDecimal::add).get());

        }

        if (price.compareTo(BigDecimal.valueOf(100.0)) > 0) {
            price = price.multiply(DISCOUNT);
        }
        shoppingCart.setTotalPrice(price.setScale(2, RoundingMode.HALF_EVEN));
    }

    @Override
    public void add(ShoppingCart cart) {
        cartDao.save(cart);
    }
}
