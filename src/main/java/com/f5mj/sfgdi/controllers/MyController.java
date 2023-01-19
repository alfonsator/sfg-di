package com.f5mj.sfgdi.controllers;

import org.springframework.stereotype.Controller;

import com.f5mj.sfgdi.services.GreetingService;

@Controller
public class MyController {

  private final GreetingService greetingService;

  public MyController(GreetingService greetingService) {
    this.greetingService = greetingService;
  }

  public String sayHello() {

    return greetingService.sayGreeting();
  }
}
