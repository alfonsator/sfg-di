package com.f5mj.sfgdi.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.f5mj.sfgdi.services.ConstructorGreetingService;
import com.f5mj.sfgdi.services.PropertyInjectedGreetingService;
import com.f5mj.sfgdi.services.SetterInjectedGreetingService;

@Configuration
public class GreetingServiceConfig {

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
