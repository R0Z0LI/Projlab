package virologist;

import Collectible.Collectible;
import Field.Field;
import PropertyHandler.PropertyHandler;
import Steppable.Agent;
import behaviors.*;
import Collectible.GenCode;
import Collectible.Equipment;

import java.util.List;
import java.util.Stack;

public class Virologist {
    private int actionCounter;
    private PropertyHandler myProperties;
    private Field currField;
    private Stack<MovementBehavior> moveBeh;
    private Stack<CreateBehavior> createBeh;
    private Stack<ApplyBehavior> applyBeh;
    private Stack<CollectBehavior> collectBeh;
    private Stack<StealBehavior> stealBeh;
    private Stack<DefenseBehavior> defenseBeh;

    public Virologist(int actionCounter, PropertyHandler myProperties, Field currField, Stack<MovementBehavior> moveBeh, Stack<CreateBehavior> createBeh,
                      Stack<ApplyBehavior> applyBeh, Stack<CollectBehavior> collectBeh, Stack<StealBehavior> stealBeh, Stack<DefenseBehavior> defenseBeh){
        this.actionCounter = actionCounter;
        this.applyBeh = applyBeh;
        this.collectBeh = collectBeh;
        this.createBeh = createBeh;
        this.currField = currField;
        this.defenseBeh = defenseBeh;
        this.moveBeh = moveBeh;
        this.myProperties = myProperties;
        this.stealBeh = stealBeh;
    }

    public void Collect(Collectible collectible){
        //if(collectBeh.firstElement().equals())
    }

    public void Step(Field field){

    }

    public void Steal(Collectible collectibel, Virologist affected){

    }

    public void CreateAgent(GenCode genCode){

    }

    public void ApplyAgent(Agent agent, Virologist affected){

    }

    public PropertyHandler GetPropertyHandler(){

    }

    public void YourTurn(){

    }

    public void BeInfected(Agent agent, Virologist attacked){

    }

    public void BeStolen(){

    }

    public void DestroyEquipment(Equipment e){

    }
}
