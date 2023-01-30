package com.f5mj.sfgdi.config;

import org.springframework.boot.context.properties.EnableConfigurationProperties;
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
@EnableConfigurationProperties(SfgConstructorConfig.class)
@Configuration
public class GreetingServiceConfig {

   @Bean
   FakeDataSource fakeDataSource(SfgConstructorConfig sfgConstructorConfig) {

      FakeDataSource fakeDataSource = new FakeDataSource();

      fakeDataSource.setUsername(sfgConstructorConfig.getUsername());
      fakeDataSource.setPassword(sfgConstructorConfig.getPassword());
      fakeDataSource.setJdbcurl(sfgConstructorConfig.getJdbcurl());

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
