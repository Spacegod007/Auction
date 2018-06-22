import org.junit.Test;
import service.*;

import static org.junit.Assert.*;

public class ClientSellerMgrTest
{
    private static final AuctionService auctionService = new AuctionServiceService().getPort(AuctionService.class);
    private static final RegistrationService registrationService = new RegistrationServiceService().getPort(RegistrationService.class);


    @Test
    public void testOfferItem() {
        String omsch = "omsch";

        User user1 = registrationService.registerUser("xx@nl");
        Category cat = new Category();
        cat.setDescription("catTestOfferItem");
        Item item1 = auctionService.offerItem(user1, cat, omsch);
        assertEquals(omsch, item1.getDescription());
        assertNotNull(item1.getId());
    }

    /**
     * Test of revokeItem method, of class SellerMgr.
     */
    @Test
    public void testRevokeItem() {
        String omsch = "omschj";
        String omsch2 = "omsch2";


        User seller = registrationService.registerUser("sel@nl");
        User buyer = registrationService.registerUser("buy@nl");
        Category cat = new Category();
        cat.setDescription("catTestRevokeItem");

        // revoke before bidding
        Item item1 = auctionService.offerItem(seller, cat, omsch);
        boolean res = auctionService.revokeItem(item1);
        assertTrue(res);
        int count = auctionService.findItemByDescription(omsch).size();
        assertEquals(0, count);

        // revoke after bid has been made
        Item item2 = auctionService.offerItem(seller, cat, omsch2);
        Money money = new Money();
        money.setCurrency("eur");
        money.setCents(100);

        Bid bid = auctionService.newBid(item2, buyer, money);
        item2 = auctionService.getItem(item2.getId());
        boolean res2 = auctionService.revokeItem(item2);
        assertFalse(res2);
        int count2 = auctionService.findItemByDescription(omsch2).size();
        assertEquals(1, count2);

        assertEquals("Bid is not equal" ,item2.getHighest().getAmount().getCents(), bid.getAmount().getCents());

    }
}
