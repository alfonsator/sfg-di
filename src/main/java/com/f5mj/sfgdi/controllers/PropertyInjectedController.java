package com.f5mj.sfgdi.controllers;

import com.f5mj.sfgdi.services.GreetingService;

public class PropertyInjectedController {

   public GreetingService greetingService;

   public String getGreeting() {

      return greetingService.sayGreeting();
   }

}
