package sample;

import javafx.animation.PauseTransition;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.*;
import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;

import static java.lang.System.exit;
import static java.lang.System.setOut;

public class Controller implements Initializable {

    private Process p;
    private boolean control;
    private int  marker;



    @FXML
    private Button exitButton;

    @FXML
    private Button deactivationButton;


    @FXML
    private Button experienceButton;

    @FXML
    private Button configurationButton;

    @FXML
    private Label activationStatus;

    @FXML
    private ImageView imageViewer;

    @FXML
    private Button activationButton;

    @FXML
    void f20707(ActionEvent event) {

    }

    @FXML
    void da2020(ActionEvent event) {

    }


    @FXML
    void activationButtonAction(ActionEvent event) {
        imageViewer.setImage(new Image("active.png"));
        activationStatus.setText("        Active");
        if(true) {
            control = true;
            activationButton.setVisible(false);
            deactivationButton.setVisible(true);
            Thread t = new Thread(()->{
                while(control){
                    try {
                        p = Runtime.getRuntime().exec("python gesture.py");
                        try {
                            p.waitFor();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        BufferedReader stdInput = new BufferedReader(new InputStreamReader(p.getInputStream()));
                        int k=stdInput.read();
                        k=k-'1';
                        System.out.println(k);
                        if(k!=-1 && control==true){
                            File f = new File(Main.filePaths[k]);
                            Main.comString=f.getName();
                            Main.communicator=true;
                            Alert alert;
                            p = Runtime.getRuntime().exec("python gesture1.py");
                            waitScreen();

                            p.waitFor();
                            /**/
                            //Thread.sleep(3000);
                            BufferedReader stdInput1 = new BufferedReader(new InputStreamReader(p.getInputStream()));
                            int k1=1;
                            int m;
                            m=stdInput1.read();
                            System.out.println(m);
                            k1=m-'1';
                            System.out.println("ke;"+k1);
                            if(k1 == 1)
                                Main.communicator = true;
                            else if(k1 == 2)
                                Main.communicator = false;

                            if(Main.communicator) {
                                runProgram(k);
                                System.out.println("running!!!!");
                            }
                            Thread.sleep(5000);
                        }


                    } catch (Exception e) {
                        e.printStackTrace();
                    }

                }
            }
            );
            t.setDaemon(true);
            t.start();
        }
    }


    @FXML
    void eed3d3(ActionEvent event) {

    }

    @FXML
    void c7d3f0(ActionEvent event) {

    }

    @FXML
    void configurationButtonAction(ActionEvent event) {
        if(control)
            deactivationButtonAction(event);
        Parent root = null;
        try {
            root = FXMLLoader.load(getClass().getResource("configurationButton.fxml"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        Main.changeScene(root);

    }

    @FXML
    void experienceButtonAction(ActionEvent event) {

    }

    @FXML
    void exitButtonAction(ActionEvent event) {
        if(control != false)
            deactivationButtonAction(event);
        exit(1);
    }

    @FXML
    void deactivationButtonAction(ActionEvent event) {
        imageViewer.setImage(new Image("inactive.jpg"));
        activationStatus.setText("       Inactive");
        control = false;
        p.destroyForcibly();
        deactivationButton.setVisible(false);
        activationButton.setVisible(true);
    }

    void runProgram(int k) {
        try {
            File f = new File("temp.bat");
            f.createNewFile();
            FileWriter fwr = new FileWriter(f);
            fwr.append('\"');
            fwr.append(Main.filePaths[k]);
            fwr.append('\"');
            fwr.close();
            Process m = new ProcessBuilder("temp.bat").start();
        } catch (IOException e) {
            e.printStackTrace();
            Parent root;
            /*try {
                root = FXMLLoader.load(getClass().getClassLoader().getResource("path/to/other/view.fxml"), resources);
                Stage stage = new Stage();
                stage.setTitle("My New Stage Title");
                stage.setScene(new Scene(root, 450, 450));
                stage.show();
                // Hide this current window (if this is what you want)
                //((Node)(event.getSource())).getScene().getWindow().hide();
            }
            catch (IOException ee) {
                ee.printStackTrace();
                ee.printStackTrace();
            }*/
        }
    }

    void waitScreen(){




        Platform.runLater(
                () -> {
                    /*Parent root = null;
                    try {
                        root = FXMLLoader.load(getClass().getResource("waitScreen.fxml"));
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    Main.changeScene(root);*/
                    ButtonType OK1 = new ButtonType("CANCEL", ButtonBar.ButtonData.CANCEL_CLOSE);
                    ButtonType CANCEL1 = new ButtonType("OK", ButtonBar.ButtonData.OK_DONE);

                    Alert alert=new Alert(Alert.AlertType.CONFIRMATION,"",OK1,CANCEL1);
                    alert.getButtonTypes().clear();
                    alert.getButtonTypes().addAll(OK1,CANCEL1);
                    alert.setTitle("Starting...");
                    PauseTransition delay = new PauseTransition(Duration.seconds(4));
                    marker = 0;
                    delay.setOnFinished( event ->{ alert.hide(); marker =1; });
                    delay.play();
                    //alert.setHeaderText("This is a test.");
                    alert.setResizable(false);
                    alert.setContentText("Starting app: "+Main.comString);
                    Optional<ButtonType> result = alert.showAndWait();
                    ButtonType button = result.orElse(ButtonType.CANCEL);
                    if(result.isPresent()) {
                        if(result.get()==CANCEL1){

                        }
                        else if (result.get() == OK1) {
                            if(marker ==0) {
                                System.out.println("cancelled");
                                Main.communicator = false;
                            }
                        }
                    }

                }
        );

    }


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        imageViewer.setImage(new Image("inactive.jpg"));
    }
}

