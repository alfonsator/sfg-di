package com.f5mj.sfgdi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.f5mj.sfgdi.controllers.ConstructorInjectedController;
import com.f5mj.sfgdi.controllers.I18nController;
import com.f5mj.sfgdi.controllers.MyController;
import com.f5mj.sfgdi.controllers.PropertyInjectedController;
import com.f5mj.sfgdi.controllers.SetterInjectedController;
import com.f5mj.sfgdi.datasource.FakeDataSource;
import com.f5mj.sfgdi.services.PrototypeBean;
import com.f5mj.sfgdi.services.SingletonBean;

// To override default component scan (in case we add packages outside main tree defined
// by main class), add this annotation:
// @ComponentScan(basePackages = {"com.f5mj.sfgdi", "<PACKAGE_NAME>", ...})
@SpringBootApplication
public class SfgDiApplication {

	public static void main(String[] args) {

		ApplicationContext ctx = SpringApplication.run(SfgDiApplication.class, args);

		I18nController i18nController = (I18nController) ctx.getBean("i18nController");
		System.out.println(i18nController.sayHello());

		MyController myController = (MyController) ctx.getBean("myController");

		System.out.println("----------- Primary Bean");
		System.out.println(myController.sayHello());

		System.out.println("----------- Property");
		PropertyInjectedController propertyInjectedController = (PropertyInjectedController) ctx
				.getBean("propertyInjectedController");
		System.out.println(propertyInjectedController.getGreeting());

		System.out.println("----------- Setter");
		SetterInjectedController setterInjectedController = (SetterInjectedController) ctx
				.getBean("setterInjectedController");
		System.out.println(setterInjectedController.getGreeting());

		System.out.println("----------- Constructor");
		ConstructorInjectedController constructorInjectedController = (ConstructorInjectedController) ctx
				.getBean("constructorInjectedController");
		System.out.println(constructorInjectedController.getGreeting());

		System.out.println("-------------- Bean Scopes -------------");
		SingletonBean singletonBean1 = ctx.getBean(SingletonBean.class);
		System.out.println(singletonBean1.getMyScope());
		SingletonBean singletonBean2 = ctx.getBean(SingletonBean.class);
		System.out.println(singletonBean2.getMyScope());

		PrototypeBean prototypeBean1 = ctx.getBean(PrototypeBean.class);
		System.out.println(prototypeBean1.getMyScope());
		PrototypeBean prototypeBean2 = ctx.getBean(PrototypeBean.class);
		System.out.println(prototypeBean2.getMyScope());

		FakeDataSource fakeDataSource = ctx.getBean(FakeDataSource.class);
		System.out.println(fakeDataSource.getUsername());
		System.out.println(fakeDataSource.getPassword());
		System.out.println(fakeDataSource.getJdbcurl());

	}

}
