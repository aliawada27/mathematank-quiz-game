package mathématank;

import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;

public class AideController {
//fonction pour le bouton aide
    @FXML
    private Button Retour_Boutton_Aide;
    
     String helppath = "menuAide.wav";
     musicHole soundMenu = new musicHole();
     String filepath = "Mathematank_menu_pricipal_music.wav";
     musicHole musicMenu = new musicHole();
    
//fonction qui sert au retour au menu principal à partir du bouton retour sur la page aide
    @FXML
    void Retour_Pressed(ActionEvent event) throws IOException {
Scene first = null;
Parent root = null;
if(event.getSource()==Retour_Boutton_Aide )
    soundMenu.playSound(helppath);
    musicMenu.switchMusic(filepath);
root = FXMLLoader.load(getClass().getResource("Menu.fxml"));
first = Retour_Boutton_Aide.getScene();
first.setRoot(root); 

}
    
        public static void main(String[] args) {
        
         String helppath = "Mathematank_page_aide_music.wav";

       /* musicHole musicHelp = new musicHole();
        musicHelp.playMusic(helppath);*/
        
        
    }

}


