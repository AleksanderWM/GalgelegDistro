package galgeleg.highscore;
/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/
import java.util.*;
import galgeleg.highscore.PlayerAndScore;



/**
 *
 * @author janus
 */
public class Highscore {
   private ArrayList<PlayerAndScore> highscoreList = new ArrayList<PlayerAndScore>();
    
    
    
//    public void addHighscore(int score, String studienummer){
   public void addHighScore(){
        Collections.sort(highscoreList, PlayerAndScore.playerScore);
        for(int i = 1; i < highscoreList.size(); i++ ){
            if (score > highscoreList.get(i));
            highscoreList.add(i, score);
            score = 0;
            constrainArray();
        }
        
    }
    
    //Constrains the array to the max size of 50 indexes.
    void constrainArray(){
        if (highscoreList.size() > 51);
        highscoreList.subList(51, highscoreList.size()).clear();
        
    }
    public int[] getHighscoreList(){
        int[] topTen = new int[9];
        for (int i = 0; i < 10; i++){
            topTen[i] = highscoreList.get(1+i);
        }
        return topTen;
        
    }
    
    
       

    
}
