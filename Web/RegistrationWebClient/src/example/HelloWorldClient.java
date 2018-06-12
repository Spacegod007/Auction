package example;

import service.RegistrationService;

public class HelloWorldClient {
  public static void main(String[] argv) {
    service.RegistrationService service = new service.RegistrationServiceService().getPort(RegistrationService.class);
//    invoke business method
//    service.getItem();
  }
}
