package auction.service;

import auction.domain.User;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class JPARegistrationMgrTest
{
    private RegistrationMgr registrationMgr;

    @Before
    public void setUp() throws Exception {
        registrationMgr = new RegistrationMgr();
    }

    @Test
    public void registerUser() {
        User user1 = registrationMgr.registerUser("xxx1@yyy");
        assertTrue(user1.getEmail().equals("xxx1@yyy"));
        User user2 = registrationMgr.registerUser("xxx2@yyy2");
        assertTrue(user2.getEmail().equals("xxx2@yyy2"));
        User user2bis = registrationMgr.registerUser("xxx2@yyy2");
        assertEquals(user2bis, user2);
        //geen @ in het adres
        assertNull(registrationMgr.registerUser("abc"));
    }

    @Test
    public void getUser() {
        User user1 = registrationMgr.registerUser("xxx5@yyy5");
        User userGet = registrationMgr.getUser("xxx5@yyy5");
        assertEquals(userGet, user1);
        assertNull(registrationMgr.getUser("aaa4@bb5"));
        registrationMgr.registerUser("abc");
        assertNull(registrationMgr.getUser("abc"));
    }

    @Test
    public void getUsers() {
        List<User> users = registrationMgr.getUsers();
        assertEquals(3, users.size());

        User user1 = registrationMgr.registerUser("xxx8@yyy");
        users = registrationMgr.getUsers();
        assertEquals(1, users.size());
        assertEquals(users.get(0), user1);


        User user2 = registrationMgr.registerUser("xxx9@yyy");
        users = registrationMgr.getUsers();
        assertEquals(2, users.size());

        registrationMgr.registerUser("abc");
        //geen nieuwe user toegevoegd, dus gedrag hetzelfde als hiervoor
        users = registrationMgr.getUsers();
        assertEquals(2, users.size());
    }
}
