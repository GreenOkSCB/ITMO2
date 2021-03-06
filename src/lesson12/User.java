package lesson12;

public class User implements Comparable {
    int id;
    String name;

    public User(int id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        User user = (User) o;

        if (id != user.id) return false;
        return name != null ? name.equals(user.name) : user.name == null;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }

    public String getName() {
        return name;
    }

//    @Override
//    public int compareTo(User o) {
//        return name.length() - o.name.length();
//    }

    @Override   // чтобы сортировать TreeSet, то нужно реализовывать интерфейс Comparable!
    public int compareTo(Object o) {
        return id;  // прописываем способ сравнения: по id, или по name



    }
}
