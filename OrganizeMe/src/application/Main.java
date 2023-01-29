package application;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
//import javafx.scene.image.Image;

public class Main extends Application {
    @Override
    public void start(Stage stage)
    {
        try {
            //Database database =  new Database();
            //database.connect_to_database();
            Parent root = FXMLLoader.load(getClass().getResource("Login.fxml"));
            //Parent root = FXMLLoader.load(getClass().getResource("Home.fxml"));
            Scene scene = new Scene(root,390,844);//(root,1920,1030);
            //Image icon= new Image("food.png");
            //stage.getIcons().add(icon);
            stage.setTitle("Login");
            stage.setScene(scene);
            stage.show();
            //stage.setFullScreen(true);
        }
        catch(Exception e)
        {

            //SceneController controller = new SceneController();
            //controller.showfailedScreen("Could not open login screen");
            System.out.println("Could not open login screen");
        }
    }
}
