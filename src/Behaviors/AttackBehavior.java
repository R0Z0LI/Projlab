package Behaviors;

import Virologist.Virologist;

public class AttackBehavior {
    protected Virologist viro;
    public void setVirologist(Virologist v){
        viro=v;
    }
    public Virologist getVirologist(){
        return viro;
    }
    public void attack( Virologist v){ }
}
