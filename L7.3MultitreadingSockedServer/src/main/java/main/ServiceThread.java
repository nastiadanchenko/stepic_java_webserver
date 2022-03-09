package main;

import java.io.*;
import java.net.Socket;
import java.util.logging.Logger;

public class ServiceThread extends Thread {
    private final Socket socket;
    private BufferedReader in;
    private PrintWriter out;

    public ServiceThread(Socket socket) throws IOException {
        this.socket = socket;
        in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        out = new PrintWriter(
                new BufferedWriter(new OutputStreamWriter(socket.getOutputStream())), true);
    }

    @Override
    public void run() {
       Logger log =  Logger.getLogger(ServiceThread.class.getName());
        try {
            while (true) {
                String massage = in.readLine();
                if (massage.equals("Bye.")) {
                    socket.close();
                    log.info("Connection close");
                    break;
                } else {
                    out.println(massage);
                }
            }
        } catch (IOException e) {
            System.err.println("IO Exception");
        } finally {
            try {
                socket.close();
            } catch (IOException e) {
                System.err.println("Socket not closed");
            }
        }

    }
}
