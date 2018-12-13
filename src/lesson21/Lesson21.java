package lesson21;

import java.util.List;
import java.util.ArrayList;

public class Lesson21 {
    public static void main(String[] args) throws InterruptedException {
        Sync sync = new Sync();
        List<Sync.Adder> adderList = new ArrayList<>(100);

        // создаем потоки
        for (int i = 0; i < 100; i++){
            adderList.add(sync.new Adder());
        }

        // запускаем потоки
        for (Sync.Adder adder: adderList){
            adder.start();
        }

        // ждем завершения
        for (Sync.Adder adder: adderList){
            adder.join();
        }

        // вывод результата
        System.out.println("Result: " + sync.counter);
    }
}

// общий участок памяти,
// который будем изменять из разных потоков
class Sync{
    int counter;

    private  synchronized void increment(){  // синхронизация в методе
        // при синхронизации в методе происходит синхронизация на текущем объекте (this)
        counter++;
    }

    public class Adder extends Thread{
        @Override
        public void run() {
            for (int i = 0; i <100000; i++){
//                counter++;   // несинхронизированный счетчик
//                synchronized (Sync.this){   // в параметрах передаем объект, который надо синхронизировать
//                                            // все что внутри блока может выполнять только один поток
//                    counter++;  // синхронизированный счетчик
//                }
                increment();
            }
        }
    }
}

class Storage{
    int booksCount = 0;
    public synchronized void getBook() throws InterruptedException {
        System.out.println("getBook START");
        while (booksCount < 1){
            System.out.println("-------------------------------getBook в ожидании");
            wait();  // блокирует поток
        }
        booksCount--;
        System.out.println("Одну книгу забрали");
        System.out.println("1.В библиотеке осталось: " + booksCount);
        notify(); // сообщит другим потокам, что можно работать другим потокам(один случайно)
        notifyAll(); // сообщит другим потокам, что можно работать другим потокам(всем сразу)
        System.out.println("getBook FINISH");
    }

    public synchronized void putBook() throws InterruptedException {
        System.out.println("putBook START");
        while (booksCount >= 5){
            System.out.println("--------------------------------putBook в ожидании");
            wait();
        }
        booksCount++;
        System.out.println("Книга добавлена");
        System.out.println("2.В библиотеке осталось: " + booksCount);
        System.out.println("putBook FINISH");

    }
}

class Put implements Runnable{
    Storage storage;

    public Put(Storage storage){
        this.storage = storage;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++){
            try {
                storage.putBook();
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        }
    }
}

class Get implements Runnable{
    Storage storage;

    public Get(Storage storage){
        this.storage = storage;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++){
            try {
                storage.getBook();
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        }
    }
}

class Library{
    public static void main(String[] args) {
//        Storage storage = new Storage();
//        Put put = new Put(storage);
//        Get get = new Get(storage);
//        new Thread(put).start();
//        new Thread(get).start();

        Object obj1 = new Object();
        Object obj2 = new Object();

        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("Thread 1 start");
                synchronized (obj1){
                    System.out.println("Thread 1 locked obj1");
                    synchronized (obj2){
                        System.out.println("Thread 1 locked obj2");
                    }
                }
            }
        });

        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("Thread 2 start");
                synchronized (obj2){
                    System.out.println("Thread 2 locked obj2");
                    synchronized (obj1){
                        System.out.println("Thread 2 locked obj1");
                    }
                }
            }
        });
        thread1.start();
        thread2.start();

    }
}

// выполнить полсчет ТОП 100 слов параллельно
// количество потоков должно быть равно
// числу доступных процессоров системы
// Runtime.getRuntime().availableProcessor()

