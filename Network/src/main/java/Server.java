import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    private ServerSocket serverSocket;
    private Socket clientSocket;
    private PrintWriter out;
    private BufferedReader in;

    public void start(int port) throws IOException, InterruptedException {
        serverSocket = new ServerSocket(port);
        clientSocket = serverSocket.accept();
//        in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));


        int i = 0;
        while (true) {
            System.out.println("online" + i++);
            Thread.sleep(1000);
        }
    }

    public void stop() throws IOException {
        in.close();
        out.close();
        clientSocket.close();
        serverSocket.close();
    }

    public static void main(String[] args) throws IOException, InterruptedException {
        Server server = new Server();
        server.start(443);
    }
}