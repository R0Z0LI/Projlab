package Equipments;

import Field.Shelter;
import PropertyHandler.PropertyHandler;
import Virologist.Virologist;

public class Axe extends Equipment{
    private static int id = 0;

    public Axe(){
        this.name = "axe" + id++;
    }

    public Axe(Shelter field){
        this.name = "axe" + id++;
        this.currPosition = field;
    }

    @Override
    public void addBehaviour(Virologist v) {

    }

    @Override
    public void removeBehavior(Virologist v) {

    }

    @Override
    public void beCollected(PropertyHandler ph) {

    }

    @Override
    public void beRemoved(PropertyHandler ph) {

    }
}
