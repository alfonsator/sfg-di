package com.f5mj.sfgdi.services;

// import org.springframework.context.annotation.Primary;
// import org.springframework.stereotype.Service;

// @Primary --→ Commented out to test Java-based configuration on package com.f5mj.sfgdi.config
// @Service --→ Commented out to test Java-based configuration on package com.f5mj.sfgdi.config
public class PrimaryGreetingService implements GreetingService {

   @Override
   public String sayGreeting() {
      return "Hello World -- From the PRIMARY Bean";
   }
}
