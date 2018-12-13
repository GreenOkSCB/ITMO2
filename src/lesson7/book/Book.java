package lesson7.book;

import java.util.Objects;
import java.util.Random;
 public class Book{

//    final String CONST;

    private String autor;
    private String title;
    private int pages;

    // static - принадлежит классу НЕ объекту

    public static int soldBook;

    static {
        soldBook = -(new Random().nextInt(100));
    }

    public void sellBook(){
        soldBook++;
    }

    public static String getStatistic(){
        return "Book sold: " + soldBook;
    }



    public Book(String autor, String title) {
        this.autor = autor;
        this.title = title;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setPages(int pages) {
        this.pages = pages;
    }

    @Override
    public String toString() {
        return "Book{" +
                "autor='" + autor + '\'' +
                ", title='" + title + '\'' +
                ", pages=" + pages +
                '}';
    }

    // clone() - возвращает копию объекта
    // getClass()
    // finalize
    // wait()  notify()  notifyAll()
    // equals() - возвращает
    // hashCode - возвращает hashCode объекта


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Book book = (Book) o;
        return pages == book.pages &&
                Objects.equals(autor, book.autor) &&
                Objects.equals(title, book.title);
    }

    @Override
    public int hashCode() {

        return Objects.hash(autor, title, pages);
    }
}
