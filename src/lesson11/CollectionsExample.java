package lesson11;

import java.util.*;

public class CollectionsExample {
    public static void main(String[] args) {

        /*   Java Collectoin Framework
             java.util.Collection */
//        boolean add(E e);
//        boolean remove(Object o);
//        int size();
//        boolean isEmpty();
//        boolean contains(Object o);
//        Object[] toArray[];
//        <T> T[] toArray(T[] a);
//        String[] arr = collectionName.toArray(new String[0])
//        iterator()

        /* List */
//        хранятся все, хранятся в том порядке, в котором положены
//        можно найти по индексу
//        java.util.list
//        предоставляет методы для работы с коллецкией,
//        которая является списком
//        void add(int ind, E obj); добавляет элемент по индексу, на указаную позицию
//        boolean addAll(int ind, Collection<? extends E> col);   можно добавить всю коллекцию

//        int indexOf(Object o);      ищет элемент и возвращает его индекс
//        int lastIndexOf(Object o);
//        E remove(int ind);    удаляет элемент по индексу
//        E set(int index, E obj):     ставит элемент на указаную позицию, если там есть элемент, он его заменяет
//        List<E> subList(int start, int end);      взятие подсписка

        /* ArrayList  */
//        Это класс - динамически расширяемый массив, может хранит любые значения(типы данных), так как является Generic
//        при достижение максимального размера создается еще один, в полтора раза больше
//        его минус - если надо добавить либо удалить элемент из середины, это будет дольше
//        хотя просто довление или удаление происходит быстрее

        ArrayList<String> strList = new ArrayList<>();
//        strList.ensureCapacity(20);  // массив сразу на 20 элементов
//        strList.trimToSize();   //  уменьшить размер массива до кол-ва элементов, если
        strList.add("Elem 1");
        strList.add("Elem 2");
        strList.add(0, "Elem 3");
//        strList.remove(1);  // удаление по индексу
//        strList.remove("Elem 1");  //удаление по значению
        System.out.println(strList.toString());

        /* создание коллекции из массива */
        Integer[] integers = {23, 67, 12, 90};   // массив, его длина не меняется, но!
        ArrayList<Integer> intList = new ArrayList<>(Arrays.asList(integers));      // в коллекцию добавляем массив предыдущий, и можем его уже расширять
        System.out.println(intList.toString());

        // типа данных_________куда записываем_______откуда записываем
        for (Integer             i :                        intList) {
            System.out.print(i + " ");
        }System.out.println();

        Iterator<Integer> iterator = intList.iterator();
        while (iterator.hasNext()){
//            System.out.println("iterator" + iterator.next());
            if (iterator.next() == 12){
                iterator.remove();
            }
        }
        System.out.println(intList.toString());

        /* LinkedList  */
//        Это класс, как и ArrayList, лучше работает с серединой списка
        LinkedList<String> stringLinkedList = new LinkedList<>();
        stringLinkedList.add("String 1");
        stringLinkedList.add("String 2");
        stringLinkedList.add("String 3");
        stringLinkedList.add(1,"String 4");

        for (String  str:  stringLinkedList){
            System.out.println(str);
        }
//        уделание элементов
//        stringLinkedList.poll();   // если элемент не найден, то возвращает null
//        stringLinkedList.pollFirst();    // если элемент не найден, то возвращает null
//        stringLinkedList.remove();    // если элемент не найден, то NoSuchEkementException
//        stringLinkedList.removeFirst();     // если элемент не найден, то NoSuchEkementException

        /* создание массива из коллекции  */
        String[] arr = stringLinkedList.toArray(new String[0]);
        System.out.println(Arrays.toString(arr));

                  /*  Set */
//        хранит только уникальные значения, не хранит дублирующие
//        порядок хранения может отличатся от порядка добавления

        /*  HashSet  */   // самая быстрая по добавление и удалению элементов, а так же посдчету элементов
        /*  SortedSet  ->  TreeSet  */      // элементы (по умолчанию) хранятся в порядке возрастания
        /*  LinkedHashSet  */     // позволяет хранить в том порядке, в котором добавляли, вторая по скорости

        HashSet<String> hashSet = new HashSet<>(); // если добавить массив содержащий дублирующие элементы,
                                                    // то дубли будут проигнорированы, то есть мы создадим
                                                    // коллекцию из уникальных значений
        hashSet.add("Element 1");
        hashSet.add("Element 2");
        hashSet.add("Element 3");
        hashSet.add("Element 3");

        System.out.println(hashSet.toString());

        TreeSet<String> treeSet = new TreeSet<>();
        treeSet.add("Element 2");
        treeSet.add("Element 2");
        treeSet.add("Element 1");
        treeSet.add("Element 3");

        System.out.println(treeSet.toString());

        LinkedHashSet<String> linkedHashSet = new LinkedHashSet<>();
        linkedHashSet.add("Element 2");
        linkedHashSet.add("Element 2");
        linkedHashSet.add("Element 1");
        linkedHashSet.add("Element 3");

        System.out.println(linkedHashSet.toString());





    }
}
