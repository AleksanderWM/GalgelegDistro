/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package galgeleg;

import java.util.ArrayList;

/**
 *
 * @author aleks
 */
public class galgeObject {
    private ArrayList<String> muligeOrd = new ArrayList<String>();
    private ArrayList<String> brugteBogstaver = new ArrayList<String>();
    private String synligtOrd;
    private String ordet;
    private int antalForkerteBogstaver;
    private boolean sidsteBogstavVarKorrekt;
    private boolean spilletErVundet;
    private boolean spilletErTabt;
    private int points;
    
    public ArrayList<String> getBrugteBogstaver() {
        return brugteBogstaver;
    }
    
    public void setBrugteBogstaver(String værdi) {
        brugteBogstaver.add(værdi);
    }
    
    public void setMuligeOrd(ArrayList<String> muligeOrd){
        this.muligeOrd = muligeOrd;
    }
    
    public ArrayList<String> getMuligeOrd(){
        return muligeOrd;
    }
    
    public String getSynligtOrd() {
        return synligtOrd;
    }
    public void setSynligtOrd(String værdi){
        synligtOrd = synligtOrd + værdi;
    }
    public void clearSynligtOrd(){
        synligtOrd = "";
    }
    
    public String getOrdet() {
        return ordet;
    }
    public void setOrdet(String værdi){
        ordet = værdi;
    }
    
    public int getAntalForkerteBogstaver() {
        return antalForkerteBogstaver;
    }
    
    public void setAntalForkerteBogstaver(int værdi) {
        antalForkerteBogstaver = værdi;
    }
    
    
    public boolean getErSidsteBogstavKorrekt() {
        return sidsteBogstavVarKorrekt;
    }
    public void setErSidsteBogstavKorrekt(boolean værdi) {
        sidsteBogstavVarKorrekt = værdi;
    }
    public boolean getErSpilletVundet() {
        return spilletErVundet;
    }
    
    public void setErSpilletVundet(boolean værdi) {
        spilletErVundet = værdi;
    }
    
    public boolean getErSpilletTabt() {
        return spilletErTabt;
    }
    
    public void setErSpilletTabt(boolean tabt) {
        spilletErTabt = tabt;
    }
    
    public int getPoints(){
        return points;
    }
    public void setPoints(int værdi){
        points = points + værdi;
    }
    
    public void clearPoints(){
        this.points = 0;
    }
    
}
