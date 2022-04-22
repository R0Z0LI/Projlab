package Equipments;

import Field.Shelter;
import PropertyHandler.PropertyHandler;
import Virologist.Virologist;

/**
 * Zsákot reprezentáló osztály.
 */
public class Sack extends Equipment {
    private static int id = 0;
    // the extra inventory space given
    private int extraSpace = 5; // default value = 5

    /**
     * Sack constructor
     * @param field This is the field (shelter), that the sack is on.
     */
    public Sack(Shelter field) {
        this.name = "sck" + id++;
        this.currPosition = field;
    }

    /**
     * Sack constructor without any parameters.
     * Should be used when adding to the inventory directly.
     */
    public Sack() {
        this.name = "sck" + id++;
        this.currPosition = null;
    }

    /**
     * Megnöveli a megadott virológus által felvehető anyagmennyiséget.
     *
     * @param v virológus, akinek max anyagmennyisége megváltozik
     */
    @Override
    public void addBehaviour(Virologist v) {
        v.getPropertyHandler().changeMaxMaterial(extraSpace);
    }

    /**
     * Csökkenti a megadott virológus által felvehető anyagmennyiséget.
     *
     * @param v virológus, akinek max anyagmennyisége megváltozik
     */
    @Override
    public void removeBehavior(Virologist v) {
        v.getPropertyHandler().changeMaxMaterial(-extraSpace);
    }
}
