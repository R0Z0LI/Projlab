package Behaviors;

import Virologist.Virologist;

public class AttackBehavior {
    protected Virologist viro;
    public AttackBehavior(Virologist v){
        viro=v;
    }
    public void setVirologist(Virologist v){
        viro=v;
    }
    public Virologist getVirologist(){
        return viro;
    }
    public void attack(Virologist v){ v.beKilled(); }
}
