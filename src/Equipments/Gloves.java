package Equipments;
import PropertyHandler.PropertyHandler;
import Behaviors.GloveDefBehavior;
import Virologist.Virologist;

public class Gloves extends Equipment{
    private int usability;
    //private CapeWithGloveDef capeWithGloveDef;
    private GloveDefBehavior gloveDef;

    public Gloves() {
        super();
    }

    @Override
    public void AddBehToStack(Virologist v) {
        v.setDefenseBehaviors(new GloveDefBehavior(v));
    }

    @Override
    public void RemoveBehFromStack() {
        //
    }

    @Override
    public void beCollected(PropertyHandler ph) {
        ph.addEquipment(this);
    }

    @Override
    public void beRemoved(PropertyHandler ph) {
        ph.removeEquipment(this);
    }
}
