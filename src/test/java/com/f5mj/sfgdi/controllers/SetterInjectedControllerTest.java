package com.f5mj.sfgdi.controllers;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.f5mj.sfgdi.services.GreetingServiceImpl;

public class SetterInjectedControllerTest {

   SetterInjectedController controller;

   @BeforeEach
   void setUp() {
      controller = new SetterInjectedController();
      controller.setGreetingService(new GreetingServiceImpl());
   }

   @Test
   void testGetGreeting() {
      System.out.println(controller.getGreeting());
   }
}
