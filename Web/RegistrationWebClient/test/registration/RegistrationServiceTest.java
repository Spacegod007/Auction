package registration;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import service.RegistrationService;
import service.RegistrationServiceService;
import service.User;

import static org.junit.jupiter.api.Assertions.*;

public class RegistrationServiceTest
{
    private static final String MAIL_ADDRESS_1 = "user@mail.address";
    private static final String MAIL_ADDRESS_2 = "user2@mail.address";

    private static RegistrationService service;

    @BeforeAll
    public static void beforeAll()
    {
        service = new RegistrationServiceService().getPort(RegistrationService.class);
    }

    @Test
    public void registrationTest()
    {
        User user = service.registerUser(MAIL_ADDRESS_1);
        assertEquals(MAIL_ADDRESS_1, user.getEmail(), "returned mail address is not equal to the send mail address");
    }

    @Test
    public void getUserTest()
    {
        service.registerUser(MAIL_ADDRESS_2);
        User user = service.getUser(MAIL_ADDRESS_2);
        assertEquals(MAIL_ADDRESS_2, user.getEmail(), "returned mail address is not equal to the send mail address");
    }


}
