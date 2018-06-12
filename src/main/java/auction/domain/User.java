package auction.domain;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Objects;
import java.util.Set;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
@Entity
@Table(name = "AuctionUser")
@NamedQueries({
        @NamedQuery(name = "User.count", query = "SELECT COUNT(u) FROM User AS u"),
        @NamedQuery(name = "User.getAll", query = "SELECT u FROM User AS u"),
        @NamedQuery(name = "User.findByEmail", query = "SELECT u FROM User AS u WHERE u.email = :email")
})
public class User {

    @Id
    private String email;

    public User() {
    }

    public User(String email) {
        this.email = email;
    }

    public String getEmail() {
        return email;
    }


    @OneToMany(mappedBy = "seller")
    private Set<Item> offeredItems = new HashSet<Item>();

    public Iterator getOfferedItems() {
        return offeredItems.iterator();
    }

    void addItem(Item item) {
        offeredItems.add(item);
    }

    public int numberOfOfferedItem() {
        return offeredItems.size();
    }

    @Override
    public boolean equals(Object o)
    {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        User user = (User) o;

        if (!email.equals(user.email)) return false;
        return offeredItems.size() == user.offeredItems.size();
    }

    @Override
    public int hashCode()
    {
        return email.hashCode();
    }
}
