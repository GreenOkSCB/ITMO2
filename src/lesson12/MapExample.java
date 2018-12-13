package lesson12;

import java.util.*;

public class MapExample {
    public static void main(String[] args) {
        User user = new User(2, "Женя");
        System.out.println(user.hashCode());

                 /*  Map  */
//        интерфейс, который имеет несколько реализаций
//        хранит данный в паре - ключ/значение
//        ключи должны быть уникальными
//        хранение зависит от реализации
//        могут хранить любые типы данных (null в качестве ключа зависит от реализации)
//        boolean containsKey(Object key); если находит ключ в Map, то возвращает true
//        boolean containsValue(Object val);
//        void putAll(Map<?extends K, ?extends V> m) может создать новую Map но основании существующей
//        get(T key); возвращает значение по ключу
//        put(T key, T val); позволяет по ключу добавить значение
                /*  Реализации Map  */
//        HashMap
//        TreeMap
//        EnumMap
//        LinkedHashMap
//        WeakHashMap
//        IdentityHashMap

                 /*  HashMap  */
//        Map<Integer, String> hashMap = new HashMap<>();
//        hashMap.put(1,"Elem 1");
//        hashMap.put(2,"Elem 2");
//        hashMap.put(2,"Elem 3");  // перезаписали значение по ключе
//        hashMap.put(null,"Elem null");  // если значение null, то устанавливается на первую позицию в Map
//        System.out.println(hashMap);
//        System.out.println(hashMap.get(2));
//
//        // перебрать элементы Map
//        for (Map.Entry entry: hashMap.entrySet()){   // метод entrySet возвращает нам из Map список объектов(ВСЕ значения)
//            System.out.println("Key: " + entry.getKey() + " Value: " + entry.getValue());
//        }

                 /*  LinkedHashMap  */   // использовать, если важен порядок в котором добавляются значения в Map
//        Map<Integer, String> linkedHashMap = new LinkedHashMap<>();
//        linkedHashMap.put(1,"Elem 1");
//        linkedHashMap.put(2,"Elem 2");
//        linkedHashMap.put(2,"Elem 3");  // перезаписали значение по ключе
//        linkedHashMap.put(null,"Elem null");  // хранятся значения в том порядке, в котором добавили
//        System.out.println(linkedHashMap);
//        System.out.println(linkedHashMap.get(2));
//
//        // перебрать элементы Map
//        for (Map.Entry entry: linkedHashMap.entrySet()){   // метод entrySet возвращает нам из Map список объектов(ВСЕ значения)
//            System.out.println("Key: " + entry.getKey() + " Value: " + entry.getValue());
//        }

        /*  TreeMap  */    // происходит сортировка по ключам по возрастанию ключей. Реализуется с помощью бинарного дерева
        Map<Integer, String> treeMap = new TreeMap<>();
        treeMap.put(1,"Elem 1");
        treeMap.put(2,"Elem 2");
        treeMap.put(2,"Elem 3");  // перезаписали значение по ключе
//        treeMap.put(null,"Elem null");  // не может хранить значение null
        System.out.println(treeMap);
        System.out.println(treeMap.get(2));

        // перебрать элементы Map
        for (Map.Entry entry: treeMap.entrySet()){   // метод entrySet возвращает нам из Map список объектов(ВСЕ значения)
            System.out.println("Key: " + entry.getKey() + " Value: " + entry.getValue());
        }

        // бинарное дерево
//        1. корень - самый верхний узел
//        2. листья - узлы без потомков
//        3. значение левого потомка должно быть меньше родителя
//        4. значение правого потомка должно быть больше родителя либо равно
        // красно - черное бинарное дерево
//        1. корень и листья всегда черные
//        2. каждый красный узел имеет 2 черных потомка
//        3. все пути от узла(корня) до листьев должны иметь одинаковое количество черных узлов

//        User user1 = new User(1, "Вася");
//        User user2 = new User(2, "Саша");
//        User user3 = new User(3, "Женя");
//        Map<Integer, User> userTreeMap = new TreeMap<>();
//        userTreeMap.put(1, user1);
//        userTreeMap.put(2, user2);
//        userTreeMap.put(3, user3);
//        System.out.println(userTreeMap);


        // чтобы сортировать TreeSet, то нужно реализовывать интерфейс Comparable!
//        TreeSet<User> treeSet = new TreeSet<>();
//        treeSet.add(user1);
//        treeSet.add(user2);
//        treeSet.add(user3);
//        System.out.println(treeSet);

//                Map<Integer, String> hashMap = new HashMap<>();
//        hashMap.put(1,"Elem 1");
//        hashMap.put(2,"Elem 2");
//        hashMap.put(7,"Elem 7");
//        hashMap.put(11,"Elem 11");
//        hashMap.put(15,"Elem 15");
//        hashMap.put(23,"Elem 23");
//        System.out.println("hashMap= " + hashMap);
//
//        TreeMap<Integer, String > treeMap1 = new TreeMap<>(hashMap);
//        System.out.println("treeMap= " + treeMap1);
//        System.out.println(hashMap.keySet());
//        System.out.println(treeMap1.keySet());
//        System.out.println(hashMap.values());
//        System.out.println(treeMap1.values());





























    }



}
