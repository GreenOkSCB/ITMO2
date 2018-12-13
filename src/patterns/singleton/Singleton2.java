package patterns.singleton;

public class Singleton2 {
    /* в отличии от Singleton1 объект создаётся при инициализации класса */
    private static final Singleton2 INSTANCE = new Singleton2(); // создаем константу и записываем в нее объект

    private Singleton2(){}      // конструктор все равно нужен

    /* создание объекта при инициализации класса */
    public static Singleton2 getInstance(){
        return INSTANCE;
    }
}
