package auction.domain;

import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class Furniture extends Item{

    private String material;

    public Furniture(User seller, Category category, String description, String material) {
        super(seller, category, description);
        this.material = material;
    }

    public Furniture() {
    }

    public String getMaterial() {
        return material;
    }
}
