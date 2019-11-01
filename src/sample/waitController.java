package sample;

import javafx.animation.PauseTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;
import javafx.stage.Window;
import javafx.util.Duration;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class waitController implements Initializable {

    @FXML
    private TextArea tarea;

    @FXML
    private Button cancelButton;

    private int s=1;

    @FXML
    void cancelAction(ActionEvent event) {
        Main.communicator=false;
        s=0;
        Parent root = null;
        try {
            root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        Main.changeScene(root);
    }

    @FXML
    void dd0606(ActionEvent event) {

    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        tarea.setText(Main.comString);
        s=1;
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        //if(s==1) {
        change();
    }

    void change(){
        s=0;
        Parent root1 = null;
        try {
            root1 = FXMLLoader.load(getClass().getResource("sample.fxml"));
            System.out.println("he!!!!");
        } catch (IOException e) {
            e.printStackTrace();
        }
        Main.changeScene(root1);
    }
}
