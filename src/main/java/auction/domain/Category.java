package auction.domain;

import javax.persistence.Embeddable;

@Embeddable
public class Category {

    private String description;

    public Category() {
        description = "undefined";
    }

    public Category(String description) {
        this.description = description;
    }

    public String getDescription()
    {
        return description;
    }

    public void setDescription(String description)
    {
        this.description = description;
    }

    @Override
    public boolean equals(Object o)
    {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Category category = (Category) o;

        return description.equals(category.description);
    }

    @Override
    public int hashCode()
    {
        return description.hashCode();
    }
}
