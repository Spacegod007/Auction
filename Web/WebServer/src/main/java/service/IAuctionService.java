package service;

import auction.domain.Category;
import auction.domain.User;
import auction.service.IAuctionMgr;
import auction.service.ISellerMgr;

public interface IAuctionService extends IAuctionMgr, ISellerMgr
{
    Category createCategory(String description);

}
