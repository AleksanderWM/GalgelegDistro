package galgeleg.highscore;
/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/
import java.util.*;
import galgeleg.highscore.PlayerAndScore;
import galgeleg.GalgelogikImpl;
import Brugerautorisation.data.Bruger;



/**
 *
 * @author janus
 */
public class Highscore {
    private ArrayList<PlayerAndScore> highscoreList = new ArrayList<PlayerAndScore>();
    private GalgelogikImpl logic = new GalgelogikImpl();
    private Bruger user = new Bruger();
    
    
    
//    public void addHighscore(int score, String studienummer){
    public void addHighScore(){
        Collections.sort(highscoreList, PlayerAndScore.playerScore);
        
        for(int i = 1; i < highscoreList.size(); i++ ){
            if ((logic.getPoints()) > highscoreList.get(i).getHighscore());
            PlayerAndScore playerAndScore = new PlayerAndScore(logic.getPoints(), user.brugernavn);
            highscoreList.add(playerAndScore);
            constrainArray();
        }
        
    }
    
    //Constrains the array to the max size of 50 indexes.
    void constrainArray(){
        if (highscoreList.size() > 51);
        highscoreList.subList(51, highscoreList.size()).clear();
        
    }
    public List<PlayerAndScore> getHighscoreList(){
        
        return highscoreList.subList(1, 11);
    }
    
    
}
