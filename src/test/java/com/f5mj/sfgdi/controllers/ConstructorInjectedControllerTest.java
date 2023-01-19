package com.f5mj.sfgdi.controllers;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.f5mj.sfgdi.services.ConstructorGreetingService;

public class ConstructorInjectedControllerTest {

   ConstructorInjectedController controller;

   @BeforeEach
   void setUp() {
      controller = new ConstructorInjectedController(new ConstructorGreetingService());
   }

   @Test
   void testGetGreeting() {

      System.out.println(controller.getGreeting());
   }
}
