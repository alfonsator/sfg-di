package com.f5mj.sfgdi.services;

//import org.springframework.stereotype.Service;

//@Service --→ Commented out to test Java-based configuration on package com.f5mj.sfgdi.config
public class PropertyInjectedGreetingService implements GreetingService {

   @Override
   public String sayGreeting() {
      return "Hello World -- Property";
   }
}
