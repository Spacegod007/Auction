package auction.service;

import auction.domain.Category;
import auction.domain.Item;
import auction.domain.User;

public interface ISellerMgr
{
    /**
     * @param seller
     * @param cat
     * @param description
     * @return het item aangeboden door seller, behorende tot de categorie cat
     *         en met de beschrijving description
     */
    Item offerItem(User seller, Category cat, String description);

    /**
     * @param item
     * @return true als er nog niet geboden is op het item. Het item word verwijderd.
     *         false als er al geboden was op het item.
     */
    boolean revokeItem(Item item);

    Item offerFurniture(User user, Category category, String description, String material);
    Item offerPainting(User user, Category category, String description, String title, String painter);
}
