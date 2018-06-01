package auction.service;

import static org.junit.Assert.*;

import nl.fontys.util.Money;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import auction.domain.Bid;
import auction.domain.Category;
import auction.domain.Item;
import auction.domain.User;
import util.DatabaseCleaner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.ArrayList;
import java.util.List;

public class AuctionMgrTest {

    private static final EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory(DatabaseCleaner.PERSISTENCE_NAME_AUCTION);

    private AuctionMgr auctionMgr;
    private RegistrationMgr registrationMgr;
    private SellerMgr sellerMgr;

    @Before
    public void setUp() throws Exception {
        registrationMgr = new RegistrationMgr();
        auctionMgr = new AuctionMgr();
        sellerMgr = new SellerMgr();
    }

    @After
    public void after() throws Exception {
        new DatabaseCleaner(entityManagerFactory.createEntityManager()).clean();
    }

//    @After
//    public void tearDown()
//    {
//        final EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("auction");
//        EntityManager entityManager = entityManagerFactory.createEntityManager();
//        entityManager.getTransaction().begin();
//        entityManager.createQuery("DELETE FROM User").executeUpdate();
//        entityManager.createQuery("DELETE FROM Item").executeUpdate();
//        entityManager.getTransaction().commit();
//        entityManager.close();
//    }

    @Test
    public void getItem() {

        String email = "xx2@nl";
        String omsch = "omsch";

        User seller1 = registrationMgr.registerUser(email);
        Category cat = new Category("cat2");
        Item item1 = sellerMgr.offerItem(seller1, cat, omsch);
        Item item2 = auctionMgr.getItem(item1.getId());
        assertEquals(omsch, item2.getDescription());
        assertEquals(email, item2.getSeller().getEmail());
    }

    @Test
    public void findItemByDescription() {
        String email3 = "xx3@nl";
        String omsch = "omsch";
        String email4 = "xx4@nl";
        String omsch2 = "omsch2";

        User seller3 = registrationMgr.registerUser(email3);
        User seller4 = registrationMgr.registerUser(email4);
        Category cat = new Category("cat3");
        Item item1 = sellerMgr.offerItem(seller3, cat, omsch);
        Item item2 = sellerMgr.offerItem(seller4, cat, omsch);

        List<Item> res = auctionMgr.findItemByDescription(omsch2);
        assertEquals(0, res.size());

        res = auctionMgr.findItemByDescription(omsch);
        assertEquals(2, res.size());

    }

    @Test
    public void newBid() {

        String email = "ss2@nl";
        String emailb = "bb@nl";
        String emailb2 = "bb2@nl";
        String omsch = "omsch_bb";

        User seller = registrationMgr.registerUser(email);
        User buyer = registrationMgr.registerUser(emailb);
        User buyer2 = registrationMgr.registerUser(emailb2);
        // eerste bod
        Category cat = new Category("cat9");
        Item item1 = sellerMgr.offerItem(seller, cat, omsch);
        Bid new1 = auctionMgr.newBid(item1, buyer, new Money(10, "eur"));
        assertEquals(emailb, new1.getBuyer().getEmail());

        // lager bod
        Bid new2 = auctionMgr.newBid(item1, buyer2, new Money(9, "eur"));
        assertNull(new2);

        // hoger bod
        Bid new3 = auctionMgr.newBid(item1, buyer2, new Money(11, "eur"));
        assertEquals(emailb2, new3.getBuyer().getEmail());
    }
}
