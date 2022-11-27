package com.f5mj.sfgdi.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.f5mj.sfgdi.services.GreetingService;

@Controller
public class PropertyInjectedController {

   @Autowired
   public GreetingService greetingService;

   public String getGreeting() {

      return greetingService.sayGreeting();
   }

}
