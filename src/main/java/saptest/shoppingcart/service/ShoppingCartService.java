package saptest.shoppingcart.service;

import saptest.shoppingcart.model.Product;
import saptest.shoppingcart.model.ShoppingCart;

public interface ShoppingCartService {
    void addProduct(Product product, ShoppingCart cart);

    void removeProduct(Product product, ShoppingCart cart);

    ShoppingCart registerNewShoppingCart();

    ShoppingCart getById(Long cartId);

    void calculate(ShoppingCart shoppingCart);

    void add(ShoppingCart cart);
}
