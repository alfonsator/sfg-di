package com.f5mj.sfgdi.services;

// import org.springframework.context.annotation.Profile;
// import org.springframework.stereotype.Service;

// @Profile("EN") --→ Commented out to test Java-based configuration on package com.f5mj.sfgdi.config
// @Service("i18nService") --→ Commented out to test Java-based configuration on package com.f5mj.sfgdi.config
public class I18nEnglishGreetingService implements GreetingService {

   @Override
   public String sayGreeting() {
      return "Hello World - EN";
   }
}
