package Equipments;

import Field.Shelter;
import Behaviors.GloveDefBehavior;
import Virologist.Virologist;

/**
 * Kesztyűket reprezentáló osztály.
 */
public class Gloves extends Equipment {
    private static int id = 0;
    private int usability = 3; // default value = 3
    private GloveDefBehavior gloveDef;

    /**
     * Gloves constructor
     * @param field This is the field (shelter), that the gloves are on.
     */
    public Gloves(Shelter field) {
        this.name = "glv" + id++;
        this.currPosition = field;
    }

    /**
     * Gloves constructor without any parameters.
     * Should be used when adding to the inventory directly.
     */
    public Gloves() {
        this.name = "glv" + id++;
        this.currPosition = null;
    }

    /**
     * Hozzáadja a megadott virológus verméhez a Gloves-ból adódó viselkedést.
     *
     * @param v virológus, akinek a vermébe bele fog kerülni a Gloves-ból adódó viselkedés
     */
    @Override
    public void addBehaviour(Virologist v) {
        this.gloveDef = new GloveDefBehavior(v);
        v.add(gloveDef);
    }

    /**
     * Törli a megadott virológus verméből a Gloves-ból adódó viselkedést.
     *
     * @param v virológus, akinek a verméből törlődni fog a Gloves-ból adódó viselkedés
     */
    @Override
    public void removeBehavior(Virologist v) {
        v.remove(gloveDef);
    }
}
