package lesson20;

public class Lesson20 {
    public static void main(String[] args) throws InterruptedException {
//        System.out.println("1: ");
        System.out.println(Thread.currentThread().getName());
        // методы класса Thread
        // currentThread(); - для получения текущего потока
        // setName(str); - задает имяпотока
        // getName(); - возвращает имя
        // join(); - ожидает завершения потока исполнения,
        // вызывающий поток ожидает, когда указанный поток присоединится к нему
        // isAlive(); - возвращает true, если поток еще исполняется
        // getState() - возвращает текущее состояние потока
        // sleep(1000) - приостанавливает поток на указанное количество миллисекунд

        // setDaemon(true) - поток завершится, когда завершится основной поток
        // isInterrupted(); - работает с флагом true(работает поток)/false(поток прерван) показывает текущее состояние
        // interrupt(); - работает с флагом true/false меняет флаг на true, останавливает поток


        /* */
//        Thread thread = new Thread();   // создание потока
//        thread.start(); // старт потока, сразу завершается, так как ничего не делает
//
//        Thread thread1 = new MyThread();
//        thread1.start();
//
//        Thread thread2 = new Thread(new OtherThread());
//        thread2.start();
//
//        for (int i = 0; i < 5; i++){      // создаем потоки, пока позволяют ресурсы
//            Thread thread3 = new Thread(new OtherThread());
//            thread3.setName("T- " + i);
//            thread3.start();
//        }

        /* join */
//            Thread thread4 = new Thread(new Runnable() {  // инициализация аннонимным классом
//                @Override
//                public void run() {
//                    System.out.println("Running " + Thread.currentThread().isAlive());    // Проверяем работает ли текущий поток
//                    System.out.println("Running " + Thread.currentThread().getState());   // Проверяем работает ли текущий поток
//                }
//            });
//
//        System.out.println("Before start " + thread4.isAlive());  // Проверяем работает ли наш поток до старта
//        System.out.println("Before start " + thread4.getState()); // Проверяем работает ли наш поток до старта
//        System.out.println("1");
//        thread4.start();
//        System.out.println("Starting " + thread4.isAlive());  // Проверяем работает ли наш поток после старта
//        System.out.println("Starting " + thread4.getState());  // Проверяем работает ли наш поток после старта
//        System.out.println("2");
//        thread4.join();  // ожидаем, что поток завершится
//        System.out.println("3");
//        System.out.println("After join " + thread4.isAlive());
//        System.out.println("After join " + thread4.getState());

        /* sleep
           Java программа работает до тех пор, пока есть незавершенные потоки
           Например, эта не остановится никогда. */
//        Thread thread5 = new Thread(new Runnable() {
//            @Override
//            public void run() {
//                while (true){
//                    try {
//                        Thread.sleep(1000);
//                    } catch (InterruptedException e){
//                        e.printStackTrace();
//                    }
//                }
//            }
//        });
//        thread5.start();


        /* daemon
         * Но это касается основных потоков, а помеченные как
           daemon, будут остановлены сразу после остановки последнего основного потока. */

// программа будет работать пока есть незавершенные потоки
// это касается ОСНОВНЫХ потоков
// Потоки отмечаные как daemon будут остановлены, сразу после остановки
// последнего основного потока

//        Thread thread6 = new Thread(new Runnable() {
//            @Override
//            public void run() {
//                while (true) {
//                    try {
//                        Thread.sleep(1000);
//                    } catch (InterruptedException e) {
//                        e.printStackTrace();
//                    }
//                }
//            }
//        });
//        thread6.setDaemon(true);  // Использовать daemon потоки не рекомендуется,
//                                  // кроме того случая, когда вы уверены в том, что делаете
//        thread6.start();

        /* остановка потока */

//        Поток останавливатся в следующих случаях:
//        1. Поток выполнил все инструкции и выходит из метода run().
//        2. Было выброшено необрабатываемое исключение в методе run().
//        3. Остановилась JVM.
//        4. Это был daemon поток и последний основной поток завершил свою работу.


//  механизм прерываний
        Thread thread7 = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("2: ");
                // Проверяем флаг: не было ли выполение потока прервано, если да, то выходим
                //  в то время как (если у  Потока.текущегоПотока(). НЕ! прерван поток, то есть флаг НЕ!true())
                while (!Thread.currentThread().isInterrupted()) {  // isInterrupted() булево значение, false если поток работает
                    try {
                        System.out.println("3: ");
                        System.out.println("thread7");
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        System.out.println("4: ");
                        // Если выбрасывается исключение InterruptedException, то флаг не переводится в true. Для этого
                        // вручную вызывается метод interrupt() у текущего потока
//                        Thread.currentThread().interrupt(); // флаг ставит как true, прерываем поток
                        System.out.println("InterruptedException");
//                        e.printStackTrace();
                    }
                }
            }
        });
        System.out.println("5: ");
        thread7.start();
        Thread.sleep(2000);
        System.out.println("false? "+ thread7.isInterrupted());
        System.out.println("6: ");
        thread7.interrupt();        // Прерываем выполнение потока
        System.out.println("7: ");





    }
}


/* 1) для создания своего потока нужно унаследовать класс от от java.lang.Thread
    и переопределить метод run() */
class MyThread extends Thread{
    @Override
    public void run() {
        this.setName("qwe");
        System.out.println("MyThread " + Thread.currentThread().getName());
    }
}

/* 2) Либо реализовать интерфейс ava.lang.Runnable
    и передать объект в конструктор класса java.lang.Thread
    - лучше использовать этот способ */
class OtherThread implements Runnable{
    @Override
    public void run() {
        System.out.println("OtherThread " + Thread.currentThread().getName());
    }
}

