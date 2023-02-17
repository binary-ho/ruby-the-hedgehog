package com.binaryho.rubythehedgehog.socketio;

import com.corundumstudio.socketio.Configuration;
import com.corundumstudio.socketio.SocketIOServer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;

@org.springframework.context.annotation.Configuration
public class SocketIoServerConfig {

    @Value("${socketio-server.host}")private String hostName;
    @Value("${socketio-server.port}") private Integer portNumber;

    @Bean
    public SocketIOServer socketIOServer() {
        Configuration configuration = new Configuration();
        configuration.setHostname(hostName);
        configuration.setPort(portNumber);

        return new SocketIOServer(configuration);
    }
}
