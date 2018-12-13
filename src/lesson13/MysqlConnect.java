package lesson13;

//import org.sqlite.JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class MysqlConnect {
    static String connectUrl = "jdbc:mysql://localhost:3306/dbname";
    static String  user = "root";
    static String password = "pwd";
    public static void createTable() throws SQLException, ClassNotFoundException {
        String sql = "CREATE TABLE IF NOT EXISTS Example (id INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL," +
                "firstColumn TEXT NOT NULL, secondColumn INTEGER NOT NULL);";

        // регистрируем драйвер
//        DriverManager.registerDriver(new JDBC());
        Class.forName("com.mysql.jdbc.Driver");

        try (Connection connection = DriverManager.getConnection
                (connectUrl,         //"jdbc:mysql://localhost:3306/dbname",
                 user,               //"root",
                 password)){           //"pwd")) {
            Statement statement = connection.createStatement();
            int row = statement.executeUpdate(sql);
            // метод executeUpdate - создание, удаление, добавление, изменение данных
            System.out.println(row);
        }
    }

    public static void main(String[] args) throws SQLException, ClassNotFoundException{
        createTable();

    }
    

}
