package lesson11;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;

public class Task10 {
    /* Создать множество чисел(Set<Integer>),
       занести туда 20 различных чисел.
       Удалить из множества все числа больше 10. */
    public static void main(String[] args) {
        Set<Integer> set = new HashSet<>();
        Scanner in = new Scanner(System.in);

        for (int i = 0; i < 10; i++){
            set.add(in.nextInt());
        }

        Iterator<Integer> iterator = set.iterator();   // проходим iterator

        while (iterator.hasNext()){   // двигается по коллекции, до тех пор пока есть hasNext (следующий элемент)
            if (iterator.next() > 10){   // возвращает next элемент
                iterator.remove();   // remove метод iteratora
            }
        }
        System.out.println(set);



    }
}