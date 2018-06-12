package auction.domain;

import nl.fontys.util.FontysTime;
import nl.fontys.util.Money;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;
import java.util.Objects;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
@Entity
public class Bid
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JoinColumn(nullable = false)
    private Item item;

    private FontysTime time;
    @ManyToOne
    private User buyer;

    private Money amount;

    public Bid() {
    }

    public Bid(User buyer, Money amount, Item item) {
        this.item = item;
        this.buyer = buyer;
        this.amount = amount;
        time = FontysTime.now();
    }

    public Item getItem() {
        return item;
    }

    public FontysTime getTime() {
        return time;
    }

    public User getBuyer() {
        return buyer;
    }

    public Money getAmount() {
        return amount;
    }

    @Override
    public boolean equals(Object o)
    {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Bid bid = (Bid) o;

        if (!time.equals(bid.time)) return false;
        if (!buyer.equals(bid.buyer)) return false;
        return amount.equals(bid.amount);
    }

    @Override
    public int hashCode()
    {
        return Objects.hash(time, buyer, amount);
    }
}
