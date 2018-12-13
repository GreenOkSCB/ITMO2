package lessons16;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import java.util.Date;

public class LaunchStatExternalizable implements Externalizable {

    private int launchCount;  // количество запусков
    private Date lastLaunch;

    private String lastUser;  // добавили  lastUser

    private static final long serialVersionUID = 0L;
    private static final int VERSION = 0;

    public void update(){
        launchCount++;
        lastLaunch = new Date();
        lastUser = System.getProperty("user.name"); // добавили lastUser
    }

    public boolean isFirstLaunch(){
        return launchCount == 0 && lastLaunch == null;
    }

    @Override
    public String toString() {
        return "LaunchStatExternalizable{" +
                "launchCount=" + launchCount +
                ", lastLaunch=" + lastLaunch +
                ", lastUser='" + lastUser + '\'' +
                '}';
    }

    @Override
    public void writeExternal(ObjectOutput out) throws IOException {
        out.write(VERSION);
        out.write(launchCount);
        out.writeObject(lastLaunch);
        out.writeUTF(lastUser);

    }

    @Override
    public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
        int version = in.readInt();  // считываем версию
        if (version > VERSION) { //проверяем
            throw new IOException("unsupported version");
        }
        launchCount = in.readInt(); // считываем количество запусков
        lastLaunch = (Date) in.readObject();

        if (version > 0){
            lastUser = in.readUTF();
        }
    }
}
