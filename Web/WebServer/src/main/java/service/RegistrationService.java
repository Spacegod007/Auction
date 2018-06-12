package service;

import auction.domain.User;
import auction.service.RegistrationMgr;

import javax.jws.WebMethod;
import javax.jws.WebService;

@WebService
public class RegistrationService implements IRegistrationService
{
    private final RegistrationMgr registrationMgr;

    public RegistrationService()
    {
        registrationMgr = new RegistrationMgr();
    }
    
    @WebMethod
    @Override
    public User registerUser(String email)
    {
        return registrationMgr.registerUser(email);
    }

    @WebMethod
    @Override
    public User getUser(String email)
    {
        return registrationMgr.getUser(email);
    }
}
