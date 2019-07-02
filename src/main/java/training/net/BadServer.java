package training.net;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

class BadServer {

    private static final int SERVER_PORT = 8901;

    public static void main(String[] args) throws InterruptedException {
        try (ServerSocket serverSocket = new ServerSocket(SERVER_PORT)) {
            Socket accept = serverSocket.accept();


            Thread.sleep(3333);
//            Scanner in = new Scanner(accept.getInputStream());
//            while (in.hasNextLine()) {
//                System.out.println(in.nextLine());
//            }

            PrintWriter writer = new PrintWriter(accept.getOutputStream(),true);
            writer.println("dwdwdwdw");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
