package mathématank;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;
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
import static mathématank.FacileController.gameover;
import static mathématank.FacileController.rightQesutionNum;

//déclaration des variables
public class NormalController {

    @FXML
    private Button Retour_Boutton_Normal;
        
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
    
    
    // À changer lorsqu'on ajoute des questions
    private static int NUM_QUESTIONS = 10;
    
    // Ajouter les questions ici
    private String[][] questions = {
        {"Quelle est la dérivée de la fonction \n f(x) = 2x^3 + 5x^2 - 3x ?", 
            "a) 6x^2 + 10x - 3" ,
            "b) 6x^2 + 10x",
            "c) 6x^2 + 5x - 3", 
            "d) 6x^2 + 5x ", 
            "2"}, 
        {"Quelle est la dérivée de la fonction \n f(x) = f(x) = 4x^4 - 3x^3 + 2x^2 - x + 1 ?" ,
            "a) 16x^3 - 9x^2 + 4x - 1", 
            "b) 16x^3 - 9x^2 + 4x",  
            "c) 16x^3 - 9x^2 + 2x - 1", 
            "d) 16x^3 - 9x^2 + 2x", 
            "1"},
        {"Quelle est la dérivée de la fonction \n f(x) = 3x^2 + 4x + 2 / x ?", 
            "a) 3x^2 - 4x - 2 / x^2" ,
            "b) 3x^2 + 4x - 2 / x^2",  
            "c) 3x^2 + 4 / x^2", 
            "d) 3x^2 - 4 / x^2", 
            "2"},
        {"Quel nom appartient a un grand homme \n de la science ?" ,
            "a) John Tesla", 
            "b) Albert Enstin",  
            "c) Lisaac Newton", 
            "d) James Watt", 
            "4"},
        {"Comment on ecrit 128 en base 2 ?",   
            "a) 1000 0000" ,
            "b) 0001 0000 0000",  
            "c) 010 01000", 
            "d) 1000 0100", 
            "1"},
        {"Quelle est l'integrale de e^(2x) ?", 
            "a) (e^(2x))/2 + C" ,
            "b) e^(2x) + C",  
            "c) (2x)/e + C", 
            "d) e/(2x) + C", 
            "1"},
        {"Comment on additionne deux resistances \n qui sont en parallele ?",
            "a) R1 + R2" ,
            "b) 1/R1 + 1/R2",  
            "c) R1 * R2", 
            "d) 1/R1 * 1/R2", 
            "2"},
         {"Comment pouvons nous obtenir la \n vitesse avec l'energie cinetique (K) ?", 
            "a) v = q/K" ,
            "b) v = -K/q",  
            "c) v = sqrt((2K)/m)", 
            "d) v = sqrt(m/(2K))", 
            "3"},
         {"Qulle est le théorème de Gauss \n en électrostatique ?", 
            "a) E*dS = Qint/E0" ,
            "b) E*A = Qint*A",  
            "c) A*dS = q/Qint", 
            "d) E*A = dEA * Qint", 
            "1"},
         {"Comment additionne-nous i2 et i3 \n selon la loi des noeuds ?", 
            "a) i1 = 1/i2 * 1/i3" ,
            "b) i1 = 1/i2 + 1/i3",  
            "c) i1 = i2 * i3", 
            "d) i1 = i2 + i3", 
            "4"},
        {"QUESTION", "a)" ,"b)",  "c)", "d)", "Numero de réponse SANS ESPACE (Numero seulement sinon ca BUG"}
    };
    
    
    private static final String[] IMAGE_PERSONNAGE = {
            "mathématank/graphique/vies normal/personnage normal/normal_0.png",
            "mathématank/graphique/vies normal/personnage normal/normal_1.png",
            "mathématank/graphique/vies normal/personnage normal/normal_2.png",
            "mathématank/graphique/vies normal/personnage normal/normal_3.png"
    };
    
    private static final String[] IMAGE_HEARTS = {
            "mathématank/graphique/vies normal/math_normal_0.png",
            "mathématank/graphique/vies normal/math_normal_1.png",
            "mathématank/graphique/vies normal/math_normal_2.png",
            "mathématank/graphique/vies normal/math_normal_3.png"
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
    
    //timer du jeu 
    @FXML
    protected void initialize(){
        generateQuestion();
        timeline = new Timeline(
                new KeyFrame(Duration.seconds(1), e -> updateTimer()));
        timeline.setCycleCount(Animation.INDEFINITE);
        timeline.play();
        
     /*   try{
    Scanner questionScanning = new Scanner(new File("QUESTION_JEU_NORMAL.txt"));
     String data;

      while(questionScanning.hasNextLine()){
           data = questionScanning.nextLine();

           String[] token = data.split(" ");
           NUM_QUESTIONS = Integer.parseInt(token[0]);
           questions= token[1];
      }
      questionScanning.close();}
    catch(Exception ex){
            ex.printStackTrace();
        }*/
        
    }

    //mettre le jeu en pause
    @FXML
    void Retour_Pressed(ActionEvent event) throws IOException {
        Scene first = null;
        Parent root = null;
        if(event.getSource()==Retour_Boutton_Normal ){
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
                first = Retour_Boutton_Normal.getScene();
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
    
    //vérification des réponse selon la question
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
            
            personnage.setImage(new Image(IMAGE_PERSONNAGE[GameState.getVie()]));
            hearts.setImage(new Image(IMAGE_HEARTS[GameState.getVie()]));
            
            labelVie.setText(String.valueOf(GameState.getVie()));
            previousRepRight = false;
            if(GameState.gameOver()){
                dunkTankFront.setImage(new Image("mathématank/graphique/gameover/normal.png"));
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
    
    //timer se reset
    private void updateTimer() {
        if(time > 0){
            time--;
            timer.setText(String.valueOf(time));
        }
        if(time == 0 && gameover == false){
            soundMenu.playSound(mauvaiserepspath);
            GameState.subVie();
            
            personnage.setImage(new Image(IMAGE_PERSONNAGE[GameState.getVie()]));
            hearts.setImage(new Image(IMAGE_HEARTS[GameState.getVie()]));
            
            labelVie.setText(String.valueOf(GameState.getVie()));
            previousRepRight = false;
            generateQuestion();
            resetTimer();
        }
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
        GameState.scoreNormal();

        gameOverAlert.showAndWait();
        timeline.stop();
        
        musicMenu.stopMusic();
        musicMenu.playMusic(filepath);
        
        Parent root = FXMLLoader.load(getClass().getResource("Menu.fxml"));
        Scene first = Retour_Boutton_Normal.getScene();
        first.setRoot(root); 
    }

}


