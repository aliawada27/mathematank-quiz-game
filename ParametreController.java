package mathématank;

import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;

public class ParametreController {

    @FXML
    private Button Retour_Boutton_Parametre;
    
    @FXML
    private Button boutton_mute_pourDeVrai;
    
    String gotempath = "Ha_got_em.wav";
    String mutepath = "mutingUnmuting.wav";
    musicHole soundMenu = new musicHole();

    //configuration du son qui se mute dans parametre
    @FXML
    void Retour_Pressed(ActionEvent event) throws IOException {
Scene first = null;
Parent root = null;
if(event.getSource()==Retour_Boutton_Parametre )
    soundMenu.playSound(mutepath);
root = FXMLLoader.load(getClass().getResource("Menu.fxml"));
first = Retour_Boutton_Parametre.getScene();
first.setRoot(root); 

}
    @FXML
    void muteMe(ActionEvent event) throws IOException {
    soundMenu.muteMusic();
}

}
