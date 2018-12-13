package lesson9;

import lesson9.classes.Book;
import lesson9.classes.Car;
import lesson9.classes.ChildBook;
import lesson9.storage.Storage;

public class Main {


        public static void main(String[] args) {
            Book tails = new Book("Сказки", 500);
            Book flowers = new Book("Цветы", 600);

            Car car = new Car("green", 1000);

            Storage<Book> bookStorage = new Storage<>();
            bookStorage.add(tails);
            bookStorage.add(flowers);
//            bookStorage.add(car);

            // ClassCastException возникает на моменте исполнения
//            Book bookFromStorage = (Book) bookStorage.get(2); //приводить типы не нужно, так как использованы generic
            Book bookFromStorage = bookStorage.get(2);
            System.out.println(bookFromStorage);

            Storage<ChildBook> childBookStorage = new Storage<>();
            ChildBook bears = new ChildBook("Маша и медведи", 200,"pic");
            ChildBook coloring = new ChildBook("Coloring",100,"pic");
            childBookStorage.add(bears);

//            Book firstBook = getFirstBook(bookStorage);
//            Book firstBook = getFirstBook(childBookStorage);
            Book firstBook = getFirstBook(childBookStorage);

        }
//        public static Book getFirstBook(Storage<Book> storage){
//            return storage.get(0);
//        }

    public static Book getFirstBook(Storage<? extends Book> storage){  // возможность работать со всеми его (Book) потомками
//            Book b = new Book("book",10);                           // только get, только получить, не add, не добавить
//            storage.add(b);
            return storage.get(0);
    }
    // super
    public static void  addToStorage(Storage<? super Book> storage){   // через super можно добавлять
            Book book = new Book("book", 10);
            storage.add(book);

//            Book b = storage.get(0);      // нельзя получить
            Object b = storage.get(0);      // только через Object, но Object ничего не знает о характеристиках
            System.out.println(b);
    }




    }