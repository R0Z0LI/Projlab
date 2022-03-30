package Equipments;

import PropertyHandler.PropertyHandler;
import Virologist.Virologist;

public class Sack extends Equipment {

    public Sack() {
        super();
    }

    /**
     * +
     * Megnöveli a megadott virológus által felvehető anyagmennyiséget.
     *
     * @param v virológus, akinek max anyagmennyisége megváltozik
     */
    @Override
    public void addBehaviour(Virologist v) {
        System.out.println("-> addBehToStack(Virologist v)\n! Megnöveli a megadott virológus által felvehető anyagmennyiséget.\n\n");
        v.getPropertyHandler().setMaxMaterial(1);
    }

    @Override
    public void removeBehavior(Virologist v) {

    }

    /**
     * +
     * Begyűjteti magát a virológus PropertyHandlerével.
     *
     * @param propertyHandler amihez hozzá kell adni a felvett Sack-et
     */
    @Override
    public void beCollected(PropertyHandler propertyHandler) {
        if (propertyHandler.getEquipments().size() < propertyHandler.getMaxEquipment()) {
            propertyHandler.add(this);
            System.out.println("-> beCollected(PropertyHandler propertyHandler)\n! Begyűjteti magát a virológus PropertyHandlerével.\n\n");
        }
    }

    /**
     * +
     * Törli magát a virológus PropertyHandleréből.
     *
     * @param propertyHandler amiből törölni kell a törlendő Sack-et
     */
    @Override
    public void beRemoved(PropertyHandler propertyHandler) {
        propertyHandler.remove(this);
        System.out.println("-> beRemoved(PropertyHandler propertyHandler)\n! Törli magát a virológus PropertyHandleréből.\n\n");

    }
}
