package Behaviors;

import Agent.BearDanceAgent;
import Collectible.Collectible;
import Field.Field;
import PropertyHandler.PropertyHandler;
import Virologist.Virologist;

import java.util.ArrayList;

public class BearBehavior extends AutomaticBehavior{
    public BearBehavior(){super();}
    public BearBehavior(Virologist v){super(v);}
    /**+
     * a medve viselkedést megvalósítja
     */
    @Override
    public void execute(){
        //véletlen mezőre lép
        ArrayList<Field> neighbours = viro.getCurrentField().getNeighbours();
        int index = (int) Math.round(Math.random() * neighbours.size());
        viro.step(neighbours.get(index));
        //mindenkit megfertőz
        Field field =viro.getCurrentField();
        for(Virologist v :field.GetTouchableVirologists())
            v.beInfected(new BearDanceAgent(), viro);
        //elpusztítja az anyagokat
        field.rampage();
        //letiltja a többi akciót
        viro.setActionCounter(0);
    }
}
