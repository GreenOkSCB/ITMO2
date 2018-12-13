package lesson13;

import java.util.Arrays;

public class EnumExample {
    public static void main(String[] args) {
//        Role guest = Role.GUEST; // создаем роль

        User user = new User(1, "Alex", Role.GUEST);
        User user2 = new User(2, "Mike", Role.ADMIN);
        System.out.println(user);

                    /* можно сделать проверку на роль  */
//        if (user.getRole() == Role.ADMIN){
//            System.out.println("Ok");
//        }
                    /* values вовзращает массив со всеми указанными данными  */
        System.out.println(Arrays.toString(Role.values()));
        for (Role role: Role.values()){
                    /* ordinal() позволяет возвращать порядок ролей */
            System.out.println("Ordinal: " + role.ordinal());
            System.out.println(role);
        }
                    /*  valuesOf() позволяет создать роль через строчку str (ничего не понял...)*/
        String str = "USER";
        Role userRole = Role.valueOf(str);
        User user3 = new User(3, "Peter", userRole);
        System.out.println(user3);

    }
}

class User {
    private int id;
    private String name;
    private Role role;

    public User(int id, String name, Role role) {
        this.id = id;
        this.name = name;
        this.role = role;
    }

    public Role getRole() {
        return role;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", role=" + role +
                '}';
    }
}

enum Role {
    ADMIN{                  // можно сделать метод отдельно для каждого в перечеслении
        public Role adminRole(){
            return ADMIN;
        }

    }, USER, GUEST;

    public Role someRole(){   // можно сделать метод для всего перечисления
        return USER;
    }
}

