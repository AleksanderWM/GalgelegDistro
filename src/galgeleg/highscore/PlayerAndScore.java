/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/
package galgeleg.highscore;

import java.io.Serializable;
import java.util.Comparator;

/**
 *
 * @author janus
 */
public class PlayerAndScore implements Serializable{
    private int highscore;
    private String studentNumber;
    
    public  PlayerAndScore(int highscore, String studentNumber){
        this.highscore = highscore;
        this.studentNumber = studentNumber;
        
        
    }
    public int getHighscore(){
        return this.highscore;
    }
    
    public String getStudentNumber(){
        return this.studentNumber;
    }
    
    public static Comparator<PlayerAndScore> playerScore = new Comparator<PlayerAndScore>(){
        @Override
        public int compare(PlayerAndScore p1, PlayerAndScore p2){
            int highscore1 = p1.getHighscore();
            int highscore2 = p2.getHighscore();
            
            return highscore2-highscore1;
        }
        
    };
}

