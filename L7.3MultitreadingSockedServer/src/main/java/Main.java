import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Logger;

public class Main {
    public static void main(String[] args) {
        try (ServerSocket serverSocket = new ServerSocket(5050)) {
            Logger.getAnonymousLogger().info("Server started");

            while (true) {
                Socket socket = serverSocket.accept();
                new ServiceThread(socket).start();
                socket.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
