package example;

import service.RegistrationService;
import service.RegistrationServiceService;

public class HelloWorldClient {
  public static void main(String[] argv) {
      RegistrationService service = new RegistrationServiceService().getPort(RegistrationService.class);
//      invoke business method
//      service.getItem();
  }
}
