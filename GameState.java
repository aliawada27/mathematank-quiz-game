
package mathématank;

/**
 *
 * @author 
 */
public class GameState {

static int vieMax;
static int vie;
static int highscore = 0;
static int score;
static int highscoreFacile =0;
static int highscoreNormal=0;
static int highscoreVeteran=0;
static String difficulterChoisi;

// declaration des variables
public static void setDifficulter(String difficulter) {
   difficulterChoisi = difficulter;
}

public static int getVie() {
   return vie ;
}

public static void setVie(int viesMaximum) {
   vie = viesMaximum;
}

public static int getScore() {
   return score ;
}

public static void setScore() {
   score = 0;
}

public static void addScore() {
   score++;
}

public static void mulScore() {
   score+=2;
}

public static void subVie() {
    if (vie > 0)
        vie--;
}

public static boolean gameOver() {
    return vie == 0;
}

public static String getDifficulter() {
    return difficulterChoisi ;
}

public static void scoreFacile() {
    if (score > highscoreFacile)
        highscoreFacile = score;
}

public static void scoreNormal() {
    if (score > highscoreNormal)
        highscoreNormal = score;
}

public static void scoreVeteran() {
    if (score > highscoreVeteran)
        highscoreVeteran = score;
}



    
}
