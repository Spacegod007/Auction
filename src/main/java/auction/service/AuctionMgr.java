package auction.service;

import auction.dao.DAO;
import auction.dao.ItemDAO;
import auction.dao.ItemDAOJPAImpl;
import nl.fontys.util.Money;
import auction.domain.Bid;
import auction.domain.Item;
import auction.domain.User;
import java.util.ArrayList;
import java.util.List;

public class AuctionMgr implements IAuctionMgr {

    private final ItemDAO itemDAO;

    public AuctionMgr()
    {
        itemDAO = new ItemDAOJPAImpl();
    }

    @Override
    public Item getItem(Long id) {
        return itemDAO.find(id);
    }

    @Override
    public List<Item> findItemByDescription(String description) {
        return itemDAO.findByDescription(description);
    }

    @Override
    public Bid newBid(Item item, User buyer, Money amount) {
//        item = getItem(item.getId());
        ((DAO<Item>) itemDAO).refresh(item);
        Bid bid = item.newBid(buyer, amount);
        itemDAO.edit(item);
        return bid;
    }
}
