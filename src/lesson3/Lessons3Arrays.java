package lesson3;

import java.util.Arrays;

public class Lessons3Arrays {
    public static void main(String[] args) {
        int [] arr;     //объявление переменноц массива
        int arr1[];     // тоже самое
        arr = new int[12];
        System.out.println(Arrays.toString(arr));
        System.out.println(arr.length);
        int a = 90;
        int[] arr3 = {2, 12, 49, 77, 456, a};  //наполнение массива значениями при инициализации
        System.out.println(Arrays.toString(arr3));
        System.out.println(arr3.length);

        /*  доступ к элементам массива */
        System.out.println(arr3[2]);
        System.out.println(arr3[2+2]);
//        System.out.println(arr3[7]);  //ArrayIndexOutOfBoundsException:
        arr3[1] = 123;
        System.out.println(Arrays.toString(arr3));

        /*  arr  */
        for (int i = 0; i < arr.length; i++){
            arr[i] = i + 10;
        }
        System.out.println(Arrays.toString(arr));

        /*    копирование массива    */
        int [] arr4 = {2, 6, 8, 3, 8, 3};
        System.out.println(Arrays.toString(arr4));

        int [] arr5 = arr4;    // не копирование массива, а теперь две ссылки на один массив

        int [] cloneArr4 = arr4.clone();        // полная копия массива
        System.out.println(Arrays.toString(cloneArr4));
        /* System.arraycopy(srcArr,    int srcPos,      destArr,     int destPos,               int lenght);
         *                  откуда,  с какой позиции,    куда ,     начиная с какой позиции, какую длину копировать */

        int [] arr6 = new int[10];
        System.arraycopy(arr4, 0, arr6, 2, 4);
        System.out.println(Arrays.toString(arr6));

        int[] copyArr4 = Arrays.copyOf(arr4, 3);
        System.out.println(Arrays.toString(copyArr4));

        int[] copyRangeArr4 = Arrays.copyOfRange(arr4,1,3 ); // включая 3
        System.out.println(Arrays.toString(copyRangeArr4));

        arr4 = new int []{2, 6, 8, 3, 8, 3, 98}; // переопределение массива

        /*  перебор значений массива в цикле */
        /* в цикле for    */
        for (int i = 0; i <arr4.length; i++){     // копируем массив и перебираем его, чтобы изменить
            arr4[i] += 100;
        }
        System.out.println(Arrays.toString(arr4));

        /*   */
        for (int num: arr4){            // переменная num одна, при каждой итерации в нее перезаписывается новое значение
            System.out.println("num = " + num);    // получаем данные из массива
        }

        /* сравнение массивов   */
        arr4 = new int[]{2, 6, 8, 3, 8, 3, 98};
        arr5 = new int[]{2, 6, 8, 3, 8, 3, 98};
        System.out.println(arr4 == arr5);   // нельзя сравнивать массивы
        System.out.println(arr4.equals(arr5));       // нельзя сравнивать массивы

        System.out.println(Arrays.equals(arr4, arr5));  // метод сравнения, если равна и длина и элементы, то true

        int[] arr7 = new int[14];
        Arrays.fill(arr7, 223);   //   наполняет массив указанными значениями
        System.out.println(Arrays.toString(arr7));

        /* сортировка массива */
        arr7 = new int[]{34, 1, -90, 45, 72};
        System.out.println(Arrays.toString(arr7));
        Arrays.sort(arr7, 1, 4);
        System.out.println(Arrays.toString(arr7));
        Arrays.sort(arr7);
        System.out.println(Arrays.toString(arr7));

        /* поиск в массиве */
        System.out.println(Arrays.binarySearch(arr7, 2));










    }
}
