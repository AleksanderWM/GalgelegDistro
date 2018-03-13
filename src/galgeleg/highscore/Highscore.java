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
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;



/**
 *
 * @author janus
 */
public class Highscore {
    private ArrayList<PlayerAndScore> highscoreList = new ArrayList<>();
    private GalgelogikImpl logic = new GalgelogikImpl();
    private Bruger user = new Bruger();
    

//    public void addHighscore(int score, String studienummer){
    public void addHighScore() throws IOException, FileNotFoundException, ClassNotFoundException{
        loadList();
        Collections.sort(highscoreList, PlayerAndScore.playerScore);
        
        for(int i = 1; i < highscoreList.size(); i++ ){
            if ((logic.getPoints()) > highscoreList.get(i).getHighscore());
            PlayerAndScore playerAndScore = new PlayerAndScore(logic.getPoints(), user.brugernavn);
            highscoreList.add(playerAndScore);
            constrainArray();
        }
        saveList();
    }
    
    //Constrains the array to the max size of 50 indexes.
    void constrainArray(){
        if (highscoreList.size() > 51);
        highscoreList.subList(51, highscoreList.size()).clear();
        
    }
    
    // Returns the top 10 scores.
    public List<PlayerAndScore> getHighscoreList(){
        
        return highscoreList.subList(1, 11);
    }
    
    //Used to save the highscore ArrayList to a serialized object. 
     void saveList() throws FileNotFoundException, IOException{
        FileOutputStream fOutput = new FileOutputStream("file.temp");
        ObjectOutputStream oOutput = new ObjectOutputStream(fOutput);
        oOutput.writeObject(highscoreList);
        oOutput.close();
    }
    
     //Used to load the highScore ArrayList from a serialized file. 
     void loadList() throws FileNotFoundException, IOException, ClassNotFoundException{
        FileInputStream fInput = new FileInputStream("file.temp");
        ObjectInputStream oInput = new ObjectInputStream(fInput);
        this.highscoreList = (ArrayList<PlayerAndScore>)oInput.readObject();
        oInput.close();
    }
}
 