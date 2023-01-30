package com.f5mj.sfgdi.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;

import com.f5mj.sfgdi.datasource.FakeDataSource;
import com.f5mj.sfgdi.repositories.EnglishGreetingRepository;
import com.f5mj.sfgdi.repositories.EnglishGreetingRepositoryImpl;
import com.f5mj.sfgdi.services.ConstructorGreetingService;
import com.f5mj.sfgdi.services.I18nEnglishGreetingService;
import com.f5mj.sfgdi.services.I18nSpanishGreetingService;
import com.f5mj.sfgdi.services.PrimaryGreetingService;
import com.f5mj.sfgdi.services.PropertyInjectedGreetingService;
import com.f5mj.sfgdi.services.SetterInjectedGreetingService;

//@PropertySource("classpath:datasource.properties")
// @ImportResource("classpath:<CONFIG_FILE>.xml") --> Si usáramos configuración
// basada en XML
@Configuration
public class GreetingServiceConfig {

   @Bean
   FakeDataSource fakeDataSource(@Value("${f5mj.username}") String username, @Value("${f5mj.password}") String password,
         @Value("${f5mj.jdbcurl}") String jdbcurl) {

      FakeDataSource fakeDataSource = new FakeDataSource();

      fakeDataSource.setUsername(username);
      fakeDataSource.setPassword(password);
      fakeDataSource.setJdbcurl(jdbcurl);

      return fakeDataSource;
   }

   @Profile({ "ES", "default" })
   @Bean("i18nService")
   I18nSpanishGreetingService i18nSpanishGreetingService() {
      return new I18nSpanishGreetingService();
   }

   @Bean
   EnglishGreetingRepository englishGreetingRepository() {
      return new EnglishGreetingRepositoryImpl();
   }

   @Profile("EN")
   @Bean
   I18nEnglishGreetingService i18nService(EnglishGreetingRepository englishGreetingRepository) {
      return new I18nEnglishGreetingService(englishGreetingRepository);
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
