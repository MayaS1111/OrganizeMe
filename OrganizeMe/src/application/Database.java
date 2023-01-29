package application;


import java.io.IOException;
import java.sql.*;

public class Database {
    Connection connection = null;
    Statement statement = null;
    ResultSet resultset = null;
    PreparedStatement updatefield = null;

    public void connectDatabase() throws IOException, SQLException {
        connection = DriverManager.getConnection("jdbc:ucanaccess://OrganizeMeDatabase.accdb","","");
        statement = connection.createStatement();
        //System.out.println("Database Connected");
    }

    public void setRSLogin() throws IOException {
        try {
            resultset = statement.executeQuery("SELECT * FROM Login_Info");
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void setRSColor() throws IOException {
        try {
            resultset = statement.executeQuery("SELECT * FROM Settings_Colors");
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void closeConnection() {
        try {
            if(null != connection) {
                connection.close();
            }
        }
        catch (SQLException sqlex) {
            sqlex.printStackTrace();
        }
    }
    public void closeUpdatefield() {
        try {
            if(null != updatefield) {
                updatefield.close();
            }
        }
        catch (SQLException sqlex) {
            sqlex.printStackTrace();
        }
    }
    public void closeResultset() {
        try {
            if(null != resultset) {
                resultset.close();
            }
        }
        catch (SQLException sqlex) {
            sqlex.printStackTrace();
        }
    }
    public void closeStatement() {
        try {
            if(null !=  statement) {
                statement.close();
            }
        }
        catch (SQLException sqlex) {
            sqlex.printStackTrace();
        }
    }
}