
import org.junit.Test;
import service.*;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

public class ClientRegistrationMgrTest
{
    private static final RegistrationService registrationService = new RegistrationServiceService().getPort(RegistrationService.class);


    @Test
    public void registerUser()
    {
        User user1 = registrationService.registerUser("xxx1@yyy");
        assertTrue(user1.getEmail().equals("xxx1@yyy"));
        User user2 = registrationService.registerUser("xxx2@yyy2");
        assertTrue(user2.getEmail().equals("xxx2@yyy2"));
        User user2bis = registrationService.registerUser("xxx2@yyy2");
        assertEquals(user2bis.getEmail(), user2.getEmail());
        //geen @ in het adres
        assertNull(registrationService.registerUser("abc"));
    }

    @Test
    public void getUser()
    {
        User user1 = registrationService.registerUser("xxx5@yyy5");
        User userGet = registrationService.getUser("xxx5@yyy5");
        assertEquals(userGet.getEmail(), user1.getEmail());
        assertNull(registrationService.getUser("aaa4@bb5"));
        registrationService.registerUser("abc");
        assertNull(registrationService.getUser("abc"));
    }
}
