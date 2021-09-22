package saptest.shoppingcart.service;

import saptest.shoppingcart.model.Product;

public interface ProductService {
    Product add(Product product);

    Product getById(Long productId);
}
