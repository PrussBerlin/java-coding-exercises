package com.prussf.coaches;

import com.prussf.fortuneservice.FortuneService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class TennisCoach implements Coach {

	private final FortuneService fortuneService;
	
	// define a default constructor
	public TennisCoach(@Qualifier("fileRandomFortuneService") FortuneService fortuneService) {
		System.out.println(">> TennisCoach: inside default constructor");
		this.fortuneService = fortuneService;
	}

	// define a setter method
	/*
	@Autowired
	public void setFortuneService(FortuneService theFortuneService) {
		System.out.println(">> TennisCoach: inside setFortuneService() method");
		this.fortuneService = theFortuneService;
	}
	*/
	
	/*
	@Autowired
	public TennisCoach(FortuneService theFortuneService) {
		fortuneService = theFortuneService;
	}
	*/
	
	@Override
	public String getDailyWorkout() {
		return "Practice your backhand volley";
	}

	@Override
	public String getDailyFortune() {
		return fortuneService.getFortune();
	}

}
