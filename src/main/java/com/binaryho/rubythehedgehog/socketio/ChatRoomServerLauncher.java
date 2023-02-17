package com.binaryho.rubythehedgehog.socketio;


import com.binaryho.rubythehedgehog.ChatRoomProperties;
import com.binaryho.rubythehedgehog.domain.message.Message;
import com.corundumstudio.socketio.AckRequest;
import com.corundumstudio.socketio.SocketIOClient;
import com.corundumstudio.socketio.SocketIONamespace;
import com.corundumstudio.socketio.SocketIOServer;
import com.corundumstudio.socketio.listener.DataListener;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ChatRoomServerLauncher implements SocketServerLauncher {

    private final SocketIOServer socketIOServer;

    public void initSocketIoServer() {
        addAllChatRooms();
        socketIOServer.start();
    }

    private void addAllChatRooms() {
        ChatRoomProperties.CHAT_ROOMS.forEach(chatRoom -> {
            SocketIONamespace socketIONamespace = socketIOServer.addNamespace(
                ChatRoomProperties.CHAT_ROOM_NAMESPACE + "/" + chatRoom);
            socketIONamespace.addEventListener(ChatRoomProperties.CHAT_ROOM_EVENT + "/" + chatRoom, Message.class, createDataListener(socketIONamespace, chatRoom));
        });
    }

    private DataListener<Message> createDataListener(SocketIONamespace socketIONamespace, String chatRoom) {
        return new DataListener<Message>() {

            @Override
            public void onData(SocketIOClient client, Message data, AckRequest ackSender) throws Exception {
                socketIONamespace.getBroadcastOperations()
                    .sendEvent(ChatRoomProperties.CHAT_ROOM_EVENT + "/" + chatRoom, "3 : " + data);
            }
        };
    }
}
