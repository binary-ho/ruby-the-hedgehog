package com.binaryho.rubythehedgehog.domain.message;

import lombok.Data;

@Data
public class Message {

    private String receiverName;
    private String senderName;
    private String message;
    private int chatRoomNumber;
}
