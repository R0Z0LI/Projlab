package Equipments;

import PropertyHandler.PropertyHandler;
import Virologist.Virologist;

public class Sack extends Equipment{

    public Sack() {
        super();
    }

    /**+
     * Megnöveli a megadott virológus által felvehető anyagmennyiséget.
     *
     * @param v   virológus, akinek max anyagmennyisége megváltozik
     */
    @Override
    public void addBehToStack(Virologist v) {
        System.out.println("-> addBehToStack(Virologist v)\n! Megnöveli a megadott virológus által felvehető anyagmennyiséget.\n\n");
        v.getPropertyHandler().setMax_material(1);
    }

    @Override
    public void removeBehFromStack(Virologist v) {

    }

    /**+
     * Begyűjteti magát a virológus PropertyHandlerével.
     *
     * @param ph   amihez hozzá kell adni a felvett Sack-et
     */
    @Override
    public void beCollected(PropertyHandler ph) {
        ph.addEquipment(this);
        System.out.println("-> beCollected(PropertyHandler ph)\n! Begyűjteti magát a virológus PropertyHandlerével.\n\n");

    }

    /**+
     * Törli magát a virológus PropertyHandleréből.
     *
     * @param ph   amiből törölni kell a törlendő Sack-et
     */
    @Override
    public void beRemoved(PropertyHandler ph) {
        ph.removeEquipment(this);
        System.out.println("-> beRemoved(PropertyHandler ph)\n! Törli magát a virológus PropertyHandleréből.\n\n");

    }
}
