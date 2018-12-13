package patterns.singleton;

public class Singleton1 {
    /* в отличии от Singleton2 объект создаётся при вызове метода getInstance*/
    /* статическое поле */ // для чего?
    private static Singleton1 instance;

    /* приватный конструктор - запрет создания объектов извне */
    private Singleton1(){}

    /* метод создания объекта по требованию */
    public static Singleton1 getInstance(){  // вызывая getInstance создаем один объект Singleton1
        if (instance == null){  // данный if сработает один раз
            instance = new Singleton1();  // создание единственного экземпляра
        }
        return instance;  // возвращаем объект instance
    }




}
