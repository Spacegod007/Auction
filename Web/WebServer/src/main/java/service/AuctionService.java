package service;

import auction.domain.Bid;
import auction.domain.Category;
import auction.domain.Item;
import auction.domain.User;
import auction.service.AuctionMgr;
import auction.service.IAuctionMgr;
import auction.service.ISellerMgr;
import auction.service.SellerMgr;
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
    public Item getItem(Long id)
    {
        return auctionMgr.getItem(id);
    }

    @WebMethod
    public List<Item> findItemByDescription(String description)
    {
        return auctionMgr.findItemByDescription(description);
    }

    @WebMethod
    public Bid newBid(Item item, User buyer, Money amount)
    {
        return auctionMgr.newBid(item, buyer, amount);
    }

    @WebMethod
    public Item offerItem(User seller, Category cat, String description)
    {
        return sellerMgr.offerItem(seller, cat, description);
    }

    @WebMethod
    public boolean revokeItem(Item item)
    {
        return sellerMgr.revokeItem(item);
    }

    @WebMethod
    public Item offerFurniture(User user, Category category, String description, String material)
    {
        return sellerMgr.offerFurniture(user, category, description, material);
    }

    @WebMethod
    public Item offerPainting(User user, Category category, String description, String title, String painter)
    {
        return sellerMgr.offerPainting(user, category, description, title, painter);
    }
}
