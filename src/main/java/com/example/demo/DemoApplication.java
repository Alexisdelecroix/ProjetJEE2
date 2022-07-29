package com.example.demo;

import com.example.demo.entities.Patient;
import com.example.demo.repositories.PatientRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Date;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}



	@Bean
	CommandLineRunner commandLineRunner(PatientRepository patientRepository){
		return args -> {
			patientRepository.save(new Patient(null,"Hassan",new Date(),false,12));
			patientRepository.save(new Patient(null,"Mohammed",new Date(),true,321));
			patientRepository.save(new Patient(null,"Yasmine",new Date(),true,65));
			patientRepository.save(new Patient(null,"Hanae",new Date(),false,32));

			patientRepository.findAll().forEach(p -> {
				System.out.println(p.getNom());
			});
		};
	}
}
