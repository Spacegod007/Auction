//package auction.service;
//
//import auction.domain.Bid;
//import nl.fontys.util.Money;
//import org.junit.After;
//
//import javax.persistence.*;
//
//import org.junit.Assert;
//import util.DatabaseCleaner;
//import auction.domain.Category;
//import auction.domain.Item;
//import auction.domain.User;
//import java.util.Iterator;
//import org.junit.Before;
//import org.junit.Test;
//import static org.junit.Assert.*;
//
//public class ItemsFromSellerTest {
//
//    final EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("auction");
//    private AuctionMgr auctionMgr;
//    private RegistrationMgr registrationMgr;
//    private SellerMgr sellerMgr;
//
//    @Before
//    public void setUp() throws Exception {
//        registrationMgr = new RegistrationMgr();
//        auctionMgr = new AuctionMgr();
//        sellerMgr = new SellerMgr();
//    }
//
//    @After
//    public void after() throws Exception {
//        new DatabaseCleaner(entityManagerFactory.createEntityManager()).clean();
//    }
//
//    @Test
// //   @Ignore
//    public void numberOfOfferdItems() {
//
//        String email = "ifu1@nl";
//        String omsch1 = "omsch_ifu1";
//        String omsch2 = "omsch_ifu2";
//
//        User user1 = registrationMgr.registerUser(email);
//        assertEquals(0, user1.numberOfOfferedItem());
//
//        Category cat = new Category("cat2");
//        Item item1 = sellerMgr.offerItem(user1, cat, omsch1);
//
//
//        // test number of items belonging to user1
////        assertEquals(0, user1.numberOfOfferedItem());
//        assertEquals(1, user1.numberOfOfferedItem());
//
//        /*
//         *  expected: which one of te above two assertions do you expect to be true? the second because 1 item is offered
//         *  QUESTION:
//         *    Explain the result in terms of entity manager and persistance context.
//         */
//
//
//        assertEquals(1, item1.getSeller().numberOfOfferedItem());
//
//
//        User user2 = registrationMgr.getUser(email);
//        assertEquals(1, user2.numberOfOfferedItem());
//        Item item2 = sellerMgr.offerItem(user2, cat, omsch2);
//        assertEquals(2, user2.numberOfOfferedItem());
//
//        User user3 = registrationMgr.getUser(email);
//        assertEquals(2, user3.numberOfOfferedItem());
//
//        User userWithItem = item2.getSeller();
//        assertEquals(2, userWithItem.numberOfOfferedItem());
////        assertEquals(3, userWithItem.numberOfOfferedItem());
//        /*
//         *  expected: which one of te above two assertions do you expect to be true?
//         *  QUESTION:
//         *    Explain the result in terms of entity manager and persistance context.
//         */
//
//
//        assertNotSame(user3, userWithItem);
//        assertEquals(user3, userWithItem);
//
//    }
//
//    @Test
////    @Ignore
//    public void getItemsFromSeller() {
//        String email = "ifu1@nl";
//        String omsch1 = "omsch_ifu1";
//        String omsch2 = "omsch_ifu2";
//
//        Category cat = new Category("cat2");
//
//        User user10 = registrationMgr.registerUser(email);
//        Item item10 = sellerMgr.offerItem(user10, cat, omsch1); //fixme fontys
//        Iterator<Item> it = user10.getOfferedItems();
//        // testing number of items of java object
//        assertTrue(it.hasNext());
//
//        // now testing number of items for same user fetched from db.
//        User user11 = registrationMgr.getUser(email);
//        Iterator<Item> it11 = user11.getOfferedItems();
//        assertTrue(it11.hasNext());
//        it11.next();
//        assertFalse(it11.hasNext());
//
//        // Explain difference in above two tests for te iterator of 'same' user
//
//
//
//        User user20 = registrationMgr.getUser(email);
//        Item item20 = sellerMgr.offerItem(user20, cat, omsch2);
//        Iterator<Item> it20 = user20.getOfferedItems();
//        assertTrue(it20.hasNext());
//        it20.next();
//        assertTrue(it20.hasNext());
//
//
//        User user30 = item20.getSeller();
//        Iterator<Item> it30 = user30.getOfferedItems();
//        assertTrue(it30.hasNext());
//        it30.next();
//        assertTrue(it30.hasNext());
//
//    }
//
//    @Test
//    public void itemBid()
//    {
//        String email = "email1@nl";
//        String email2 = "email2@nl";
//        String description = "description";
//        Category category = new Category("Category");
//        Money money = new Money(10, Money.EURO);
//
//        User user1 = registrationMgr.registerUser(email);
//        User user2 = registrationMgr.registerUser(email2);
//        Item item = sellerMgr.offerItem(user1, category, description);
//        Bid bid = auctionMgr.newBid(item, user2, money);
//
//        Assert.assertEquals("Bid was placed on a different item than the given item", item, bid.getItem());
//        Assert.assertEquals("Bid was placed on an item but a different bid was associated with the item", bid, item.getHighestBid());
//    }
//}
