package example;

import service.AuctionService;
import service.AuctionServiceService;

public class HelloWorldClient {
  public static void main(String[] argv) {
    AuctionService service = new AuctionServiceService().getPort(AuctionService.class);
//    invoke business method
//    service.getItem();
  }
}
