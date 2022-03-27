package Equipments;

import PropertyHandler.PropertyHandler;
import Virologist.Virologist;

public class Sack extends Equipment{

    public Sack() {
        super();
    }

    @Override
    public void AddBehToStack(Virologist v) {
        v.getPropertyHandler().setMax_material(1);
    }

    @Override
    public void RemoveBehFromStack() {

    }

    @Override
    public void beCollected(PropertyHandler ph) {
        ph.AddEquipment(this);
    }

    @Override
    public void beRemoved(PropertyHandler ph) {
        ph.RemoveEquipment(this);
    }
}
