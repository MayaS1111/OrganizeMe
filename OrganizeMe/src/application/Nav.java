package application;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.IOException;

public class Nav extends Login {
    @FXML private ImageView pageImage;
    @FXML private Label pageLabel;
    @FXML private Pane navPane;
    //@FXML private ImageView navImage, homeImage, trackerImage, calendarImage, noteImage, reminderImage, settingsImage;
    @FXML private Button navButton, homeButton, trackerButton, calendarButton, noteButton, reminderButton, settingsButton;

    private String navButtonState;
    private int navInt = 0;
    private int  navEvenOdd;


    public void navPaneControl(ActionEvent event) {

        navInt++;
        navEvenOdd = navInt % 2;
        if(navEvenOdd==1){
            navButtonState="Open";
            navPane.setVisible(true);
            //System.out.println("Nav State: " + navButtonState);
        }
        else{
            navButtonState="Closed";
            navPane.setVisible(false);
            //System.out.println("Nav State: " + navButtonState);
        }
    }
    public void navButtonControl(ActionEvent event) throws IOException {
        if(homeButton.isArmed()==true){
            root = FXMLLoader.load(getClass().getResource("Home.fxml"));
        }
        else if(trackerButton.isArmed()==true){
            root = FXMLLoader.load(getClass().getResource("Tracker.fxml"));
        }
        else if(calendarButton.isArmed()==true){
            root = FXMLLoader.load(getClass().getResource("Calendar.fxml"));
        }
        else if(noteButton.isArmed()==true){
            root = FXMLLoader.load(getClass().getResource("Note.fxml"));
        }
        else if(reminderButton.isArmed()==true){
            root = FXMLLoader.load(getClass().getResource("Reminder.fxml"));
        }
        else if(settingsButton.isArmed()==true){
            root = FXMLLoader.load(getClass().getResource("Settings.fxml"));
        }

        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }


}
