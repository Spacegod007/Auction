package service;

import javax.xml.ws.Endpoint;

public class WebServer
{
    public static void main(String[] args)
    {
        //addresses linked to the webservice
        String mainAddress = "http://localhost:9000/";
        String auctionServiceAddress = mainAddress + "AuctionService";
        String registrationServiceAddress = mainAddress + "RegistrationService";

        //instantiate services so they will be prepared before being published
        AuctionService auctionService = new AuctionService();
        RegistrationService registrationService = new RegistrationService();

        //publishes the services
        Endpoint.publish(auctionServiceAddress, auctionService);
        Endpoint.publish(registrationServiceAddress, registrationService);
    }
}
