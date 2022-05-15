package Behaviors;

import Agent.BearDanceAgent;
import Collectible.Collectible;
import Field.Field;
import Graphics.CommandView;
import Graphics.VirologistView;
import PropertyHandler.PropertyHandler;
import Virologist.Virologist;

import java.util.ArrayList;
import java.util.Random;

public class BearBehavior extends AutomaticBehavior{
    public BearBehavior(Virologist v){super(v);}
    /**
     * a medve viselkedést megvalósítja
     */
    @Override
    public void execute(){
        //virológus megjelenése medve
        viro.getVirologistView().displayBearVirologist(viro.getCurrentField().getView(), VirologistView.ACTIVE_MODE);

        //véletlen mezőre lép
        ArrayList<Field> neighbours = viro.getCurrentField().getNeighbours();
        int index = new Random().nextInt(0, neighbours.size());
        viro.step(neighbours.get(index));

        //mindenkit megfertőz
        Field field = viro.getCurrentField();
        for(Virologist v :field.GetTouchableVirologists())
            if (viro != v)
                v.beInfected(new BearDanceAgent(), viro);

        //elpusztítja az anyagokat
        field.rampage();

        //letiltja a többi akciót
        viro.setActionCounter(-1);
    }
}
