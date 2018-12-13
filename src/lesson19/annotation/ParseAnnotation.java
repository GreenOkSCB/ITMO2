package lesson19.annotation;

import java.lang.reflect.AnnotatedType;

public class ParseAnnotation {

    public static void main(String[] args) {

        User user = new User(User.Permission.ADMIN);

        Class<?> actionClass = DeleteAction.class;

        PermissionRequired permissionRequired = actionClass.getAnnotation(PermissionRequired.class);

        if (permissionRequired != null){
            if (user.getPermission().equals(permissionRequired.value())){
                System.out.println("Пользователю доступно удаление");
            }
        }
    }
}

// написать релексивный toString
// написать небольшой Dependency Injection FrameWork

// Всю логику можно собрать в обном классе DIContext
// благодаря которму можно создавать экземпляр любого класса
// с автоматическими установленными зависимостями
