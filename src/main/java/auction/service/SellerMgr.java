package auction.service;

import auction.dao.ItemDAO;
import auction.dao.ItemDAOJPAImpl;
import auction.dao.UserDAO;
import auction.dao.UserDAOJPAImpl;
import auction.domain.*;

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
        return offerItem(new Item(seller, cat, description));
    }

    private Item offerItem(Item item)
    {
        itemDAO.create(item);
        userDAO.edit(item.getSeller());
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

    public Item offerFurniture(User user, Category category, String description, String material)
    {
        return offerItem(new Furniture(user, category, description, material));
    }


    public Item offerPainting(User user, Category category, String description, String title, String painter)
    {
        return offerItem(new Painting(user, category, description, title, painter));
    }
}
