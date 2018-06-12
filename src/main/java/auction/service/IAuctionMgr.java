package auction.service;

import auction.domain.Bid;
import auction.domain.Item;
import auction.domain.User;
import nl.fontys.util.Money;

import java.util.List;

public interface IAuctionMgr
{
    /**
     * @param id
     * @return het item met deze id; als dit item niet bekend is wordt er null
     *         geretourneerd
     */
    Item getItem(Long id);

    /**
     * @param description
     * @return een lijst met items met @desciption. Eventueel lege lijst.
     */
    List<Item> findItemByDescription(String description);

    /**
     * @param item
     * @param buyer
     * @param amount
     * @return het nieuwe bod ter hoogte van amount op item door buyer, tenzij
     *         amount niet hoger was dan het laatste bod, dan null
     */
    Bid newBid(Item item, User buyer, Money amount);
}
