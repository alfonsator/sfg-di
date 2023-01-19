package com.f5mj.sfgdi.controllers;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.f5mj.sfgdi.services.ConstructorGreetingService;

public class SetterInjectedControllerTest {

   SetterInjectedController controller;

   @BeforeEach
   void setUp() {
      controller = new SetterInjectedController();
      controller.setGreetingService(new ConstructorGreetingService());
   }

   @Test
   void testGetGreeting() {
      System.out.println(controller.getGreeting());
   }
}
