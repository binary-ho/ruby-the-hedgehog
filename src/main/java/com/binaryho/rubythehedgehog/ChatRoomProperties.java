package com.binaryho.rubythehedgehog;

import java.util.Arrays;
import java.util.List;

public class ChatRoomProperties {

    private ChatRoomProperties() {}

    public static final String CHAT_ROOM_EVENT = "chatRoomMessage";
    public static final String CHAT_ROOM_NAMESPACE = "/chatRoom";
    public static final List<String> CHAT_ROOMS = Arrays.asList("1", "2", "3");
}
