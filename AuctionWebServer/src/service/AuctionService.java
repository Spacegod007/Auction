package service;

import auction.domain.Bid;
import auction.domain.Category;
import auction.domain.Item;
import auction.domain.User;
import auction.service.*;
import nl.fontys.util.Money;

import javax.jws.WebMethod;
import javax.jws.WebService;
import java.util.List;

@WebService
public class AuctionService implements IAuctionService
{
    private final IAuctionMgr auctionMgr;
    private final ISellerMgr sellerMgr;

    public AuctionService()
    {
        auctionMgr = new AuctionMgr();
        sellerMgr = new SellerMgr();
    }

    @WebMethod
    @Override
    public Item getItem(Long id)
    {
        return auctionMgr.getItem(id);
    }

    @WebMethod
    @Override
    public List<Item> findItemByDescription(String description)
    {
        return auctionMgr.findItemByDescription(description);
    }

    @WebMethod
    @Override
    public Bid newBid(Item item, User buyer, Money amount)
    {
        return auctionMgr.newBid(item, buyer, amount);
    }

    @WebMethod
    @Override
    public Item offerItem(User seller, Category cat, String description)
    {
        return sellerMgr.offerItem(seller, cat, description);
    }

    @WebMethod
    @Override
    public boolean revokeItem(Item item)
    {
        return sellerMgr.revokeItem(item);
    }

    @WebMethod
    @Override
    public Item offerFurniture(User user, Category category, String description, String material)
    {
        return sellerMgr.offerFurniture(user, category, description, material);
    }

    @WebMethod
    @Override
    public Item offerPainting(User user, Category category, String description, String title, String painter)
    {
        return sellerMgr.offerPainting(user, category, description, title, painter);
    }
}
