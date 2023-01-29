package application;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.*;
import java.sql.SQLException;
import java.util.ArrayList;

public class Login{
    @FXML private TextField usernameText, passwordText, createUsernameText, createEmailText, createPasswordText;
    //@FXML private Button loginButton;
    @FXML private Label errorText;
    //@FXML public Label welcomeLabel;

    public Stage stage;
    public Scene scene;
    public Parent root;
    public String userName;
    public CustomColors customColor = new CustomColors();
    public Database database = new Database();
    ArrayList<Users> loginUsers = new ArrayList<>();

    public void login(ActionEvent event) throws IOException, SQLException {
        String username = String.valueOf(usernameText.getText());
        String password = String.valueOf(passwordText.getText());
        try {

            database.connectDatabase();
            database.setRSLogin();

            while (database.resultset.next()) {
                Users user = new Users();
                user.setUserDB_ID(database.resultset.getInt("ID"));
                user.setUserName(database.resultset.getString("Username"));
                user.setUserEmail(database.resultset.getString("Email"));
                user.setUserPassword(database.resultset.getString("Password"));
                loginUsers.add(user);
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        for (int i = 0; i < loginUsers.size(); i++) {
            System.out.println("login UserName: " + loginUsers.get(i).getUserName());
            System.out.println("login UserP: " + loginUsers.get(i).getUserPassword());

            if (loginUsers.get(i).getUserName().equals(username) && loginUsers.get(i).getUserPassword().equals(password)) {
                    try {
                        BufferedWriter writer = new BufferedWriter(new FileWriter("UserLog.txt"));
                        writer.write(username);
                        writer.close();
                        customColor.setUsername1();

                        System.out.println("login User: " + username);
                        System.out.println("get user: " + customColor.getUsername());

                        BufferedReader reader = new BufferedReader(new FileReader("UserLog.txt"));
                        userName = String.valueOf(reader.readLine());
                        reader.close();

                        database.closeConnection();
                        database.closeResultset();
                        database.closeStatement();
                        database.closeUpdatefield();

                        toHome(event);
                        stage.setTitle("Home");

                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
            } else {
                    errorText.setText("Incorrect Username or Password. Please try again.");
            }
        }
    }
    public void createUser(ActionEvent event) throws IOException, SQLException {
        database.connectDatabase();

        String createdUsername = String.valueOf(createUsernameText.getText());
        String createdEmail = String.valueOf(createEmailText.getText());
        String createdPassword = String.valueOf(createPasswordText.getText());


        String insertSQL = "INSERT INTO Login_Info(ID, Username, Email, Password) "
                + "VALUES (?,?,?,?)";
        database.updatefield = database.connection.prepareStatement(insertSQL);
        database.updatefield.setInt(1, 2);
        database.updatefield.setString(2, createdUsername);
        database.updatefield.setString(3, createdEmail);
        database.updatefield.setString(4, createdPassword);
        database.updatefield.executeUpdate();
        System.out.println("ADDED");

        database.closeConnection();
        database.closeResultset();
        database.closeStatement();
        database.closeUpdatefield();

        errorText.setText("Your Account is Created! Please Go Login.");

    }
    public void toHome(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("Home.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();

    }

    /*
    public void pulse(ActionEvent event) {


        try {

            database.connect_to_database();
            database.setResultsetorder();
            new_order.setnullall();

            while (database.resultSet.next()) {
                lastorderstring = database.resultSet.getString("OrderNumber");
            }

            lastordernumber = Integer.parseInt(lastorderstring);
            newordernumber = lastordernumber + 1;
            newordernumber1 = String.valueOf(newordernumber);

            BufferedReader readeremp = new BufferedReader(new FileReader("employee_name.txt"));
            employee_name = readeremp.readLine();
            readeremp.close();
            workerUsername.setText(employee_name);
            orderNumber.setText(newordernumber1);

        } catch (Exception e)
        {
            System.out.print(e);

        }
    }
    */
}
