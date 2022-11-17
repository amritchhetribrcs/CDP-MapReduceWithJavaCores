package CDP3001.java.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class MySQLConnectivity {
    public static void main(String arg[]) {
        Connection conObj = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conObj = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/cdpdb",
                    "root", "");

            Statement statement;
            statement = conObj.createStatement();
            ResultSet resultSet;
            resultSet = statement.executeQuery(
                    "select * from rdddata");
            while (resultSet.next()) {

                System.out.println(resultSet.getInt(1));
            }
            resultSet.close();
            statement.close();
            conObj.close();
        } catch (Exception exception) {
            System.out.println(exception);
        }
    }
}