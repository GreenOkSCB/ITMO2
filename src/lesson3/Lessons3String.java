package lesson3;

import java.util.Arrays;

public class Lessons3String {
    public static void main(String[] args) {
        String str = "String";
        String str2 = new String("String");

        String str3 = String.format("String %02d", 8);
        System.out.println(str3);

        String str4 = "String String";
        String str5 = "String";     // еще одна ссылка на "String" как в str
        String str6 = "string";

        System.out.println( str == str2);
        System.out.println( str == str5);

        System.out.println(str.equals(str2));
        System.out.println(str.equals(str5));
        System.out.println("------");

        System.out.println(str.equalsIgnoreCase(str6));   // основной метод сравнения
        System.out.println(str.equals(str6));               // основной метод сравнения

        System.out.println(str.startsWith("Qwe"));
        System.out.println(str.endsWith("G"));

        String str10 = "string";
        String str11 = new String("string");
        String str12 = "str";
        String str13 = "String string";

        System.out.println(str10.compareTo(str11));
        System.out.println(str11.compareTo(str12));
        System.out.println(str11.compareTo(str13));
        System.out.println(str11.compareToIgnoreCase(str13));

        String a = "Astring";
        String b = "Bstring";
        String c = "Cstring \n \"cstring\"";   //перенос строки и экранирование вторых кавычек

        String[] strArr = {c, a, b};      // сортировка массива строк
        Arrays.sort(strArr);
        System.out.println(Arrays.toString(strArr));

        System.out.println(a.substring(3));    // взятие подстроки
        System.out.println(c.substring(2, 4));    // взятие подстроки
        System.out.println(a.contains("str"));   // возвращает true, усли искомое найдено

        String[] arr = {"qwe", "rty", "yui"};
        System.out.println();

        String string = "First ";
        String string2 = "Second ";
        string2 += string;
        System.out.println(string2);

        for( int i = 0; i < 10; i++){
            string += string2;
        }
        System.out.println(string);

        /* StringBuffer  | StringBuilder  */
        /* для потоков   | без потоков    */

        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(string);                   // append добавление
        for (int i = 0; i <10; i++){
            stringBuilder.append(" string ").append(" str ");
        }
        System.out.println(stringBuilder.toString());







    }
}
