package Equipments;

import Behaviors.CapeDefenseBehavior;
import Field.Shelter;
import PropertyHandler.PropertyHandler;
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
        System.out.println("-> addBehToStack(Virologist v)\n! Hozzáadja a megadott virológus verméhez a Cape-bol adódó viselkedést.\n\n");
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
        System.out.println("-> removeBehFromStack(Virologist v)\n! Torli a megadott virológus verméből a Cape-ből adódó viselkedést.\n\n");
    }

    /**
     * Begyűjteti magát a virológus PropertyHandlerével.
     *
     * @param ph amihez hozzá kell adni a felvett Cape-t
     */
    @Override
    public void beCollected(PropertyHandler ph) {
        if (ph.getEquipments().size() < ph.getMaxEquipment()) {
            ph.add(this);
            System.out.println("-> beCollected(PropertyHandler ph)\n! Begyujteti magát a virológus PropertyHandlerével.\n\n");
        }
    }

    /**
     * Törli magát a virológus PropertyHandleréből.
     *
     * @param ph amiből törölni kell a törlendő Cape-t
     */
    @Override
    public void beRemoved(PropertyHandler ph) {
        ph.remove(this);
        System.out.println("-> beRemoved(PropertyHandler ph)\n! Torli magát a virológus PropertyHandleréből.\n\n");
    }
}
