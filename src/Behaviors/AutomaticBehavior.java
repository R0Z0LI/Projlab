package Behaviors;

import Collectible.Collectible;
import PropertyHandler.PropertyHandler;
import Virologist.Virologist;

import java.util.ArrayList;

public class AutomaticBehavior {
    protected Virologist viro;
    public AutomaticBehavior(){}
    public AutomaticBehavior(Virologist v){
        viro=v;
    }
    public void setVirologist(Virologist v){
        viro=v;
    }
    public Virologist getVirologist(){
        return viro;
    }
    public void execute(){ }
    public ArrayList<Collectible> getStealables(PropertyHandler ph){return null;}
}
