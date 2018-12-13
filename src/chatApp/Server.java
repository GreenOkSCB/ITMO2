package chatApp;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Set;
import java.util.concurrent.BlockingDeque;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.LinkedBlockingDeque;

public class Server {
    private int port;

    private final Set<IOConnection> connections = new CopyOnWriteArraySet<>();
    private final BlockingDeque<Message> messageQueue = new LinkedBlockingDeque<>();

    public Server(int port) {
        this.port = port;
    }

    private void start() throws IOException {
        new Thread(new Writer()).start();

        try (ServerSocket serverSocket = new ServerSocket(port)) {
            System.out.println("server started on: " + serverSocket);
            IOConnection ioConnection;
            while (true) {
                Socket socket = serverSocket.accept();

                ioConnection = new IOConnection(socket);
                connections.add(ioConnection);
                new Thread(new Reader(ioConnection)).start();
            }
        }
    }

    private class Writer implements Runnable {
        @Override
        public void run() {
            try {
                while (!Thread.currentThread().isInterrupted()) {
                    try {
                        Message msg = messageQueue.take();

                        for (IOConnection connection : connections) {
                            connection.sendMessage(msg);
                        }
                    } catch (IOException e) {
                        connections.remove(connections);
                    }
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private class Reader implements Runnable {
        private IOConnection connection;

        public Reader(IOConnection connection) {
            this.connection = connection;
        }

        @Override
        public void run() {
            while (!Thread.currentThread().isInterrupted()) {
                try {
                    while (!Thread.currentThread().isInterrupted()) {
                        Message msg = connection.recieve();
                        messageQueue.add(msg);
                        System.out.println(msg);
                    }
                } catch (IOException | ClassNotFoundException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void main(String[] args) {
        Server server = new Server(8080);
        try {
            server.start();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
