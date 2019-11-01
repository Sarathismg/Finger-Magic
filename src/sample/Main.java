package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;

public class Main extends Application {

    static Stage primary;
    static String filePaths[]=new String[5];
    static boolean communicator ;
    static String comString;

    @Override
    public void start(Stage primaryStage) throws Exception{
        primary = primaryStage;
        File f = new File("data.dat");
        if(!f.exists()){
            f.createNewFile();
            FileWriter fw = new FileWriter(f);
            fw.write(" \n \n \n \n \n");
            fw.close();

        }

        BufferedReader fwr = new BufferedReader(new FileReader("data.dat"));
        for(int k=0;k<5;k++){
            filePaths[k]=fwr.readLine();
        }
        fwr.close();

        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        primaryStage.setTitle("Hello World");
        primaryStage.setScene(new Scene(root, 1000, 700));
        primaryStage.show();
    }

    public static void changeScene(Parent rootNew){
        primary.setScene(new Scene(rootNew,1000,700));
        primary.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
