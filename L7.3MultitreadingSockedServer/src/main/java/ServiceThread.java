import java.io.*;
import java.net.Socket;

public class ServiceThread extends Thread{
    private Socket socket;
    private BufferedReader in;
    private PrintWriter out;

    public ServiceThread(Socket socket) throws IOException {
        this.socket = socket;
        in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(socket.getOutputStream())));
    }

    @Override
    public void run() {
        while (true) {
            String massage = null;

            try {
                massage = in.readLine();
                if ("Bye.".equals(massage)) {
                    socket.close();
                    return;
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            out.println(massage);
        }
    }
}
