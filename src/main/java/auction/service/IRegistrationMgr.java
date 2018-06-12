package auction.service;

import auction.domain.User;

public interface IRegistrationMgr
{
    User registerUser(String email);
    User getUser(String email);
}
