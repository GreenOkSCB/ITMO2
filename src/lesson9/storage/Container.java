package lesson9.storage;

public class Container<T> {
    T element;

    Container next;

    public Container(T element) {
        this.element = element;
    }
}
