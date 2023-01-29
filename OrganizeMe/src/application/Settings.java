package application;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ColorPicker;
import javafx.stage.Stage;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.sql.SQLException;

public class Settings extends Nav{
    @FXML private ColorPicker  homeBackgroundColor, trackerBackgroundColor, calendarBackgroundColor, noteBackgroundColor, reminderBackgroundColor, settingsBackgroundColor;
    @FXML private Button applyBackgroundColorButton;

    private Database database = new Database();
    private CustomColors customColor = new CustomColors();


    public void toLogin(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("Login.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    public void toColors(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("Settings_Colors.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    public void backPage(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("Settings.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void setBackgroundColor(ActionEvent event) throws IOException, SQLException {
        BufferedReader reader = new BufferedReader(new FileReader("UserLog.txt"));
        String read = String.valueOf(reader.readLine());
        reader.close();

        System.out.println("User from Reader: " + read);

        String homeColor = String.valueOf(homeBackgroundColor.getValue());
        String trackerColor = String.valueOf(trackerBackgroundColor.getValue());
        String calendarColor = String.valueOf(calendarBackgroundColor.getValue());
        String noteColor = String.valueOf(noteBackgroundColor.getValue());
        String reminderColor = String.valueOf(reminderBackgroundColor.getValue());
        String settingsColor = String.valueOf(settingsBackgroundColor.getValue());
        String username = String.valueOf(read);

        System.out.println("Backgrounds saved to: " + username);

        //custonColor.setUsername(username);
        customColor.setHomeColor(homeColor);
        customColor.setTrackerColor(trackerColor);
        customColor.setCalendarColor(calendarColor);
        customColor.setNoteColor(noteColor);
        customColor.setReminderColor(reminderColor);
        customColor.setSettingsColor(settingsColor);

        database.connectDatabase();
        if (username.equals("maya33")) { //ADD
            String insertSQL = "INSERT INTO Settings_Colors(ID, Username, HomeColor, TrackerColor, CalendarColor, NoteColor, ReminderColor, SettingsColor) "
                    + "VALUES (?,?,?,?,?,?,?,?)";
            database.updatefield = database.connection.prepareStatement(insertSQL);
            database.updatefield.setInt(1, 2);
            database.updatefield.setString(2, username);
            database.updatefield.setString(3, homeColor);
            database.updatefield.setString(4, trackerColor);
            database.updatefield.setString(5, calendarColor);
            database.updatefield.setString(6, noteColor);
            database.updatefield.setString(7, reminderColor);
            database.updatefield.setString(8, settingsColor);
            database.updatefield.executeUpdate();
            System.out.println("ADDED");
        }
        else { //UPDATE
            String updateSQL = "UPDATE Settings_Colors " + "SET HomeColor = ?," + "TrackerColor = ?, "  + "CalendarColor = ?, " + "NoteColor = ?, " + "ReminderColor = ?, " + "SettingsColor = ? "
                    + "WHERE Username = " + username;
            database.updatefield = database.connection.prepareStatement(updateSQL);
            database.updatefield.setString(1, homeColor);
            database.updatefield.setString(2, trackerColor);
            database.updatefield.setString(3, calendarColor);
            database.updatefield.setString(4, noteColor);
            database.updatefield.setString(5, reminderColor);
            database.updatefield.setString(6, settingsColor);
            database.updatefield.executeUpdate();
            System.out.println("UPDATED");
        }
        database.closeConnection();
        database.closeResultset();
        database.closeStatement();
        database.closeUpdatefield();
    }

    public void connection(ActionEvent event) throws IOException, SQLException {
        database.connectDatabase();
        System.out.println("Database Connected");
    }


}
