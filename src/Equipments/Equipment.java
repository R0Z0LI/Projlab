package Equipments;

import Collectible.Collectible;
import Field.Shelter;
import PropertyHandler.PropertyHandler;
import TestSets.TestInOutHandler;
import Virologist.Virologist;

/**
 * Felszerelést reprezentáló osztály.
 */
public abstract class Equipment implements Collectible {
    protected Shelter currPosition;
    protected String name;

    /**
     * Empty Equipment constructor
     */
    public Equipment(){
        //
    }

    // gets name/id of this object
    public String getName() {
        return name;
    }

    /**
     * Hozzáadja a megadott virológus verméhez az adott Equipmentből adódó viselkedést.
     *
     * @param v   virológus, akinek a vermébe bele fog kerülni az adott Equipmentből adódó viselkedés
     */
    public abstract void addBehaviour(Virologist v);

    /**
     * Törli a megadott virológus verméből az adott Equipmentből adódó viselkedést.
     *
     * @param v   virológus, akinek a verméből törlődni fog az adott Equipmentből adódó viselkedés
     */
    public abstract void removeBehavior(Virologist v);

    /**
     * Begyűjteti magát a virológus PropertyHandlerével.
     *
     * @param propertyHandler amihez hozzá kell adni a felvett Equipment-et
     */
    @Override
    public void beCollected(PropertyHandler propertyHandler) {
        // only collect, if there is enough space in inventory
        if (propertyHandler.getEquipments().size() < propertyHandler.getMaxEquipment()) {
            // adding this to Virologist
            propertyHandler.add(this);
            System.out.println("Successful collect: "+ this.getName()+" collected by "+this.getName()+".");
            TestInOutHandler.appendToTestOutput("Successful collect: "+ this.getName()+" collected by "+this.getName()+".\n");

            // removing it from the shelter
            currPosition.remove(this);
        } else {
            System.out.println("There is not enough space in your inventory for " + this.getName());
            TestInOutHandler.appendToTestOutput("There is not enough space in your inventory for " + this.name);
        }
    }

    /**
     * Törli magát a virológus PropertyHandleréből.
     *
     * @param propertyHandler amiből törölni kell a törlendő Axe-t
     */
    @Override
    public void beRemoved(PropertyHandler propertyHandler) {
        propertyHandler.remove(this);
    }
}
