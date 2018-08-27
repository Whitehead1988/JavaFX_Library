package database.DAO;

import database.DBUtil;

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
}
