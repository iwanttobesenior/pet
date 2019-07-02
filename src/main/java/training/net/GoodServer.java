package training.net;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

class GoodServer {

    private static final int PORT = 6611;

    public static void main(String[] args) {
        try (ServerSocket serverSocket = new ServerSocket(PORT); PrintWriter printWriter = null) {

            while (true) {
                Socket request = serverSocket.accept();

                Runnable runnable = () -> {
                    try {
                        new PrintWriter(request.getOutputStream(), true)
                                .println("hello from thread " + Thread.currentThread().getName());
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                };

                new Thread(runnable).start();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
