package virologist;

import Collectible.Collectible;
import Field.Field;
import PropertyHandler.PropertyHandler;
import agent.Agent;
import behaviors.*;
import equipments.Equipment;
import gencode.GenCode;

import java.util.Stack;

/**
 * A virológust reprezentáló osztály
 */
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

    /**
     * A collectBeh első elemétől függően meghívja a CollectBehavior objekt leszármazottjának
     * a Collect metódusát, ezzel elindítva a begyűjtés folyamatát
     * @param collectible     Amit összegyűjt
     */
    public void Collect(Collectible collectible){
        collectBeh.firstElement().Collect(collectible, myProperties);
    }

    /**
     * A MovementBeh első elemétől függően meghívja a MovementBehavior objekt leszármazottjának
     * a Step metódusát, ezzel elindítva a mozgás folyamatát
     * @param field             A mező ahova lépni szeretne a virológus
     */
    public void Step(Field field){
        moveBeh.firstElement().Move(this.currField, field);
    }

    /**
     * A StealBeh első elemétől függően meghívja a StealBehavior objekt leszármazottjának
     * Steal metódusát, ezzel elindítva a lopás folyamatát
     * @param collectibel       A tárgy amit el akar lopni
     * @param affected          A virológus akitől el akarja lopni
     */
    public void Steal(Collectible collectibel, Virologist affected){
        stealBeh.firstElement().Steal(collectibel, affected, myProperties);
    }

    /**
     * A CreateBeh első elemétől függően meghívja a CreateBehavior objekt leszármazottjának
     * CreateAgent metódusát, ezzel elindítva a lopás folyamatát
     * @param genCode           A genetikai kód amiből létre akarja hozni az ágenst
     */
    public void CreateAgent(GenCode genCode){
        createBeh.firstElement().Create(genCode);
    }

    /**
     * Az ApplyBeh első elemétől függően meghívja az ApplyBehavior objekt leszármazottjának
     * ApplyAgent metódusát, ezzel elindítva a lopás folyamatát
     * @param agent             Amit rá akar kenni
     * @param affected          Akire rá akarja kenni
     */
    public void ApplyAgent(Agent agent, Virologist affected){
        applyBeh.firstElement().Apply(agent, affected);
    }

    /**
     * Elindítja a virológus körét
     */
    public void YourTurn(){

    }

    /**
     * Az DefenseBeh első elemétől függően meghívja az DefenseBehavior objekt leszármazottjának
     * Defend metódusát, ezzel elindítva a lopás folyamatát
     * @param agent             Az ágens amit rákentek
     * @param attacker          Aki rákente
     */
    public void BeInfected(Agent agent, Virologist attacker){
        defenseBeh.firstElement().Defend(agent, attacker);
    }

    public void BeStolen(){

    }

    /**
     * Elpusztítja a virológus egyik, a játékos által választott felszerelését
     * @param e                 Ezt a felszerelést pusztítja el
     */
    public void DestroyEquipment(Equipment e){

    }

    /**
     * currField settere
     * @param after             Erre változtatja meg
     */
    public void setCurrField(Field after) {
        this.currField = after;
    }

    /**
     * applyBeh settere
     * @param applyBehavior     Ezt az elemet adja hozzá
     */
    public void setApplyBeh(ApplyBehavior applyBehavior) {
        this.applyBeh.add(applyBehavior);
    }

    /**
     * defenseBeh settere
     * @param defenseBehavior   Ezt az elemet adja hozzá
     */
    public void setDefenseBeh(DefenseBehavior defenseBehavior) {
        this.defenseBeh.add(defenseBehavior);
    }

    /**
     * Visszaadja a PropertyHandlerét a virológusnak
     * @return                  A myProperties-el tér vissza
     */
    public PropertyHandler getPropertyHandler(){
        return myProperties;
    }
}
