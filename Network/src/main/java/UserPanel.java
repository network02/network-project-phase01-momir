import java.io.IOException;
import java.util.Scanner;

public class UserPanel {
    public static void menu() throws IOException {
        System.out.println("Choose to continue :");
        System.out.println("1:connect to server\n" +
                "2:Get online ports\n" +
                "3:Use Get method\n" +
                "4:Use Post method\n" +
                "5:Exit");
        Scanner sc = new Scanner(System.in);
        int input = sc.nextInt();
        switch (input) {
            case 1:
                System.out.println("Enter IP:");
                sc.nextLine();
                String ip = sc.nextLine();
                System.out.println("Enter Port:");
                int port = sc.nextInt();
                Client.serverCheck(ip, port);
                break;
            case 2:
                System.out.println("Enter IP");
                sc.nextLine();
                String ip2 = sc.nextLine();
                System.out.println("Enter start port");
                int port1 = sc.nextInt();
                System.out.println("Enter end port");
                int port2 = sc.nextInt();
                Client.portCheck(ip2, port1, port2);
                break;
            case 3:
                System.out.println("Enter the id of the user you are searching for:");
                sc.nextLine();
                String userId = sc.nextLine();
                Client.getUser(userId);
                break;
            case 4:
                System.out.println("Enter the username :");
                sc.nextLine();
                String username = sc.nextLine();
                System.out.println("Enter the age :");
                sc.nextLine();
                String age = sc.nextLine();
                Client.postUser(username, age);
                break;
            case 5:
                System.exit(0);
                break;
            default:
                System.out.println("Something went wrong...\n" +
                        " please try again");
                menu();
                break;
        }
        menu();
    }
}
