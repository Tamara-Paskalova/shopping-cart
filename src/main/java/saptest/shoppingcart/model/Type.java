package saptest.shoppingcart.model;

import java.util.Objects;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@ToString
@RequiredArgsConstructor
public class Type {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Enumerated(EnumType.STRING)
    private TypeValue typeValue;

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Type type = (Type) o;
        return Objects.equals(id, type.id) && typeValue == type.typeValue;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, typeValue);
    }

    public enum TypeValue {
        APPLIANCE,
        GIFT,
        GROCERY,
        KITCHENWARE,
        SPORT_EQUIPMENT,
        TOY
    }
}
