package lesson14;

import java.util.Arrays;

public class ExceptionExample {
    public static void main(String[] args) {
        int[] arr = new int[5];
//        arr[10] = 23; // ArrayIndexOutOfBoundsException   пытаемся обратиться к 10 объекту массива, хотя массив длиной 5
        System.out.println(Arrays.toString(arr));

        String str = null;  // обращение к null ссылке
//        str.equals("some string");  // NullPointerException

        int a = 9;
        int b = 0;
//        System.out.println(a / b);  // ArithmeticException  деление на ноль

//        Integer.parseInt("abc");  // NumberFormatException

        // выбросить свое исключение
//        throw new NumberFormatException("NFE");

        /* обработка исключений  */
        // try  - потенциально опасный блок
        // catch - обработка исключения

        Object data = "42";
//        Integer intData = (Integer) data;  // ClassCastException

        try {
            Integer intData = (Integer) data;  // опасный блок помещаем в try
            System.out.println("code after ClassCastException"); // сюда программа не дойдет, а поймав ошибку перейдет в catch
        }
//        catch (ClassCastException e){     // указываем ошибку которую ловим
//            System.out.println("exception" + e.getMessage());   // выводим сообщение об ошибке
//        }
//        catch (NullPointerException e){     // можно указать несколько блоков catch
//            System.out.println("exception" + e.getMessage());
//        }
        catch (ClassCastException | ArrayIndexOutOfBoundsException e) { // можно указать сгруппировать с помощью и |
            System.out.println("exception " + e.getMessage());
        }
//        catch (RuntimeException e){  // можно указать родителя, тогда обработаются все наследники
//            System.out.println("exception" + e.getMessage());
//        }
        finally {  // закрывает код, если в try открывались какие либо ресурсы, базы данных
            System.out.println("finally");  // высвобождение ресурсов
        }
        System.out.println("code after try-catch");  // программа прошла место ошибки, сообщив о ней, и работает далее

        /* checked exception */
//        try {
//            throw new Exception("checked exception");
//        } catch ( Exception e){
//            e.printStackTrace();
//        }
        try {
            voidWithException();
        } catch (Exception e) {
//            e.printStackTrace();
        }
        if (a < 9) {
            throw new UncheckedException("Some message UncheckedException");
        }
//        throw new CheckedException("Ты обязан обработать эту ошибку!");



    }
    public  static void voidWithException() throws Exception{
        throw new Exception("checked exception");
    }
}
