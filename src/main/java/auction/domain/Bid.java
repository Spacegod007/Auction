package auction.domain;

import nl.fontys.util.FontysTime;
import nl.fontys.util.Money;

import javax.persistence.*;
import java.io.Serializable;

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
}
