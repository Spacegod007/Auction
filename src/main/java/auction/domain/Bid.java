package auction.domain;

import nl.fontys.util.FontysTime;
import nl.fontys.util.Money;

public class Bid {

    private FontysTime time;
    private User buyer;
    private Money amount;

    public Bid(User buyer, Money amount) {
        //TODO
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
