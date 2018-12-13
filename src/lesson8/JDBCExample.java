package lesson8;

import org.sqlite.JDBC;

import java.sql.*;

public class JDBCExample {  // библиотека, которая позволяет работать с базами данных

    // создать таблицу
    public static void createTable() throws SQLException {
        String sql = "CREATE TABLE IF NOT EXISTS Example (id INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL," +
                "firstColumn TEXT NOT NULL, secondColumn INTEGER NOT NULL);";

        // регистрируем драйвер
        DriverManager.registerDriver(new JDBC());

        try (Connection connection = DriverManager.getConnection("jdbc:sqlite:lesson8.db")) {
            Statement statement = connection.createStatement();
            int row = statement.executeUpdate(sql);
            // метод executeUpdate - создание, удаление, добавление, изменение данных
            System.out.println(row);
        }
    }

    // вставить данные в таблицу
    public static void insertInToTable() throws SQLException {
        String sql = "INSERT INTO Example (firstColumn, secondColumn)" +
                "VALUES ('Value1', 123);";
        try (Connection connection =
                     DriverManager.getConnection("jdbc:sqlite:lesson8.db")) {
            Statement statement = connection.createStatement();
            int row = statement.executeUpdate(sql);
            // метод executeUpdate - создание, удаление, добавление, изменение данных
            System.out.println(row);
        }
    }

    // получить данные из таблицы
    public static void selectData() throws SQLException {
        String sql = "SELECT * FROM Example;";
        try (Connection connection =
                     DriverManager.getConnection("jdbc:sqlite:lesson8.db")) {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            // метод executeQuery - получение данных
            while (resultSet.next()) {
                String str = resultSet.getString("firstColumn");
                int i = resultSet.getInt("secondColumn");
                System.out.println("str = " + str);
                System.out.println("i = " + i);
            }
        }
    }

    public static void main(String[] args) {
        try {
//            JDBCExample.createTable();
//            JDBCExample.insertInToTable();
            JDBCExample.selectData();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
