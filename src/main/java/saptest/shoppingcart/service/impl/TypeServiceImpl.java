package saptest.shoppingcart.service.impl;

import org.springframework.stereotype.Service;
import saptest.shoppingcart.dao.TypeDao;
import saptest.shoppingcart.model.Type;
import saptest.shoppingcart.service.TypeService;

@Service
public class TypeServiceImpl implements TypeService {
    private final TypeDao typeDao;

    public TypeServiceImpl(TypeDao typeDao) {
        this.typeDao = typeDao;
    }

    @Override
    public Type findByName(String name) {
        Type.TypeValue value = Type.TypeValue.valueOf(name);
        return typeDao.findByTypeValue(value);
    }

    @Override
    public Type add(Type type) {
        return typeDao.save(type);
    }
}
