package com.heartBeat.conversations;

import com.heartBeat.profiles.ProfileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@RestController
public class ConversationController {

    private ConversationRepository conversationRepository;
    private ProfileRepository profileRepository;

    public ConversationController(ConversationRepository conversationRepository, ProfileRepository profileRepository) {
        this.conversationRepository = conversationRepository;
        this.profileRepository = profileRepository;
    }

    @PostMapping("/conversations")
    public  Conversation createNewConversation(@RequestBody CreateConversationRequest request){
        profileRepository.findById(request.profileId()).orElseThrow(()->new ResponseStatusException(HttpStatus.NOT_FOUND));

        Conversation conversation = new Conversation(
                UUID.randomUUID().toString(),
                request.profileId,
               new ArrayList<>()
        );

        conversationRepository.save(conversation);
        return conversation;

    }

    public  record CreateConversationRequest(
            String profileId
    ){
    }
}
