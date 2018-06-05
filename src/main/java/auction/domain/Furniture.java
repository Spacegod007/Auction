package auction.domain;

import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import java.util.Objects;

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

    @Override
    public boolean equals(Object o)
    {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        Furniture furniture = (Furniture) o;

        return material.equals(furniture.material);
    }

    @Override
    public int hashCode()
    {
        return Objects.hash(super.hashCode(), material);
    }
}
