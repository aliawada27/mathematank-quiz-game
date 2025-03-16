/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mathématank;

import java.io.IOException;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

/**
 *
 * @author momo
 */
//changement de la scene pour celle du menu et du mode de jeu
public class Mathématank extends Application {
    
    @Override
    public void start(Stage primaryStage) throws IOException {
            
            Parent root = FXMLLoader.load(getClass().getResource("Menu.fxml"));
        
               
        Scene scene = new Scene(root,800,773);
        
        primaryStage.setTitle("Menu Mathématank");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
         String filepath = "Mathematank_menu_pricipal_music.wav";

        musicHole musicMenu = new musicHole();
        musicMenu.playMusic(filepath);
        
        
        launch(args);
    }
    
    
}
