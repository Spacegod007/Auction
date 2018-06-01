package auction.service;

import auction.dao.ItemDAO;
import auction.dao.ItemDAOJPAImpl;
import auction.dao.UserDAO;
import auction.dao.UserDAOJPAImpl;
import auction.domain.Category;
import auction.domain.Item;
import auction.domain.User;

public class SellerMgr {

    private final ItemDAO itemDAO;
    private final UserDAO userDAO;

    public SellerMgr()
    {
        itemDAO = new ItemDAOJPAImpl();
        userDAO = new UserDAOJPAImpl();
    }

    /**
     * @param seller
     * @param cat
     * @param description
     * @return het item aangeboden door seller, behorende tot de categorie cat
     *         en met de beschrijving description
     */
    public Item offerItem(User seller, Category cat, String description) {
        Item item = new Item(seller, cat, description);
        itemDAO.create(item);
        seller.addItem(item);
        userDAO.edit(seller);
        return item;
    }
    
     /**
     * @param item
     * @return true als er nog niet geboden is op het item. Het item word verwijderd.
     *         false als er al geboden was op het item.
     */
    public boolean revokeItem(Item item) {
        if (item.getHighestBid() == null)
        {
            itemDAO.remove(item);
            return true;
        }
        return false;
    }
}
