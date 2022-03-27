package equipments;

import PropertyHandler.PropertyHandler;
import behaviors.GloveDefBehavior;
import virologist.Virologist;

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
        ph.AddEquipment(this);
        System.out.println("-> beCollected(PropertyHandler ph)\n! Begyűjteti magát a virológus PropertyHandlerével.\n\n");

    }

    /**+
     * Törli magát a virológus PropertyHandleréből.
     *
     * @param ph   amiből törölni kell a törlendő Cape-t
     */
    @Override
    public void beRemoved(PropertyHandler ph) {
        ph.RemoveEquipment(this);
        System.out.println("-> beRemoved(PropertyHandler ph)\n! Törli magát a virológus PropertyHandleréből.\n\n");

    }
}
