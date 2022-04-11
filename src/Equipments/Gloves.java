package Equipments;

import PropertyHandler.PropertyHandler;
import Behaviors.GloveDefBehavior;
import Virologist.Virologist;

public class Gloves extends Equipment {
    private int usability;
    private GloveDefBehavior gloveDef;

    public Gloves() {
        super();
    }

    /**
     * +
     * Hozzáadja a megadott virológus verméhez a Gloves-ból adódó viselkedést.
     *
     * @param v virológus, akinek a vermébe bele fog kerülni a Gloves-ból adódó viselkedés
     */
    @Override
    public void addBehaviour(Virologist v) {
        this.gloveDef = new GloveDefBehavior(v);
        //v.setDefenseBehaviors(gloveDef);
        v.add(gloveDef);
        System.out.println("-> addBehToStack(Virologist v)\n! Hozzáadja a megadott virológus verméhez a Cape-bol adódó viselkedést.\n\n");
    }

    /**
     * +
     * Törli a megadott virológus verméből a Gloves-ból adódó viselkedést.
     *
     * @param v virológus, akinek a verméből törlődni fog a Gloves-ból adódó viselkedés
     */
    @Override
    public void removeBehavior(Virologist v) {
        v.removeDefenseBeh(gloveDef);
        System.out.println("-> removeBehFromStack(Virologist v)\n! Torli a megadott virológus vermébol a Cape-bol adódó viselkedést.\n\n");

    }

    /**
     * +
     * Begyűjteti magát a virológus PropertyHandlerével.
     *
     * @param propertyHandler amihez hozzá kell adni a felvett Gloves-t
     */
    @Override
    public void beCollected(PropertyHandler propertyHandler) {
        if (propertyHandler.getEquipments().size() < propertyHandler.getMaxEquipment()) {
            System.out.println("-> beCollected(PropertyHandler propertyHandler)\n! A kesztyu be lesz gyujtve.\n\n");
            propertyHandler.add(this);
        }
    }

    /**
     * +
     * Törli magát a virológus PropertyHandleréből.
     *
     * @param ph amiből törölni kell a törlendő Gloves-t
     */
    @Override
    public void beRemoved(PropertyHandler ph) {
        ph.remove(this);
        System.out.println("-> beRemoved(PropertyHandler ph)\n! Törli magát a virológus PropertyHandleréből.\n\n");
    }
}
