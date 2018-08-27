package database.DAO;

import app.controller.BooksPageController;
import database.DBUtil;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.ResultSet;
import java.sql.SQLException;

public class BookDAO {

    public static void insertBook(Book book){
        String quertyStmt =
                "insert into book\n" +
                "(RATE, AUTHOR, TYPE, DESCRIPTION, TITLE, date)\n" +
                "values\n" +
                "(\"" + book.getRate() + "\", \""+ book.getAuthor() +"\", \""+ book.getType() +"\", \""+ book.getDescription() +
                "\", \""+ book.getTitle() +"\", \""+ book.getDate() +"\");";
        try {
            DBUtil.executeUpdate(quertyStmt);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static ObservableList<BooksPageController.Book> searchBooks() throws SQLException {
        String selectQuery = "SELECT * FROM book";

        try {
            ResultSet resultSet = DBUtil.executeQuery(selectQuery);
            ObservableList<BooksPageController.Book> booksList = getBooksList(resultSet);
            return booksList;
        } catch (SQLException e) {
            e.printStackTrace();
            throw e;
        }
    }

    private static ObservableList<BooksPageController.Book> getBooksList(ResultSet resultSet) throws SQLException {
        ObservableList<BooksPageController.Book> booksList = FXCollections.observableArrayList();

        while(resultSet.next()){

            BooksPageController.Book book = new BooksPageController.Book(resultSet.getString("author"), resultSet.getString("date"), resultSet.getString("description"),
                    resultSet.getString("rate"), resultSet.getString("title"), resultSet.getString("type"));
//            book.setAuthor(resultSet.getString("author"));
////            book.setDate(new LocalDate(resultSet.getDate("date")).getMonth());
//            book.setDate(LocalDate.now());
//            book.setDescription(resultSet.getString("description"));
//            book.setRate(resultSet.getString("rate"));
//            book.setTitle(resultSet.getString("title"));
//            book.setType(resultSet.getString("type"));
            booksList.add(book);
        }

        return booksList;
    }
}
