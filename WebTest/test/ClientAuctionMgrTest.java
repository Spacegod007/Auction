
import org.junit.Assert;
import org.junit.Test;
import service.*;

import java.util.ArrayList;

public class ClientAuctionMgrTest
{
    private static final AuctionService auctionService = new AuctionServiceService().getPort(AuctionService.class);
    private static final RegistrationService registrationService = new RegistrationServiceService().getPort(RegistrationService.class);

    @Test
    public void getItem()
    {
        String email = "xx2@nl";
        String omsch = "omsch";

        User seller1 = registrationService.registerUser(email);
        Category cat = new Category();
        cat.setDescription("catGetItem");
        Item item1 = auctionService.offerItem(seller1, cat, omsch);
        Item item2 = auctionService.getItem(item1.getId());
        Assert.assertEquals(omsch, item2.getDescription());
        Assert.assertEquals(email, item2.getSeller().getEmail());
    }

    @Test
    public void findItemByDescription()
    {
        String email3 = "xx3@nl";
        String omsch = "omsch";
        String email4 = "xx4@nl";
        String omsch2 = "omsch2";

        User seller3 = registrationService.registerUser(email3);
        User seller4 = registrationService.registerUser(email4);
        Category cat = new Category();
        cat.setDescription("catFindItemByDescription");
        Item item1 = auctionService.offerItem(seller3, cat, omsch);
        Item item2 = auctionService.offerItem(seller4, cat, omsch);

        ArrayList<Item> res = (ArrayList<Item>) auctionService.findItemByDescription(omsch2);
        Assert.assertEquals(0, res.size());

        res = (ArrayList<Item>) auctionService.findItemByDescription(omsch);
        Assert.assertEquals(2, res.size());

    }

    @Test
    public void newBid()
    {

        String email = "ss2@nl";
        String emailb = "bb@nl";
        String emailb2 = "bb2@nl";
        String omsch = "omsch_bb";

        Money money1 = new Money();
        money1.setCents(10);
        money1.setCurrency("eur");

        User seller = registrationService.registerUser(email);
        User buyer = registrationService.registerUser(emailb);
        User buyer2 = registrationService.registerUser(emailb2);
        // eerste bod
        Category cat = new Category();
        cat.setDescription("testNewBid");
        Item item1 = auctionService.offerItem(seller, cat, omsch);
        Bid new1 = auctionService.newBid(item1, buyer, money1);
        Assert.assertEquals(emailb, new1.getBuyer().getEmail());

        // lager bod
        Money money2 = new Money();
        money2.setCents(9);
        money2.setCurrency("eur");

        Bid new2 = auctionService.newBid(item1, buyer2, money2);
        Assert.assertNotNull(new2);

        // hoger bod
        Money money3 = new Money();
        money3.setCents(11);
        money3.setCurrency("eur");

        Bid new3 = auctionService.newBid(item1, buyer2, money3);
        Assert.assertEquals(emailb2, new3.getBuyer().getEmail());
    }

}
