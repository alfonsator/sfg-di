package com.f5mj.sfgdi.controllers;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.f5mj.sfgdi.services.ConstructorGreetingService;

public class PropertyInjectedControllerTest {

   PropertyInjectedController controller;

   @BeforeEach
   void setUp() {
      controller = new PropertyInjectedController();

      controller.greetingService = new ConstructorGreetingService();
   }

   @Test
   void testGetGreeting() {

      System.out.println(controller.getGreeting());
   }
}
