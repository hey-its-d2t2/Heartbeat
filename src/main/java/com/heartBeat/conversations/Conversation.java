package com.heartBeat.conversations;

import java.util.List;

public record Conversation(
        String id,
        String profileId,
        List<ChatMessage> ChatMessage
) {
}
