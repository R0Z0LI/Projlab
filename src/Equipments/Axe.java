package Equipments;

import Field.Shelter;
import Virologist.Virologist;

public class Axe extends Equipment{
    private static int id = 0;
    // TODO axe behavior

    /**
     * Axce constructor
     * @param field This is the field (shelter), that the axe is on.
     */
    public Axe(Shelter field){
        this.name = "axe" + id++;
        this.currPosition = field;
    }

    /**
     * Axe constructor without any parameters.
     * Should be used when adding to the inventory directly.
     */
    public Axe(){
        this.name = "axe" + id++;
        this.currPosition = null;
    }

    /**
     * Hozzáadja a megadott virológus verméhez a Axe-ből adódó viselkedést.
     *
     * @param v virológus, akinek a vermébe bele fog kerülni a Axe-ből adódó viselkedés
     */
    @Override
    public void addBehaviour(Virologist v) {
        // TODO
    }

    /**
     * Törli a megadott virológus verméből a Axe-ből adódó viselkedést.
     *
     * @param v virológus, akinek a verméből törlődni fog a Axe-ből adódó viselkedés
     */
    @Override
    public void removeBehavior(Virologist v) {
        // TODO
    }
}
