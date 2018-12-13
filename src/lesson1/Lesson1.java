package lesson1;

public class Lesson1 {
    public static void main(String[] args) {
        System.out.println("lesson");

        byte byteVar;   // (8 бит) 128127
        byteVar = 1;

        short shortVar;  // (16 бит) -32767 до 32767
        shortVar = 90;
        short a = 2;
        short b = 3;
        //short c = a + b;  // при математических операция приводится к типу int

        // int (32 бита)
        int intVar = 1_000_000; // 1000000
        int intVar2 = 3;
        int intVar3 = 8;
        int intVar4 = intVar3 / intVar2; // приводит к целому числу
        System.out.println(intVar4);

        // long (64 бита)
        long x = 600_000_000L;

        //типа данных с плавющей точкой
        //   float(32 бит) double(64 бит)
        float floatVar = 0.4F;
        double doubleVar = 0.4;

        boolean isActive = true;
        boolean started = false;

        // приведение типов
        // автоматическое преобразование
//        byte byteNum = 23;
//        int intNum = byteNum;

        // явное приведение типов
//        int intNum = 23;
//        byte byteNum = (byte) intNum;   // в скобках к какому типу хотим привести

        float floatNum = 3.545F;
        int intNum = (int) floatNum;
        System.out.println(intNum);

        // арифметические операторы

        long long1 = 23;
        int int1 = 12;
        int res = (int) long1 + int1;

        System.out.println(1000%375);

        //    -- декремент - уменьшение на 1
        //    ++ инкремент - увеличение на 1
        //    i++    постфикс
        //    ++i    префикс

        //    Операции сравнения - возвращают, либо true, либо false
        //    < > <= >= == !=


    }
}
