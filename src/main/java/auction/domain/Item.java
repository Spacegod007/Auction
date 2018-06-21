package auction.domain;

import nl.fontys.util.Money;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.Objects;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
@NamedQueries({
        @NamedQuery(name = "Item.count", query = "SELECT COUNT(i) FROM Item AS i"),
        @NamedQuery(name = "Item.find", query = "SELECT i FROM Item AS i WHERE i.id = :id"),
        @NamedQuery(name = "Item.findAll", query = "SELECT i FROM Item as i"),
        @NamedQuery(name = "Item.findByDescription", query = "SELECT i FROM Item as i WHERE i.description = :description")
})
@Entity
public class Item implements Comparable<Item> {
//https://en.wikibooks.org/wiki/Java_Persistence/Embeddables

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(cascade = CascadeType.DETACH)
    private User seller;

    @Embedded
    @AttributeOverrides(@AttributeOverride(name="description", column = @Column(name = "columnDescription")))
    private Category category;

    @OneToOne(cascade = {CascadeType.PERSIST, CascadeType.REFRESH, CascadeType.REMOVE, CascadeType.MERGE})
    private Bid highest;

    private String description;

    public Item() {}

    public Item(User seller, Category category, String description) {
        this.seller = seller;
        this.category = category;
        this.description = description;
    }

    public Long getId() {
        return id;
    }

    public User getSeller() {
        return seller;
    }

    public Category getCategory() {
        return category;
    }

    public String getDescription() {
        return description;
    }

    public Bid getHighestBid() {
        return highest;
    }

    public Bid newBid(User buyer, Money amount) {
        if (highest != null && highest.getAmount().compareTo(amount) >= 0) {
            return null;
        }
        highest = new Bid(buyer, amount);
        return highest;
    }

    @Override
    public boolean equals(Object o)
    {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Item item = (Item) o;

        return id.equals(item.id) && seller.equals(item.seller) && category.equals(item.category) && (highest != null ? highest.equals(item.highest) : item.highest == null) && description.equals(item.description);
    }

    @Override
    public int hashCode()
    {
        return Objects.hash(seller, category, highest, description);
//        int result = id.hashCode();
//        result = 31 * result + seller.hashCode();
//        result = 31 * result + category.hashCode();
//        result = 31 * result + (highest != null ? highest.hashCode() : 0);
//        result = 31 * result + description.hashCode();
//        return result;
    }

    @Override
    public int compareTo(Item o)
    {
        return this.description.compareTo(o.description);
    }
}
