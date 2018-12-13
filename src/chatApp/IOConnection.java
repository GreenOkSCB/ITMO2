package chatApp;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class IOConnection implements AutoCloseable {

    private Socket socket;
    private ObjectOutputStream out;
    private ObjectInputStream in;

    public IOConnection(Socket socket){
        this.socket = socket;
        try {
            this.out = new ObjectOutputStream(socket.getOutputStream());
            this.in = new ObjectInputStream(socket.getInputStream());
        }catch (IOException  e){
            e.printStackTrace();
        }
    }

    public Message recieve() throws IOException, ClassNotFoundException {
        return (Message) in.readObject();
    }

    public void sendMessage(Message mess) throws IOException {
        out.writeObject(mess);
        out.flush();
    }

    @Override
    public void close() throws IOException {
        this.in.close();
        this.out.close();
        this.socket.close();
    }
}
