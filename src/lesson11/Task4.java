package lesson11;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Task4 {
    /*  Ввести с клавиатуры 5 слов в список строк.
        Удалить 3 - ий элемент списка, и вывести
        оставшиеся элементы в обратном порядке.*/
    public static void main(String[] args) {
        List<String> list = new ArrayList<>(5);
        Scanner in = new Scanner(System.in);
        list.add(in.nextLine());
        list.add(in.nextLine());
        list.add(in.nextLine());
        list.add(in.nextLine());
        list.add(in.nextLine());
        list.remove(2);   // удаляем по индексу 2

        for (String s : list){   // печатаем список
            System.out.print(s + " ");
        }
        System.out.println();

        for (int i = list.size(); i >= 0; i--){     // указываем, что i начинается с максимального значения коллекции
            System.out.print(list.get(i) + " ");   // начинаем печатать список с конца
        }

    }

}
