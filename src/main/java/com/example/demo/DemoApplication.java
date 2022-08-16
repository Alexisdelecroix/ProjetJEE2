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
			patientRepository.save(new Patient(null,"Hassan",new Date(),false,112));
			patientRepository.save(new Patient(null,"Mohammed",new Date(),true,321));
			patientRepository.save(new Patient(null,"Yasmine",new Date(),true,165));
			patientRepository.save(new Patient(null,"Hanae",new Date(),false,132));

			patientRepository.findAll().forEach(p -> {
				System.out.println(p.getNom());
			});
		};
	}
}
