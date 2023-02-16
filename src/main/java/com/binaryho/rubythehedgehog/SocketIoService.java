package com.binaryho.rubythehedgehog;

import com.corundumstudio.socketio.Configuration;
import com.corundumstudio.socketio.SocketIOServer;
import javax.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class SocketIoService {

    @Value("${socketio-server.host}")private String hostName;
    @Value("${socketio-server.port}") private Integer portNumber;

    @PostConstruct
    private void initSocketIOServer() {
        Configuration configuration = new Configuration();
        configuration.setHostname(hostName);
        configuration.setPort(portNumber);

        SocketIOServer nettySocketIoServer = new SocketIOServer(configuration);
        nettySocketIoServer.start();

        System.out.println("init socket io server!\n" + hostName + ":" + portNumber);
    }
}
