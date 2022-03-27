package Equipments;

import PropertyHandler.PropertyHandler;
import Behaviors.GloveDefBehavior;
import Virologist.Virologist;

public class Cape extends Equipment{

    private GloveDefBehavior gloveDef;

    public Cape() {
        super();
    }

    /**+
     * Hozzáadja a megadott virológus verméhez a Cape-ből adódó viselkedést.
     *
     * @param v   virológus, akinek a vermébe bele fog kerülni a Cape-ből adódó viselkedés
     */
    @Override
    public void addBehToStack(Virologist v) {
        this.gloveDef=new GloveDefBehavior(v);
        v.addDefenseBehavior(gloveDef);
        System.out.println("-> addBehToStack(Virologist v)\n! Hozzáadja a megadott virológus verméhez a Cape-ből adódó viselkedést.\n\n");

    }

    /**+
     * Törli a megadott virológus verméből a Cape-ből adódó viselkedést.
     *
     * @param v   virológus, akinek a verméből törlődni fog a Cape-ből adódó viselkedés
     */
    @Override
    public void removeBehFromStack(Virologist v) {
        v.removeDefenseBeh(gloveDef);
        System.out.println("-> removeBehFromStack(Virologist v)\n! Törli a megadott virológus verméből a Cape-ből adódó viselkedést.\n\n");
    }

    /**+
     * Begyűjteti magát a virológus PropertyHandlerével.
     *
     * @param ph   amihez hozzá kell adni a felvett Cape-t
     */
    @Override
    public void beCollected(PropertyHandler ph) {
        if(ph.getEquipments().size() < ph.getMax_equipment()) {
            ph.addEquipment(this);
            System.out.println("-> beCollected(PropertyHandler ph)\n! Begyűjteti magát a virológus PropertyHandlerével.\n\n");
        }
    }

    /**+
     * Törli magát a virológus PropertyHandleréből.
     *
     * @param ph   amiből törölni kell a törlendő Cape-t
     */
    @Override
    public void beRemoved(PropertyHandler ph) {
        ph.removeEquipment(this);
        System.out.println("-> beRemoved(PropertyHandler ph)\n! Törli magát a virológus PropertyHandleréből.\n\n");
    }
}
