package virologist;

import Collectible.Collectible;
import Field.Field;
import PropertyHandler.PropertyHandler;
import agent.Agent;
import behaviors.*;
import equipments.Equipment;
import gencode.GenCode;

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

    public Virologist(){

    }

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
        collectBeh.firstElement().Collect(collectible, myProperties);
    }

    public void Step(Field field){
        moveBeh.firstElement().Move(this.currField, field);
    }

    public void Steal(Collectible collectibel, Virologist affected){
        stealBeh.firstElement().Steal(collectibel, affected, myProperties);
    }

    public void CreateAgent(GenCode genCode){
        createBeh.firstElement().Create(genCode);
    }

    public void ApplyAgent(Agent agent, Virologist affected){
        applyBeh.firstElement().Apply(agent, affected);
    }

    public void YourTurn(){

    }

    public void BeInfected(Agent agent, Virologist attacker){
        defenseBeh.firstElement().Defend(agent, attacker);
    }

    public void BeStolen(){

    }

    public void DestroyEquipment(Equipment e){

    }

    public void setCurrField(Field after) {
        this.currField = after;
    }

    public void setApplyBeh(ApplyBehavior applyBehavior) {
        this.applyBeh.add(applyBehavior);
    }

    public void setDefenseBeh(DefenseBehavior defenseBehavior) {
        this.defenseBeh.add(defenseBehavior);
    }

    public PropertyHandler getPropertyHandler(){
        return myProperties;
    }
}
