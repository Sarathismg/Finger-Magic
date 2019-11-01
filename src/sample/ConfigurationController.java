package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.FileChooser;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class ConfigurationController implements Initializable{

    @FXML
    private TextField finger1Field;

    @FXML
    private Button finger4Browse;

    @FXML
    private Button cancelButton;

    @FXML
    private Button finger3Browse;

    @FXML
    private Button finger1Browse;

    @FXML
    private TextField finger2Field;

    @FXML
    private TextField finger5Field;

    @FXML
    private Button finger2Browse;

    @FXML
    private Button finger5Browse;

    @FXML
    private Button okayButton;

    @FXML
    private TextField finger3Field;

    @FXML
    private TextField finger4Field;

    @FXML
    void f20707(ActionEvent event) {

    }

    @FXML
    void da2020(ActionEvent event) {

    }


    @FXML
    void eed3d3(ActionEvent event) {

    }

    @FXML
    void d3b7b7(ActionEvent event) {

    }

    @FXML
    void finger1BrowseAction(ActionEvent event) {
        FileChooser fileChooser = new FileChooser();
        File f= fileChooser.showOpenDialog(null);
        finger1Field.setText(f.getAbsolutePath());
    }

    @FXML
    void finger2BrowsweAction(ActionEvent event) {
        FileChooser fileChooser = new FileChooser();
        File f= fileChooser.showOpenDialog(null);
        finger2Field.setText(f.getAbsolutePath());
    }

    @FXML
    void finger3BrowseAction(ActionEvent event) {
        FileChooser fileChooser = new FileChooser();
        File f= fileChooser.showOpenDialog(null);
        finger3Field.setText(f.getAbsolutePath());
    }

    @FXML
    void finger4BrowseAction(ActionEvent event) {
        FileChooser fileChooser = new FileChooser();
        File f= fileChooser.showOpenDialog(null);
        finger4Field.setText(f.getAbsolutePath());
    }

    @FXML
    void finger5BrowseAction(ActionEvent event) {
        FileChooser fileChooser = new FileChooser();
        File f= fileChooser.showOpenDialog(null);
        finger5Field.setText(f.getAbsolutePath());
    }

    @FXML
    void okayAction(ActionEvent event) {
        File f = new File("data.dat");
        f.delete();
        f= new File("data.dat");
        try {
            f.createNewFile();
            FileWriter fwr = new FileWriter(f);
            Main.filePaths[0]=finger1Field.getText();
            Main.filePaths[1]=finger2Field.getText();
            Main.filePaths[2]=finger3Field.getText();
            Main.filePaths[3]=finger4Field.getText();
            Main.filePaths[4]=finger5Field.getText();
            for(int k=0;k<5;k++){
                fwr.write(Main.filePaths[k]+"\n");
            }
            fwr.close();
            cancelAction(event);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    void cancelAction(ActionEvent event) {
        Parent root = null;
        try {
            root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        Main.changeScene(root);
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        finger1Field.setText(Main.filePaths[0]);
        finger2Field.setText(Main.filePaths[1]);
        finger3Field.setText(Main.filePaths[2]);
        finger4Field.setText(Main.filePaths[3]);
        finger5Field.setText(Main.filePaths[4]);

    }
}

