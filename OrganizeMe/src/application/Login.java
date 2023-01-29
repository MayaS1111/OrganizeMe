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

public class Login{
    @FXML private TextField usernameText, passwordText;
    //@FXML private Button loginButton;
    @FXML private Label errorText;
    @FXML public Label welcomeLabel;

    public Stage stage;
    public Scene scene;
    public Parent root;
    public String userName;
    public CustomColors customColor = new CustomColors();

    public void login(ActionEvent event) throws IOException {
        String username = String.valueOf(usernameText.getText());
        String password = String.valueOf(passwordText.getText());

        if(username.equals("maya11") && password.equals("1")){
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

                toHome(event);

                stage.setTitle("Home");
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        else {
            errorText.setText("Incorrect Username or Password. Please try again.");
       }
    }
    public void toHome(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("Home.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();

    }
}
