package main;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;


public class Main {
    public static final int PORT = 5050;

    public static void main(String[] args) throws IOException {
        System.out.println("Server started");
        try (ServerSocket serverSocket = new ServerSocket(PORT)) {
            while (true) {
                final Socket socket = serverSocket.accept();
                new ServiceThread(socket).start();
            }
        }
    }
}
