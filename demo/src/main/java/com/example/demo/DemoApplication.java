package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
		// user={"id":1,"firstName":"John","lastName":"Doe","email":"john.doe@example.com","createdAt":"2024-09-10T14:11:22"}  
		//athlete={"id":1,"speed":15,"height":180,"weight":75,"userId":1,"starRating":5,"athleteSchedule":"Tuesday 4 PM"}
		// student={"grade":"A","userId":1,"studentSchedule":"Monday 9 AM","className":"Mathematics"}

		
	}

}
