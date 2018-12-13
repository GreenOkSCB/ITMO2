package lesson19.annotation;

// данный класс должны использовать
//User.Permission.ADMIN
// использование

@PermissionRequired(User.Permission.ADMIN)
public class DeleteAction {
    public void DeleteAction(User user){
        System.out.println("del user");
    }

}
