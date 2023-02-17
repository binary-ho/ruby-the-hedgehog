package com.binaryho.rubythehedgehog.socketio;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SocketServerRunner implements CommandLineRunner {

    private final SocketServerLauncher socketServerLauncher;

    @Override
    public void run(String... args) throws Exception {
        socketServerLauncher.initSocketIoServer();
    }
}
