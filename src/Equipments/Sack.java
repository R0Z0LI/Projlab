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
        System.out.println("-> addBehToStack(Virologist v)\n! Megnoveli a megadott virológus által felveheto anyagmennyiséget.\n\n");
        v.getPropertyHandler().setMaxMaterial(extraSpace);
    }

    /**
     * Csökkenti a megadott virológus által felvehető anyagmennyiséget.
     *
     * @param v virológus, akinek max anyagmennyisége megváltozik
     */
    @Override
    public void removeBehavior(Virologist v) {
        v.getPropertyHandler().setMaxMaterial(-extraSpace);
    }

    /**
     * Begyűjteti magát a virológus PropertyHandlerével.
     *
     * @param propertyHandler amihez hozzá kell adni a felvett Sack-et
     */
    @Override
    public void beCollected(PropertyHandler propertyHandler) {
        if (propertyHandler.getEquipments().size() < propertyHandler.getMaxEquipment()) {
            propertyHandler.add(this);
            System.out.println("-> beCollected(PropertyHandler propertyHandler)\n! Begyujteti magát a virológus PropertyHandlerével.\n\n");
        }
    }

    /**
     * Törli magát a virológus PropertyHandleréből.
     *
     * @param propertyHandler amiből törölni kell a törlendő Sack-et
     */
    @Override
    public void beRemoved(PropertyHandler propertyHandler) {
        propertyHandler.remove(this);
        System.out.println("-> beRemoved(PropertyHandler propertyHandler)\n! Torli magát a virológus PropertyHandlerébol.\n\n");
    }
}
