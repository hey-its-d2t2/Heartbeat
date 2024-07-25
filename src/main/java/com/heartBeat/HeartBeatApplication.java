package com.heartBeat;

import com.heartBeat.conversations.ChatMessage;
import com.heartBeat.conversations.Conversation;
import com.heartBeat.conversations.ConversationRepository;
import com.heartBeat.profiles.Gender;
import com.heartBeat.profiles.Profile;
import com.heartBeat.profiles.ProfileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.LocalDateTime;
import java.util.List;

@SpringBootApplication
public class HeartBeatApplication  implements CommandLineRunner {

	@Autowired
	private ProfileRepository profileRepository;

	@Autowired
	private ConversationRepository conversationRepository;

	public static void main(String[] args) {

		SpringApplication.run(HeartBeatApplication.class, args);
	}

	public  void run(String... args){
		//System.out.println("Running");
		profileRepository.deleteAll();
		conversationRepository.deleteAll();
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
		profile = new Profile(
				"2",
				"Timpal",
				"Mahto",
				22,
				"Indian",
				Gender.MALE,
				"Software Developer",
				"abc.jpg",
				"INTP"
		);
		profileRepository.save(profile);
		profileRepository.findAll().forEach(System.out::println);

		Conversation conversation = new Conversation(
			"1",
			profile.id(),
				List.of(
						new ChatMessage("Hello",profile.id(), LocalDateTime.now())
				)
		);

		conversationRepository.save(conversation);
		conversationRepository.findAll().forEach(System.out::println);
	}
}
