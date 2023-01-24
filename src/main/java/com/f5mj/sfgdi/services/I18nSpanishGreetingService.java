package com.f5mj.sfgdi.services;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

// @Profile({"ES", "default"}) -→ Si en lugar de usar un profile, se opta por uno por defecto
@Profile("ES")
@Service("i18nService")
public class I18nSpanishGreetingService implements GreetingService {

   @Override
   public String sayGreeting() {
      return "Hola Mundo - ES";
   }
}
