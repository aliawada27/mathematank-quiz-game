package mathématank;

import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.text.Text;

//déclaration des variables
public class MenuController {
    @FXML
    private Button Retour_Boutton_Aide;
    
    @FXML
    private Button Retour_Boutton_Parametre;
    
    @FXML
    private Button Retour_Boutton_Facile;
   
    @FXML
    private Button Retour_Boutton_Veteran;
    
    @FXML
    private Button Retour_Boutton_Normal;
    
    @FXML
    private Button BUTTON_AIDE_MENU_PRINCIPAL;

    @FXML
    private Button BUTTON_FACILE_MENU_PRINCIPAL;

    @FXML
    private Button BUTTON_NORMAL_MENU_PRINCIPAL;

    @FXML
    private Button BUTTON_Parametre_MENU_PRINCIPAL;

    @FXML
    private Button BUTTON_VÉTÉRAN_MENU_PRINCIPAL;

    @FXML
    private ImageView ImageView;

    @FXML
    private Text TITLE_MENU_PRINCIPAL;
    
    
    String helppath = "menuAide.wav";
    String mutepath = "mutingUnmuting.wav";
    String startpath = "CommencerLeJeu.wav";
    String gamepath = "CommencerLeJeuAlternatif.wav";
    String gotempath = "Ha_got_em.wav";
        
    musicHole soundMenu = new musicHole();
    
    String facilepath = "Mathematank_Facile_music.wav";
    String helppagepath = "Mathematank_page_aide_music.wav";
    String normalpath = "Mathematank_Normal_Stage.wav";
    String veteranpath = "Mathematank_Veteran_Stage.wav";

    musicHole musicMenu = new musicHole();

    //ajout de la jusique dans le menu
    @FXML
    void Bouton_Menu_Selected(ActionEvent event)throws IOException {
        Scene first = null;
        Parent root = null;
        if(event.getSource()==BUTTON_FACILE_MENU_PRINCIPAL ){
            soundMenu.playSound(startpath);
            
            root = FXMLLoader.load(getClass().getResource("Facile.fxml"));
            first = BUTTON_FACILE_MENU_PRINCIPAL.getScene();
            first.setRoot(root);
            musicMenu.stopMusic();
            musicMenu.playMusic(facilepath);
            GameState.setDifficulter("Facile");
            GameState.setVie(5);
            GameState.setScore();
            FacileController.gameover = false;
        }
        else if (event.getSource()==BUTTON_NORMAL_MENU_PRINCIPAL){
            soundMenu.playSound(startpath);
            root = FXMLLoader.load(getClass().getResource("Normal.fxml"));
            first = BUTTON_NORMAL_MENU_PRINCIPAL.getScene();
            first.setRoot(root);
            musicMenu.stopMusic();
            musicMenu.playMusic(normalpath);
            GameState.setDifficulter("Normal");
            GameState.setVie(4);
            GameState.setScore();
            NormalController.gameover = false;
        }
        else 
            if (event.getSource()==BUTTON_VÉTÉRAN_MENU_PRINCIPAL){
                soundMenu.playSound(startpath);
                root = FXMLLoader.load(getClass().getResource("Veteran.fxml"));
                first = BUTTON_VÉTÉRAN_MENU_PRINCIPAL.getScene();
                first.setRoot(root);
                musicMenu.stopMusic();
                  musicMenu.playMusic(veteranpath);
                GameState.setDifficulter("Veteran");
                GameState.setVie(3);
                GameState.setScore();
                VeteranController.gameover = false;
            }else 
                if (event.getSource()==BUTTON_AIDE_MENU_PRINCIPAL){
                    soundMenu.playSound(helppath);
                    musicMenu.switchMusic(helppagepath);
                    root = FXMLLoader.load(getClass().getResource("Aide.fxml"));
                    first = BUTTON_AIDE_MENU_PRINCIPAL.getScene();
                    first.setRoot(root);
                }else 
                    if (event.getSource()==BUTTON_Parametre_MENU_PRINCIPAL){
                        soundMenu.playSound(gotempath);
                        root = FXMLLoader.load(getClass().getResource("Parametre.fxml"));
                        first = BUTTON_Parametre_MENU_PRINCIPAL.getScene();
                        first.setRoot(root);
                    }
    }
    
    @FXML
    void Retour_Boutton_Aide(ActionEvent event) throws IOException {
    Scene first= null;
    Parent root = null;
    if(event.getSource()==Retour_Boutton_Aide){
        root = FXMLLoader.load(getClass().getResource("Menu.fxml"));
        first = Retour_Boutton_Aide.getScene();
        first.setRoot(root);
    }
    else 
        if(event.getSource()==Retour_Boutton_Parametre){
            root = FXMLLoader.load(getClass().getResource("Menu.fxml"));
            first = Retour_Boutton_Parametre.getScene();
            first.setRoot(root);
        }
    }
}

