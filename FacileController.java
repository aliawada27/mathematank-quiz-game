package mathématank;

import java.io.IOException;
import static java.lang.Integer.max;
import java.net.URL;
import java.util.Timer;
import java.util.TimerTask;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Control;
import javafx.scene.image.ImageView;
import javafx.scene.text.Text;
import javax.swing.JOptionPane;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Platform;
import javafx.util.Duration;
import javafx.animation.Animation;
import javafx.animation.PauseTransition;
import javafx.animation.SequentialTransition;
import javafx.scene.control.Alert;
import javafx.scene.image.Image;


public class FacileController {

    @FXML
    private Button Retour_Boutton_Facile;
    
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
    
    // à changer lorsqu'on veut changer les questions
    // il va falloir le faire lire le nombre du fichier texte
    private static int NUM_QUESTIONS = 20;
    
    // TO DO
    // il va falloir le faire lire toute les lignes nommer facile du fichier texte, mais ignore le nom dans le code
    private String[][] questions = {
        {"Quelle est la dérivée de la fonction \n f(x) = 3x^2 ?", "a) 6x" ,"b) 3x",  "c) 2x", "d) x", "1"}, 
        {"Quelle est la dérivée de la fonction \n f(x) = x^3 + 4x^2 - 5x ?" ,"a) 3x^2 + 8x - 5 ", "b) 2x^3 + 4x^2 - 5x",  "c) 3x^2 + 8x", "d) 2x^3 + 4x^2 ", "1"},
        {"Quelle est la dérivée de la fonction \n f(x) = sqrt(x) ?", "a) 2 sqrt(x)" ,"b) sqrt(x)",  "c) 1 / (2 sqrt(x))", "d) 1 / (2x)", "3"},
        {"Quelle est la dérivée de la fonction \n f(x) = cos(x) ?", "a) -sin(x)" ,"b) cos(x)",  "c) -cos(x)", "d) sin(x)", "1"},
        {"Quelle est l'unité de mesure de \n l'intensité d'un courant électrique ?", "a) Volt (V)" ,"b) Ampère (A)",  "c) Watt (W)", "d) Ohm (Ω)", "2"},
        {"En quelle unité mesure-t-on la fréquence ?", "a) Volt (V)" ,"b) Kilowatt (kW)",  "c) Kilometre (km)", "d) Hertz (Hz)", "4"},
        {"Comment on ecrit 37 en base 2 ?", "a) 0111 0111" ,"b) 0010 0101",  "c) 0010 0100", "d) 1101", "2"},
        {"C'est quoi une masse ?", "a) L'equivalent de la tension" ,"b) Le M dans les formules",  "c) La quantité de matière d'un objet", "d) La poid d'un objet", "3"},
        {"Quelle est vrai dans le contexte \n d'un MRUA ?", "a) vf - vi = a * ∆t" ,"b) a = ∆t / ∆v ",  "c) vf = (∆t * a) - vi", "d) ∆m = vf * ∆t + (a * ∆t²) / 2", "1"},
        {"Quelle est la puissance de la gravite?", "a) g = 8,91 m/s" ,"b) g = 9,91 m/s^2",  "c) g = 9,81 m/s^2", "d) g = 9,81 m/s", "3"},
        {"Quelle est le symbole du Joule ?", 
            "a) W" ,
            "b) J",
            "c) Jl", 
            "d) E1 ", 
            "2"}, 
        {"Avec quoi mesurons-nous \n la puissance (P) ?" ,
            "a) Watt (W)", 
            "b) Volt (V)",  
            "c) Hertz (Hz)", 
            "d) Acceleration par temps (a/t)", 
            "1"},
        {"Comment on utilise un ampheremetre ?", 
            "a) On le met pres du circuit" ,
            "b) On le met en parallele",  
            "c) On le met en serie", 
            "d) On entre les donnees fournis", 
            "3"},
        {"Quelles couleurs sont utilisees pour \n la tolerance sur une resistance ?" ,
            "a) Noir, blanc", 
            "b) Toutes les couleurs",  
            "c) Noir, blanc, or et argent", 
            "d) Or et argent", 
            "4"},
        {"Comment on utilise un voltmetre ?",   
            "a) On le met en serie" ,
            "b) On entre les donnees fournis",  
            "c) On le met pres du circuit", 
            "d) On le met en parallele", 
            "4"},
        {"Quelle est log(e) ?", 
            "a) ln" ,
            "b) log(e)",  
            "c) 0,433", 
            "d) e", 
            "1"},
        {"Comment ecrivons-nous 7 en base 8 ?",
            "a) 11" ,
            "b) 7",  
            "c) 8", 
            "d) 61", 
            "2"},
         {"log(12)/log(10) donne quoi ?", 
            "a) log(10)" ,
            "b) log(2)",  
            "c) log(12)", 
            "d) log(12)/log(10)", 
            "3"},
         {"Qulle est la derivee de 7^x ?", 
            "a) 7x*7^x" ,
            "b) 7^(x)*ln(7)",  
            "c) 7/x", 
            "d) 7^(x-1)*7x", 
            "2"},
         {"Quelle est l'integrale de sin(2x) ?", 
            "a) -2cos(2x) + C" ,
            "b) (1/2)*cos(2x) + C",  
            "c) 2cos(2x) + C", 
            "d) -(1/2)*cos(2x) + C", 
            "4"},
        {"QUESTION", "a)" ,"b)",  "c)", "d)", "Numero de réponse SANS ESPACE (Numero seulement sinon ca BUG"}
    };
    
    private static final String[] IMAGE_PERSONNAGE = {
            "mathématank/graphique/vies facile/personnage facile/facile_0.png",
            "mathématank/graphique/vies facile/personnage facile/facile_1.png",
            "mathématank/graphique/vies facile/personnage facile/facile_2.png",
            "mathématank/graphique/vies facile/personnage facile/facile_3.png",
            "mathématank/graphique/vies facile/personnage facile/facile_4.png",
    };
    
    private static final String[] IMAGE_HEARTS = {
            "mathématank/graphique/vies facile/math_easy_0.png",
            "mathématank/graphique/vies facile/math_easy_1.png",
            "mathématank/graphique/vies facile/math_easy_2.png",
            "mathématank/graphique/vies facile/math_easy_3.png",
            "mathématank/graphique/vies facile/math_easy_4.png",
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
    
    //initialiser le quiz avec les questions
    @FXML
    protected void initialize(){
        generateQuestion();
        timeline = new Timeline(
                new KeyFrame(Duration.seconds(1), e -> updateTimer()));
        timeline.setCycleCount(Animation.INDEFINITE);
        timeline.play();
        gameover= false;
    }
    
    //générer les questions
    public void generateQuestion(){
        int randomNum = ThreadLocalRandom.current().nextInt(0, NUM_QUESTIONS);
        System.out.println(randomNum);
        question.setText(questions[randomNum][0]);
        rep1.setText(questions[randomNum][1]);
        rep2.setText(questions[randomNum][2]);
        rep3.setText(questions[randomNum][3]);
        rep4.setText(questions[randomNum][4]);
        rightQesutionNum = Integer.parseInt(questions[randomNum][5]);
    }

    //bouton retour a partir du mode de jeu facile
    @FXML
    void Retour_Pressed(ActionEvent event) throws IOException {
        Scene first = null;
        Parent root = null;
        if(event.getSource()==Retour_Boutton_Facile ) {
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
                first = Retour_Boutton_Facile.getScene();
                first.setRoot(root); }
            else {
                soundMenu.playSound(pauseeffectspath);
                JOptionPane.showMessageDialog(null,"Le jeu va reprendre", "PAUSE", JOptionPane.INFORMATION_MESSAGE);
                soundMenu.playSound(pauseeffectspath);
                // pour que pause soit au milieu, "                         PAUSE"
                musicMenu.restartMusic();
                timeline.play();
            }
        }
    }
    
    //perte de point de vie à partir des réponse appuyées
    @FXML
    void reponse(ActionEvent event) throws IOException, InterruptedException {
        String reponse = ((Control)event.getSource()).getId();
        int repNum = Integer.parseInt(reponse.replaceAll("[^0-9]", ""));
        if(repNum == rightQesutionNum){
            if(previousRepRight) {
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
                dunkTankFront.setImage(new Image("mathématank/graphique/gameover/facile.png"));
                personnage.setImage(null);
                dunkTankChair.setImage(null);
                gameover = true;
                time = 0;
                timer.setText("0");
                
                // Tester si un meilleur score
                
                showGameOver();
            }
        }
        
        generateQuestion();
        resetTimer();
        
    }
    
    private void updateTimer() {
        //if(time > 0 && GameState.getDifficulter()== "Facile")
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
        if(time == 0 && GameState.getVie() == 1){
            soundMenu.playSound(mauvaiserepspath);
            GameState.subVie();
            
            labelVie.setText(String.valueOf(GameState.getVie()));
            personnage.setImage(new Image(IMAGE_PERSONNAGE[GameState.getVie()]));
            hearts.setImage(new Image(IMAGE_HEARTS[GameState.getVie()]));
            
            previousRepRight = false;
            
                dunkTankFront.setImage(new Image("mathématank/graphique/gameover/facile.png"));
                personnage.setImage(null);
                dunkTankChair.setImage(null);
                gameover = true;
                time = 0;
                timer.setText("0");
                
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
        GameState.scoreFacile();

        gameOverAlert.showAndWait();
        timeline.stop();
        
        musicMenu.stopMusic();
        musicMenu.playMusic(filepath);
        
        Parent root = FXMLLoader.load(getClass().getResource("Menu.fxml"));
        Scene first = Retour_Boutton_Facile.getScene();
        first.setRoot(root);
        
    }

}
    




