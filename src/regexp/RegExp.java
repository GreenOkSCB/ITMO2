package regexp;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegExp {

    /* Регулярные выражения */

    public static void main(String[] args) {
        String string = new String("Строка 1 для поиска и замены СИМВОЛОВ");
        String pattern;
        // ^	Соответствует началу строки.
        // $	Соответствует концу строки.
        pattern = "Стр";
        System.out.println("1)" + string.replaceAll(pattern,"*!*"));
        pattern = "[иск]";
        System.out.println("2)" + string.replaceAll(pattern,"*"));
        pattern = "[^иск]";
        System.out.println("3)" + string.replaceAll(pattern,"*"));
        pattern = "\\d";  // ищем цифровой символ
        System.out.println(string.replaceAll(pattern,"*"));
        pattern = "\\D";  // ищем НЕцифровой символ
        System.out.println(string.replaceAll(pattern,"*"));
        pattern = "\\w";  // ищем буквенно-цифровой символ или _
        System.out.println(string.replaceAll(pattern,"*"));
        pattern = "\\W";  // ищем НЕ буквенно-цифровой символ или _
        System.out.println(string.replaceAll(pattern,"*"));
        pattern = "\\s";  // ищем любой пробельный символ
        System.out.println(string.replaceAll(pattern,"*"));
        pattern = "\\S";  // ищем любой НЕ пробельный символ
        System.out.println(string.replaceAll(pattern,"*"));
        pattern = "[а-яё]";
        System.out.println(string.replaceAll(pattern,"*"));
        pattern = "[А-ЯЁ]";
        System.out.println(string.replaceAll(pattern,"*"));
        pattern = "[А-Я0-9]";
        System.out.println("11) " + string.replaceAll(pattern,"*"));

//        Pattern | Matcher
        string = "String B1 to search and replace CHARS";
        string = "Str";
        Pattern pattern1 = Pattern.compile(".{6}");    // заданный шаблон
        // . означает все символы,причем подряд,
        // в фигурных скобках первое число сколько повторений,
        // а второе до какого повторения, если второе число не указано,
        // то значит до конца
        pattern1 = Pattern.compile("                (?=.*\\d)      (?=.*[a-z])      (?=.*[A-Z])         .{8,}");
// ели не находит что то одно, то выдает false    ищет цифры     все строчные     все прописные       символы,не мене 8
        Matcher matcher = pattern1.matcher(string);     // заданная строка
        System.out.println(matcher.find());  // true , false  // ищет совпадения по заданному шаблону в заданной строке
        System.out.println(matcher.matches());  // true , false  // ищет полное совпадения по заданному шаблону в заданной строке

    }
}
