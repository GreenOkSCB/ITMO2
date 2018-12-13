package lessons16.printApp;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.SocketAddress;
import java.util.Scanner;

public class PrintClient {

    private SocketAddress socketAddress; // пакет для работы с адрессами
    private Scanner scanner;

    public PrintClient(SocketAddress adress, Scanner scanner){
        this.socketAddress = adress;
        this.scanner = scanner;
    }

    private void start() throws IOException {
        System.out.println("Enter your name: ");
        String name = scanner.nextLine();

        while (true){
            System.out.println("Enter your message: ");
            String msg = scanner.nextLine();

            buildAndMassage(name, msg);
        }
    }

    private void buildAndMassage(String name, String mess) throws IOException {
        Message message = new Message(name, mess);
        sendMess(message); // передаем сообщение в метод sendMessage
    }

    private void sendMess(Message message) throws IOException {
        try (Socket socket = new Socket()){
            socket.connect(socketAddress);      // соединение с сервером
            try (OutputStream out =
                         socket.getOutputStream()){     // getOutputStream позволяет получить поток, в который будем отправлять данные
                ObjectOutputStream objOut = new ObjectOutputStream(out);    // создаем объект, который будет заниматься сериализацией данных
                objOut.writeObject(message);   // записываем сообщение в объект
                objOut.flush();     // отправляет данные на сервер
            }
        }
    }

    private static SocketAddress parseAddress(String address){
        String[] strings = address.split(":");  // режет строчку на символы
        return new InetSocketAddress(strings[0],Integer.parseInt(strings[1]) );
    }

    public static void main(String[] args) {
        // если запускатеся программа с аргументом args имеющим адресс порта, то работаем по нему
        String address = null;
        if (args != null && args.length > 0) {
            address = args[0];
        }

        // если порта нет, то просим клиента ввести аддресс
        Scanner scanner = new Scanner(System.in);

        if (address == null) {
            System.out.println("Enter server address");
            address = scanner.nextLine();
        }
            // "127.0.0.1:8080"
        PrintClient client = new PrintClient(parseAddress(address), scanner);
        try {
            client.start();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
