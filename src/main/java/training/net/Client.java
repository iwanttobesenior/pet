package training.net;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.Scanner;

class Client {

    private static final String DOMAIN = "india.colorado.edu";
    private static final int PORT = 13;

    public static void main(String[] args) {
        try (Socket socket = new Socket()) {
            socket.connect(new InetSocketAddress(DOMAIN, PORT), 2000);
            Scanner scanner = new Scanner(socket.getInputStream());

            while (scanner.hasNextLine()) {
                System.out.println(scanner.nextLine());
            }

        } catch (IOException e) {
            System.out.println(e.toString());
            e.printStackTrace();
        }
    }
}

