package equipments;

import PropertyHandler.PropertyHandler;
import behaviors.GloveDefBehavior;
import virologist.Virologist;

public class Cape extends Equipment{

    //private CapeWithGloveDef capeWithGloveDef;
    //private GloveDefBehavior gloveDef;

    public Cape() {
        super();
    }

    @Override
    public void AddBehToStack(Virologist v) {
        v.setDefenseBehaviors(new GloveDefBehavior(v));
    }

    @Override
    public void RemoveBehFromStack() {
        ////////
    }

    @Override
    public void BeCollected(PropertyHandler ph) {
        ph.AddEquipment(this);
    }

    @Override
    public void BeRemoved(PropertyHandler ph) {
        ph.RemoveEqupment(this);
    }
}
