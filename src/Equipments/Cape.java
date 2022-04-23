package Equipments;

import Behaviors.CapeDefenseBehavior;
import Field.Shelter;
import Virologist.Virologist;

/**
 * Köpenyt reprezentáló osztály
 */
public class Cape extends Equipment {
    private static int id = 0;
    private CapeDefenseBehavior capeDefenseBehavior;

    /**
     * Cape constructor
     * @param field This is the field (shelter), that the cape is on.
     */
    public Cape(Shelter field) {
        this.name = "cpe" + id++;
        this.currPosition = field;
    }

    /**
     * Cape constructor without any parameters.
     * Should be used when adding to the inventory directly.
     */
    public Cape() {
        this.name = "cpe" + id++;
        this.currPosition = null;
    }

    /**
     * Hozzáadja a megadott virológus verméhez a Cape-ből adódó viselkedést.
     *
     * @param v virológus, akinek a vermébe bele fog kerülni a Cape-ből adódó viselkedés
     */
    @Override
    public void addBehaviour(Virologist v) {
        this.capeDefenseBehavior = new CapeDefenseBehavior(v);
        v.add(capeDefenseBehavior);
    }

    /**
     * Törli a megadott virológus verméből a Cape-ből adódó viselkedést.
     *
     * @param v virológus, akinek a verméből törlődni fog a Cape-ből adódó viselkedés
     */
    @Override
    public void removeBehavior(Virologist v) {
        v.remove(capeDefenseBehavior);
    }
}
