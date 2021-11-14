package com.prussf;

import com.prussf.coaches.Coach;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class AnnotationDemoApp {

	public static void main(String[] args) {

		// read spring config file
		AnnotationConfigApplicationContext context =
				new AnnotationConfigApplicationContext(ApplicationContext.class);

		// get the bean from spring container
		Coach theCoach = context.getBean("tennisCoach", Coach.class);
		
		// call a method on the bean
		System.out.println(theCoach.getDailyWorkout());

		// call method to get daily fortune
		System.out.println(theCoach.getDailyFortune());
				
		// close the context
		context.close();	
	}

}


