package com.f5mj.sfgdi.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;

import com.f5mj.sfgdi.services.ConstructorGreetingService;
import com.f5mj.sfgdi.services.I18nEnglishGreetingService;
import com.f5mj.sfgdi.services.I18nSpanishGreetingService;
import com.f5mj.sfgdi.services.PrimaryGreetingService;
import com.f5mj.sfgdi.services.PropertyInjectedGreetingService;
import com.f5mj.sfgdi.services.SetterInjectedGreetingService;

@Configuration
public class GreetingServiceConfig {

   @Profile({ "ES", "default" })
   @Bean("i18nService")
   I18nSpanishGreetingService i18nSpanishGreetingService() {
      return new I18nSpanishGreetingService();
   }

   @Profile("EN")
   @Bean
   I18nEnglishGreetingService i18nService() {
      return new I18nEnglishGreetingService();
   }

   @Primary
   @Bean
   PrimaryGreetingService primaryGreetingService() {
      return new PrimaryGreetingService();
   }

   @Bean
   ConstructorGreetingService constructorGreetingService() {
      return new ConstructorGreetingService();
   }

   @Bean
   PropertyInjectedGreetingService propertyInjectedGreetingService() {
      return new PropertyInjectedGreetingService();
   }

   @Bean
   SetterInjectedGreetingService setterInjectedGreetingService() {
      return new SetterInjectedGreetingService();
   }

}
