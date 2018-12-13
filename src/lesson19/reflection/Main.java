package lesson19.reflection;

import java.lang.reflect.*;
import java.util.Arrays;

public class Main{
    public static void main(String[] args) throws
            NoSuchFieldException,
            IllegalAccessException, // если поле или метод приватные, и не получить доступа
            NoSuchMethodException,  // если метод в классе не найден
            InvocationTargetException,
            InstantiationException {
        // каждый загруженнный класс имеет соответствующие
        // java.lang.Class объект, который дает доступ к структуре класса

        // у каждого типа есть свой литерал Class
        System.out.println(String.class);
        System.out.println(int.class);

        Child child = new Child("str", 1);
        System.out.println(child.getClass());  // вызываем у объекта getClass, нам сообщает к какому классу принадлежит объект

        Class cls;
        cls = child.getClass();
        System.out.println("child name " + cls.getName());   //  у child getName приватный, но мы получили к нему доступ

        cls = cls.getSuperclass();
        System.out.println("child extends " + cls.getName());  // получили родителя класса

        // доступ к компонентам

        // класс объекта
        Class<Child> childClass = Child.class;

        // доступ к полям
        Field[] fields = childClass.getFields();
        System.out.println(Arrays.toString(fields));

        // доступ к declared полям
        Field[] declaredFields = childClass.getDeclaredFields();
        System.out.println(Arrays.toString(declaredFields));

        // доступ к методам
        Method[] methods = childClass.getMethods();
        System.out.println(Arrays.toString(methods));

        // если хотим только объявленные методы класса
        Method[] declaredMethods = childClass.getDeclaredMethods();
        System.out.println(Arrays.toString(declaredMethods));

        // доступ к конструктору
        Constructor<?>[] declaredConstructors = childClass.getDeclaredConstructors();
        System.out.println(Arrays.toString(declaredConstructors));

        // доступ к конкретному полю, методу, конструктору
        Field field = childClass.getDeclaredField("name");
        // получить доступ к полю
        field.setAccessible(true);
        field.set(child, "CHILD");
        System.out.println((String)field.get(child));
        System.out.println(child);

        // доступ к методу
        Method method = childClass.getDeclaredMethod("getInfo");
        method.setAccessible(true);
        String data = (String) method.invoke(child);
        System.out.println(data);

        // доступ к конструктору
//        Constructor<Child> childConstructor = childClass.getDeclaredConstructor();
        Constructor<Child> childConstructor = childClass.getDeclaredConstructor(String.class, int.class);
        // создание объекта
        Child child1 = childConstructor.newInstance("CHILD 1", 3);
        System.out.println(child1);

        boolean isFinal = Modifier.isFinal(field.getModifiers()); // isFinal возвращает true если поле final
        boolean isPrivate = Modifier.isPrivate(field.getModifiers());

        Class<?>[] interfaces = childClass.getInterfaces();






    }

}
