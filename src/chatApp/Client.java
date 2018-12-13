package chatApp;

import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class Client {

    private Scanner in = new Scanner(System.in);
    private IOConnection ioConnection;

    private Client(IOConnection ioConnection) {
        this.ioConnection = ioConnection;
    }

    public void start() throws IOException {
        System.out.println("Enter your name: ");
        String name = in.nextLine();

        Thread reader = new Thread(new Reader(ioConnection));
        reader.start();

        System.out.println("Enter message to sendMessage: ");

        while (true) {
            String msg = in.nextLine();

            // реализовать возможность выхода(/exit)
            // реализовать возможность сменить имя пользователя(/reName)

            if (msg != null && !msg.isEmpty()) {
                Message message = new Message(name, msg);//new Message(name, msg);
                ioConnection.sendMessage(message);
            }
        }

    }

    private class Reader implements Runnable {
        private final IOConnection connection;

        private Reader(IOConnection connection) {
            this.connection = connection;
        }

        @Override
        public void run() {
            try {
                while (!Thread.currentThread().isInterrupted()) {
                Message message = connection.recieve();
                System.out.println(message);
                }
            } catch (IOException | ClassNotFoundException e){
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) throws IOException {
        Client client = new Client(new IOConnection(new Socket("127.0.0.1", 8080)));
        client.start();
    }
}
