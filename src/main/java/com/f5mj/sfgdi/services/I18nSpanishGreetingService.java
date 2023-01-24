package com.f5mj.sfgdi.services;

// import org.springframework.context.annotation.Profile;
// import org.springframework.stereotype.Service;

// @Profile({"ES", "default"}) -→ Si en lugar de usar un profile, se opta por uno por defecto
// @Profile("ES") --→ Commented out to test Java-based configuration on package com.f5mj.sfgdi.config
// @Service("i18nService") --→ Commented out to test Java-based configuration on package com.f5mj.sfgdi.config
public class I18nSpanishGreetingService implements GreetingService {

   @Override
   public String sayGreeting() {
      return "Hola Mundo - ES";
   }
}
