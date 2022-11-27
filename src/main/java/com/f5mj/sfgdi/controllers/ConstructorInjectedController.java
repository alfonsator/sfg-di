package com.f5mj.sfgdi.controllers;

import com.f5mj.sfgdi.services.GreetingService;

public class ConstructorInjectedController {

   private final GreetingService greetingService;

   public ConstructorInjectedController(GreetingService greetingService) {
      this.greetingService = greetingService;
   }

   public String getGreeting() {
      return greetingService.sayGreeting();
   }
}
