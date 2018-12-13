package lesson8;

import org.sqlite.JDBC;

import java.sql.*;
import java.util.Arrays;

public class BookHandler {
    public static void createTable() throws SQLException {
        String sql = "CREATE TABLE IF NOT EXISTS Book (id INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL," +
                "title TEXT NOT NULL, pages INTEGER NOT NULL);";

        // регистрируем драйвер
        DriverManager.registerDriver(new JDBC());

        try (Connection connection = DriverManager.getConnection("jdbc:sqlite:lesson8.db")) {
            Statement statement = connection.createStatement();
            int row = statement.executeUpdate(sql);
            System.out.println(row);
        }
    }

    public static void insertInToTable(Book book) throws SQLException {
        String sql = "INSERT INTO Book (title, pages)" +
                "VALUES (?, ?);";
        try (Connection connection =
                     DriverManager.getConnection("jdbc:sqlite:lesson8.db")) {
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, book.getTitle());
            statement.setInt(2, book.getPages());
            int row = statement.executeUpdate(sql);
            System.out.println(row);
        }
    }
    public static Book[] selectData(int id) throws SQLException {
//        String sql = "SELECT * FROM Book WHERE id = ?;";
        String sql = "SELECT * FROM Book;";
        try (Connection connection =
                     DriverManager.getConnection("jdbc:sqlite:lesson8.db")) {
            PreparedStatement statement = connection.prepareStatement(sql);
//            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery(sql);
            Book[] books = new Book[3];
            for(int i = 0; resultSet.next(); i++){
                Book book = new Book();
                book.setTitle(resultSet.getString("title"));
                book.setPages(resultSet.getInt("pages"));
                books[i] = book;
            }
//            Book book = new Book();
//            while (resultSet.next()) {
//                book.setTitle(resultSet.getString("title"));
//                book.setPages(resultSet.getInt("pages"));
//                String title = resultSet.getString("title");
//                int pages = resultSet.getInt("pages");
//                System.out.println("title = " + title);
//                System.out.println("pages = " + pages);
//            } return book;
            return books;
        }
    }

        public static void main (String[]args){
            Book book1 = new Book("Азбука", 500);
            Book book2 = new Book("Азбука 2", 400);

            try {
//            BookHandler.createTable();
//            BookHandler.insertInToTable(book2);

//                System.out.println(BookHandler.selectData());
                System.out.println(Arrays.toString(BookHandler.selectData(2)));
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
