import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class Client {
    private static Socket clientSocket;
    private PrintWriter out;
    private BufferedReader in;

    public static void serverCheck(String ip, int port) throws IOException {
        try {
            clientSocket = new Socket(ip, port);
            System.out.println("server online");
        } catch (Exception e) {
            System.out.println("server offline");
        }
    }

    public static void portCheck(String ip, int start, int end) throws IOException {
        Socket socket;

        for (int i = start; i <= end; i++) {
            try {
                socket = new Socket(ip, i);
                System.out.print("IP:\t" + ip + "\tport:\t" + i + "\t name:\t");
                switch (i) {
                    case 20:
                        System.out.print("FTP");
                        break;
                    case 21:
                        System.out.print("FTP");
                        break;
                    case 22:
                        System.out.print("SSH");
                        break;
                    case 25:
                        System.out.print("SMTP");
                        break;
                    case 53:
                        System.out.print("DNS");
                        break;
                    case 80:
                        System.out.print("http");
                        break;
                    case 123:
                        System.out.print("NTP");
                        break;
                    case 443:
                        System.out.print("https");
                        break;
                    default:
                        System.out.print("anonymous service running on this port");
                        break;
                }
                System.out.println("");
            } catch (Exception e) {

            }
        }
    }

    public String sendMessage(String msg) throws IOException {
        out.println(msg);
        String resp = in.readLine();
        return resp;
    }

    public void stopConnection() throws IOException {
        in.close();
        out.close();
        clientSocket.close();
    }

    public static void postUser(String username, String age) {
        try {
            // Create a socket to connect to localhost on port 8080
            Socket socket = new Socket("localhost", 8080);

            // Create the POST request body with parameters
            String postData = username + " " + age; // Replace with desired name and age

            // Construct the POST request
            String postRequest = "POST/HTTP/1.1" +
                    "Host:localhost:8080" +
                    "Content-Type:application/x-www-form-urlencoded" +
                    "Content-Length:" + postData.length() +
                    "Connection:close " +
                    postData;

            // Send the request
            PrintWriter out = new PrintWriter(socket.getOutputStream());
            out.print(postRequest);
            out.flush();

            // Read and print the response
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            String line;
            while ((line = in.readLine()) != null) {
                System.out.println(line);
            }

            // Close resources
            out.close();
            in.close();
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void getUser(String userId) {
        try {
            // Create a socket to connect to localhost on port 8080
            Socket socket = new Socket("localhost", 8080);

            // Create the GET request
            String getRequest = "GET " + userId + " HTTP/1.1\r\n" +
                    "Host: localhost:8080\r\n" +
                    "Connection: close\r\n\r\n";

            // Send the request
            PrintWriter out = new PrintWriter(socket.getOutputStream());
            out.print(getRequest);
            out.flush();

            // Read and print the response
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            String line;
            while ((line = in.readLine()) != null) {
                System.out.println(line);
            }

            // Close resources
            out.close();
            in.close();
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws IOException {
        UserPanel.menu();
    }
}