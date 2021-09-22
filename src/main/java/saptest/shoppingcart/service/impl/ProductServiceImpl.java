package saptest.shoppingcart.service.impl;

import org.springframework.stereotype.Service;
import saptest.shoppingcart.dao.ProductDao;
import saptest.shoppingcart.model.Product;
import saptest.shoppingcart.model.Type;
import saptest.shoppingcart.service.ProductService;
import saptest.shoppingcart.service.TypeService;

@Service
public class ProductServiceImpl implements ProductService {
    private final ProductDao productDao;
    private final TypeService typeService;

    public ProductServiceImpl(ProductDao productDao, TypeService typeService) {
        this.productDao = productDao;
        this.typeService = typeService;
    }

    @Override
    public Product add(Product product) {
        Type type = typeService.findByName(product.getType().getTypeValue().name());
        product.setType(type);
        return productDao.save(product);
    }

    @Override
    public Product getById(Long productId) {
        return productDao.findById(productId).get();
    }
}
