package Equipments;

import Collectible.Collectible;
import Field.Shelter;
import PropertyHandler.PropertyHandler;
import Virologist.Virologist;

public abstract class Equipment implements Collectible {
    private Shelter currPosition;

    public Equipment(){}

    public void setCurrPosition(Shelter currPosition) {
        this.currPosition = currPosition;
    }

    public abstract void AddBehToStack(Virologist v);

    public abstract void RemoveBehFromStack();

    public abstract void beCollected(PropertyHandler ph);

    public abstract void beRemoved(PropertyHandler ph);
}
