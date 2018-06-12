package auction.service;

import auction.dao.ItemDAO;
import auction.dao.ItemDAOJPAImpl;
import auction.dao.UserDAO;
import auction.dao.UserDAOJPAImpl;
import auction.domain.*;

public class SellerMgr implements ISellerMgr {

    private final ItemDAO itemDAO;
    private final UserDAO userDAO;

    public SellerMgr()
    {
        itemDAO = new ItemDAOJPAImpl();
        userDAO = new UserDAOJPAImpl();
    }

    @Override
    public Item offerItem(User seller, Category cat, String description) {
        return offerItem(new Item(seller, cat, description));
    }

    private Item offerItem(Item item)
    {
        itemDAO.create(item);
        userDAO.edit(item.getSeller());
        return item;
    }
    
    @Override
    public boolean revokeItem(Item item) {
        if (item.getHighestBid() == null)
        {
            itemDAO.remove(item);
            return true;
        }
        return false;
    }

    @Override
    public Item offerFurniture(User user, Category category, String description, String material)
    {
        return offerItem(new Furniture(user, category, description, material));
    }

    @Override
    public Item offerPainting(User user, Category category, String description, String title, String painter)
    {
        return offerItem(new Painting(user, category, description, title, painter));
    }
}
