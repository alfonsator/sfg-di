package com.f5mj.sfgdi.controllers;

import org.springframework.stereotype.Controller;

import com.f5mj.sfgdi.services.GreetingService;

@Controller
public class ConstructorInjectedController {

   private final GreetingService greetingService;

   public ConstructorInjectedController(GreetingService greetingService) {
      this.greetingService = greetingService;
   }

   public String getGreeting() {
      return greetingService.sayGreeting();
   }
}
