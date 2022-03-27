package equipments;
import PropertyHandler.PropertyHandler;
import behaviors.GloveDefBehavior;
import virologist.Virologist;

public class Gloves extends Equipment{
    private int usability;
    private GloveDefBehavior gloveDef;

    public Gloves() {
        super();
    }

    /**+
     * Hozzáadja a megadott virológus verméhez a Gloves-ból adódó viselkedést.
     *
     * @param v   virológus, akinek a vermébe bele fog kerülni a Gloves-ból adódó viselkedés
     */
    @Override
    public void addBehToStack(Virologist v) {
        this.gloveDef=new GloveDefBehavior(v);
        v.setDefenseBehaviors(gloveDef);
        System.out.println("-> addBehToStack(Virologist v)\n! Hozzáadja a megadott virológus verméhez a Cape-ből adódó viselkedést.\n\n");
    }

    /**+
     * Törli a megadott virológus verméből a Gloves-ból adódó viselkedést.
     *
     * @param v   virológus, akinek a verméből törlődni fog a Gloves-ból adódó viselkedés
     */
    @Override
    public void removeBehFromStack(Virologist v) {
        v.removeDefenseBeh(gloveDef);
        System.out.println("-> removeBehFromStack(Virologist v)\n! Törli a megadott virológus verméből a Cape-ből adódó viselkedést.\n\n");

    }

    /**+
     * Begyűjteti magát a virológus PropertyHandlerével.
     *
     * @param ph   amihez hozzá kell adni a felvett Gloves-t
     */
    @Override
    public void beCollected(PropertyHandler ph) {
        ph.AddEquipment(this);
        System.out.println("-> beCollected(PropertyHandler ph)\n! Begyűjteti magát a virológus PropertyHandlerével.\n\n");

    }

    /**+
     * Törli magát a virológus PropertyHandleréből.
     *
     * @param ph   amiből törölni kell a törlendő Gloves-t
     */
    @Override
    public void beRemoved(PropertyHandler ph) {
        ph.RemoveEquipment(this);
        System.out.println("-> beRemoved(PropertyHandler ph)\n! Törli magát a virológus PropertyHandleréből.\n\n");
    }
}
