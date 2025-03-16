package mathématank;

import java.io.IOException;
import java.util.concurrent.ThreadLocalRandom;
import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Control;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.util.Duration;
import javax.swing.JOptionPane;
import static mathématank.NormalController.gameover;
import static mathématank.NormalController.rightQesutionNum;

public class VeteranController {

    @FXML
    private Button Retour_Boutton_Veteran;
        
    @FXML
    private ImageView ImageView;
    
    @FXML
    private ImageView dunkTank;
        
    @FXML
    private Label labelVie;
    
    @FXML
    private Label labelScore;
    
    @FXML
    private ImageView personnage;
    
    @FXML
    private ImageView dunkTankGlass;
    
    @FXML
    private ImageView dunkTankChair;
    
    @FXML
    private ImageView dunkTankFront;
    
    @FXML
    public Label question;
    
    @FXML
    private Button rep1;
    
    @FXML
    private Button rep2;
    
    @FXML
    private Button rep3;
    
    @FXML
    private Button rep4;
    
    @FXML
    private Label timer;
    
    @FXML
    private ImageView hearts;
    
    private Timeline timeline;
    
    private static int time = 60;
    
    static int rightQesutionNum;
    
    static boolean previousRepRight = false;
    
    static boolean gameover = false;
    
    // Changer le nombre de questions lorsqu'on modifie en bas
    private static int NUM_QUESTIONS = 6;
    
    // Ajouter les questions souhaitées ici
    private String[][] questions = {
        {"Quelle est la définition d'une matrice \n carrée?", 
            "a) Une matrice dont le nombre de colonnes \n est supérieur au nombre de lignes",  
            "b) Une matrice dont le nombre de lignes \n est supérieur au nombre de colonnes", 
            "c) Une matrice dont le nombre de \n colonnes est égal au nombre de lignes", 
            "d) Aucune de ces reponses", 
            "3"}, 
        {"Comment appelle-t-on une matrice carrée \n dont tous les éléments sont égaux à zéro? " ,
            "a) Matrice nulle", 
            "b) Matrice identité",  
            "c) Matrice diagonale", 
            "d) Matrice scalaire", 
            "1"},
        {"Comment appelle-t-on la matrice obtenue \n en multipliant chaque élément d'une \n matrice par un scalaire?", 
            "a) Matrice diagonale" ,
            "b) Matrice identité",  
            "c) Matrice scalaire", 
            "d) Matrice inverse", 
            "3"},
        {"La troisieme loi de Kepler dit que \n k = GM/4*pi^2. Comment exprimons cela \n sous forme Newtonienne?", 
            "a) k = GM/4*pi^2",  
            "b) k^3 = G*(M+m) /(4*pi^2) * a^3", 
            "c) T = 4*pi^2/GM", 
            "d) T^3 = (4*pi^2)/(G*(M+m) * a^3", 
            "4"},
         {"Comment on ecrit 63 en base 16 ?", 
            "a) 63" ,
            "b) 3F",  
            "c) 47", 
            "d) 49", 
            "2"},
         {"Quelle est l'integrale de \n (3*sinx)/(2*cosx)dx ?", 
            "a) -ln(sinx) + C" ,
            "b) (3*log(cosx))/2 + C",  
            "c) (3*cosx))/(2*sinx) + C", 
            "d) -(3*ln(cosx))/2 + C", 
            "4"},
        {"QUESTION", 
            "a)" ,
            "b)",  
            "c)", 
            "d)", 
            "Numero de réponse SANS ESPACE (Numero seulement sinon ca BUG"}
    };
    private static final String[] IMAGE_PERSONNAGE = {
            "mathématank/graphique/vies veteran/personnage veteran/veteran_0.png",
            "mathématank/graphique/vies veteran/personnage veteran/veteran_1.png",
            "mathématank/graphique/vies veteran/personnage veteran/veteran_2.png",
    };
    
    private static final String[] IMAGE_HEARTS = {
            "mathématank/graphique/vies veteran/math_veteran_0.png",
            "mathématank/graphique/vies veteran/math_veteran_1.png",
            "mathématank/graphique/vies veteran/math_veteran_2.png",
    };
        
    String pausingpath = "pause_Menu_effect.wav";  
    String pauseeffectspath = "unpausing.wav";
    String bonnereppath = "correct - gain de score sound.wav";  
    String mauvaiserepspath = "mauvais - perte de vie sound.wav";
    String splashpath = "G-splash gameover.wav";
    musicHole soundMenu = new musicHole();
    String filepath = "Mathematank_menu_pricipal_music.wav";
    String gamrovemusicpath = "Mathematank Game Over full.wav";
    musicHole musicMenu = new musicHole();
    
     @FXML
    protected void initialize(){
        generateQuestion();
        timeline = new Timeline(
                new KeyFrame(Duration.seconds(1), e -> updateTimer()));
        timeline.setCycleCount(Animation.INDEFINITE);
        timeline.play();
    }
//configuration du bouton retour et de la musique et pause
    @FXML
    void Retour_Pressed(ActionEvent event) throws IOException {
        Scene first = null;
        Parent root = null;
        if(event.getSource()==Retour_Boutton_Veteran ) {
            soundMenu.playSound(pausingpath);
            musicMenu.pauseMusic();
            timeline.pause();
        int leave = JOptionPane.showConfirmDialog(null, "Voulez-vous quitter?", "PAUSE",JOptionPane.YES_NO_OPTION);
            if(leave == 0){
                musicMenu.stopMusic();
                musicMenu.playMusic(filepath);
                time = 60;
                timeline.stop();
                root = FXMLLoader.load(getClass().getResource("Menu.fxml"));
                first = Retour_Boutton_Veteran.getScene();
                first.setRoot(root); }
            else {
                soundMenu.playSound(pauseeffectspath);
                JOptionPane.showMessageDialog(null,"Le jeu va reprendre", "PAUSE", JOptionPane.INFORMATION_MESSAGE);
                soundMenu.playSound(pauseeffectspath);
                musicMenu.restartMusic();
                timeline.play();
            }
        }
    }
    //generer les questions
    public void generateQuestion(){
        int randomNum = ThreadLocalRandom.current().nextInt(0, NUM_QUESTIONS);
        question.setText(questions[randomNum][0]);
        rep1.setText(questions[randomNum][1]);
        rep2.setText(questions[randomNum][2]);
        rep3.setText(questions[randomNum][3]);
        rep4.setText(questions[randomNum][4]);
        rightQesutionNum = Integer.parseInt(questions[randomNum][5]);
    }
    
    @FXML
    void reponse(ActionEvent event) throws IOException {
        String reponse = ((Control)event.getSource()).getId();
        int repNum = Integer.parseInt(reponse.replaceAll("[^0-9]", ""));
        if(repNum == rightQesutionNum){
            if(previousRepRight){
                GameState.mulScore();
            soundMenu.playSound(bonnereppath);
            }
            else{
                GameState.addScore();
                soundMenu.playSound(bonnereppath);
            }
            labelScore.setText(String.valueOf(GameState.getScore()));
            previousRepRight = true;
        }else{
            soundMenu.playSound(mauvaiserepspath);
            GameState.subVie();
            labelVie.setText(String.valueOf(GameState.getVie()));
           
            personnage.setImage(new Image(IMAGE_PERSONNAGE[GameState.getVie()]));
            hearts.setImage(new Image(IMAGE_HEARTS[GameState.getVie()]));
            
            previousRepRight = false;
            
            if(GameState.gameOver()){
                dunkTankFront.setImage(new Image("mathématank/graphique/gameover/veteran.png"));
                personnage.setImage(null);
                dunkTankChair.setImage(null);
                gameover = true;
                time = 0;
                timer.setText("0");
                // test if highscore
                showGameOver();
            }
        }
        generateQuestion();
        resetTimer();
        
    }
    
    private void updateTimer() {
        if(time > 0){
            time--;
            timer.setText(String.valueOf(time));
        }
         if(time == 0 && gameover == false){
            soundMenu.playSound(mauvaiserepspath);
            GameState.subVie();
            labelVie.setText(String.valueOf(GameState.getVie()));
           
            personnage.setImage(new Image(IMAGE_PERSONNAGE[GameState.getVie()]));
            hearts.setImage(new Image(IMAGE_HEARTS[GameState.getVie()]));
            
            previousRepRight = false;
            generateQuestion();
            resetTimer();
        }
        /* try{
         if(GameState.gameOver()){
                timeline.stop();
                dunkTankFront.setImage(new Image("mathématank/graphique/gameover/veteran.png"));
                personnage.setImage(null);
                dunkTankChair.setImage(null);
                gameover = true;
                time = 0;
                timer.setText("0");
                // test if highscore
                showGameOver();
            }
         }
         catch(Exception ex){
            ex.printStackTrace();
        }*/
    }
    
    private void resetTimer() {
        time = 60;
        timer.setText("60");
    }
    
    private void showGameOver() throws IOException {
        musicMenu.stopMusic();
        soundMenu.playSound(splashpath);
        musicMenu.playMelody(gamrovemusicpath);
        Alert gameOverAlert = new Alert(Alert.AlertType.INFORMATION);
        gameOverAlert.setTitle("Game Over");
        gameOverAlert.setHeaderText(null);
        gameOverAlert.setContentText("Vous avez perdu!");
        GameState.scoreVeteran();

        gameOverAlert.showAndWait();
        timeline.stop();
        
        musicMenu.stopMusic();
        musicMenu.playMusic(filepath);
        
        Parent root = FXMLLoader.load(getClass().getResource("Menu.fxml"));
        Scene first = Retour_Boutton_Veteran.getScene();
        first.setRoot(root); 
    }
}
