package lessons16;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException, ClassNotFoundException {

        /* main LaunchStat */
        File statFile = new File("stat.bin");
        LaunchStat stat;

        if (!statFile.exists()) {  //если файл не найден
            stat = new LaunchStat();  // то создается файл
        } else {  // еще раз запускаем, происходит чтение из объекта
            try (ObjectInputStream objIn = new ObjectInputStream(
                    new FileInputStream(statFile)
            )) {
                stat = (LaunchStat) objIn.readObject();
            }
        }

        if (stat.isFirstLaunch()) {
            System.out.println("First launch");
        } else {
            System.out.println(stat.toString());
        }

        stat.update();

        // сохранение
        try (ObjectOutputStream objOuts = new ObjectOutputStream(
                new FileOutputStream(statFile)
        )) {
            objOuts.writeObject(stat);
        }

        /* main2 LaunchStatExternizable */

//        LaunchStatExternalizable stat;
//        File statFile = new File("stat2.bin");
//
//        if(!statFile.exists()) {
//            stat = new LaunchStatExternalizable();
//        } else {
//            try (ObjectInputStream ois = new ObjectInputStream(
//                    new FileInputStream(statFile)
//            )){
//                stat = (LaunchStatExternalizable) ois.readObject();
//            }
//        }
//
//        if (stat.isFirstLaunch()){
//            System.out.println("First launch");
//        } else {
//            System.out.println(stat.toString());
//        }
//
//        stat.update();
//
//        try (ObjectOutputStream objOts = new ObjectOutputStream(
//                new FileOutputStream(statFile)
//        )){
//            objOts.writeObject(stat);
//        }

    }
}
