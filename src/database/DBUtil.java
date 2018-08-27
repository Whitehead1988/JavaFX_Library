package database;

import com.sun.rowset.CachedRowSetImpl;

import java.sql.*;

public class DBUtil {

    private static final String connectionPath = "jdbc:sqlite:sample.db";
    private static Connection connection = null;

    public void connect() throws SQLException {
        try {
            connection = DriverManager.getConnection("jdbc:sqlite:sample.db");
        } catch (SQLException e) {
            System.out.println("Connection Failed!");
            e.printStackTrace();
            throw e;
        }
    }

    public void disconnect() throws SQLException {
        try {
            if(connection != null && connection.isClosed()==false){
                connection.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw e;
        }
    }

    public ResultSet executeQuery(String queryStmt) throws SQLException {
        Statement stmt = null;
        ResultSet resultSet = null;
        CachedRowSetImpl cachedRowSetImpl = null;
        try {
            connect();
            stmt = connection.createStatement();
            resultSet = stmt.executeQuery(queryStmt);
            cachedRowSetImpl = new CachedRowSetImpl();
            cachedRowSetImpl.populate(resultSet);
        } catch (SQLException e) {
            System.out.println("Problem found during update execution!");
            e.printStackTrace();
        } finally {
            if (resultSet != null){
                resultSet.close();
            }
            if (stmt != null){
                stmt.close();
            }
            disconnect();
        }
        return cachedRowSetImpl;
    }

    public void executeUpdate(String queryStmt) throws SQLException {
        Statement stmt =null;
        try {
            connect();
            stmt = connection.createStatement();
            stmt.executeUpdate(queryStmt);
        } catch (SQLException e) {
            System.out.println("Problem found during update execution!");
            e.printStackTrace();
        } finally {
            if (stmt != null){
                stmt.close();
            }
            disconnect();
        }
    }

}
