package com.heartBeat;

import com.heartBeat.profiles.Gender;
import com.heartBeat.profiles.Profile;
import com.heartBeat.profiles.ProfileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class HeartBeatApplication  implements CommandLineRunner {

	@Autowired
	private ProfileRepository profileRepository;

	public static void main(String[] args) {

		SpringApplication.run(HeartBeatApplication.class, args);
	}

	public  void run(String... args){
		//System.out.println("Running");
		Profile profile = new Profile(
				"1",
				"Deepak",
				"Singh",
				23,
				"Indian",
				Gender.MALE,
				"Software Developer",
				"abc.jpg",
				"INTP"
		);
		profileRepository.save(profile);
		profileRepository.findAll().forEach(System.out::println);
	}
}
