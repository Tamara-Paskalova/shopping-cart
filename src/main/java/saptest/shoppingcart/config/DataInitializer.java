package saptest.shoppingcart.config;

import javax.annotation.PostConstruct;
import org.springframework.stereotype.Component;
import saptest.shoppingcart.model.Type;
import saptest.shoppingcart.service.TypeService;

@Component
public class DataInitializer {
    private final TypeService service;

    public DataInitializer(TypeService service) {
        this.service = service;
    }

    @PostConstruct
    void inject() {
        Type appliance = new Type();
        appliance.setTypeValue(Type.TypeValue.APPLIANCE);
        service.add(appliance);
        Type gift = new Type();
        gift.setTypeValue(Type.TypeValue.GIFT);
        service.add(gift);
        Type grocery = new Type();
        grocery.setTypeValue(Type.TypeValue.GROCERY);
        service.add(grocery);
        Type kitchenware = new Type();
        kitchenware.setTypeValue(Type.TypeValue.KITCHENWARE);
        service.add(kitchenware);
        Type sportEquipment = new Type();
        sportEquipment.setTypeValue(Type.TypeValue.SPORT_EQUIPMENT);
        service.add(sportEquipment);
        Type toy = new Type();
        toy.setTypeValue(Type.TypeValue.TOY);
        service.add(toy);
    }
}
