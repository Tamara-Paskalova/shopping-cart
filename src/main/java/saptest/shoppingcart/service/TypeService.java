package saptest.shoppingcart.service;

import saptest.shoppingcart.model.Type;

public interface TypeService {
    Type findByName(String name);

    Type add(Type type);
}
