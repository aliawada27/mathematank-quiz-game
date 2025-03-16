/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mathématank;

import java.io.File;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.JOptionPane;

/**
 *
 * @author nitra
 */
public class musicHole {
    
   static int musicIsPlaying = 1;
   public static boolean isMusicPlaying = true;
   
   static Clip clip;
   static long clipTimePosition;
    
    void playMusic(String musicLocation){
        
        try {
            File musicPath = new File(musicLocation);
            
            if(musicPath.exists()){
                AudioInputStream audioInput = AudioSystem.getAudioInputStream(musicPath);
                clip = AudioSystem.getClip();
                clip.open(audioInput);
                clip.start();
                clip.loop(clip.LOOP_CONTINUOUSLY);
                
                /*if (isMusicPlaying = true) {
                clip.start();
                clip.loop(clip.LOOP_CONTINUOUSLY); 
                }
                if (isMusicPlaying = false) {
                clip.stop(); 
                }*/
                
                /*sauvegarder la position dans la music et l'arreter
                long clipTimePosition = clip.getMicrosecondPosition();
                clip.stop(); 
                //repartir lar music avec la position sauvegarder
                clip.setMicrosecondPosition(clipTimePosition);
                clip.start();*/
            }
            else {
                System.out.println("La musique n'a pas pu etre trouver.");
            }
        }
        catch(Exception ex){
            ex.printStackTrace();
        }
        
    }
    
    void playSound(String soundLocation){
        
        try {
            File soundPath = new File(soundLocation);
            
            if(soundPath.exists()){
                AudioInputStream audioInput = AudioSystem.getAudioInputStream(soundPath);
                Clip sound = AudioSystem.getClip();
                sound.open(audioInput);
                sound.start();
                
                
            }
            else {
                System.out.println("Le sound effect n'a pas pu etre trouver.");
            }
        }
        catch(Exception ex){
            ex.printStackTrace();
        }
        }
    
    void stopMusic(){
        
        try {
             clip.stop();
        }
        catch(Exception ex){
            ex.printStackTrace();
        }
        }
    
    void pauseMusic(){
        
        try {
            clipTimePosition = clip.getMicrosecondPosition();
            clip.stop();       
        }
        catch(Exception ex){
            ex.printStackTrace();
        }
        }
    
    void restartMusic(){
        
        try {
            clip.setMicrosecondPosition(clipTimePosition);
            clip.start();  
            clip.loop(clip.LOOP_CONTINUOUSLY);
        }
        catch(Exception ex){
            ex.printStackTrace();
        }
        }
    
    void switchMusic(String newMusicLocation){
        
        try {
            File newMusicPath = new File(newMusicLocation);
            
            if(newMusicPath.exists()){
                AudioInputStream audioInput = AudioSystem.getAudioInputStream(newMusicPath);
                clipTimePosition = clip.getMicrosecondPosition();
                clip.stop();
                clip = AudioSystem.getClip();
                clip.open(audioInput);
                clip.setMicrosecondPosition(clipTimePosition);
                clip.start();  
                clip.loop(clip.LOOP_CONTINUOUSLY);
                
                
            }
            else {
                System.out.println("La musique n'a pas pu etre trouver.");
            }
        }
        catch(Exception ex){
            ex.printStackTrace();
        }
        }
    
    void muteMusic(){
        
        try {
            clip.stop();
            JOptionPane.showMessageDialog(null,"You fell for it again.","You fool. You absolute buffoon.", JOptionPane.INFORMATION_MESSAGE);
        }
        catch(Exception ex){
            ex.printStackTrace();
        }
        }
    
    void playMelody(String melodyLocation){
        
        try {
            File melodyPath = new File(melodyLocation);
            
            if(melodyPath.exists()){
                AudioInputStream audioInput = AudioSystem.getAudioInputStream(melodyPath);
                clip = AudioSystem.getClip();
                clip.open(audioInput);
                clip.start();
                
            }
            else {
                System.out.println("La musique n'a pas pu etre trouver.");
            }
        }
        catch(Exception ex){
            ex.printStackTrace();
        }
        
    }
        
    
     static void muteTheSong(int isMuted){
         
        // isMusicPlaying.set = !isMusicPlaying;
        
         /*if (isMuted == 1) {
             playMusic.clip.stop();
         }
             else
             if (isMuted == 0) {
             playMusic.clip.start();
         }
             else*/
        
         
    }
    
    public class Muting {
        public int musicIsPlayingTe = 1;
    }
    
    
}
