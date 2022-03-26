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
    private Stack<MovementBehavior> movementBehaviors = new Stack<>();
    private Stack<CreateBehavior> createBehaviors = new Stack<>();
    private Stack<ApplyBehavior> applyBehaviors = new Stack<>();
    private Stack<CollectBehavior> collectBehaviors = new Stack<>();
    private Stack<StealBehavior> stealBehaviors = new Stack<>();
    private Stack<DefenseBehavior> defenseBehaviors = new Stack<>();

    public Virologist(){

    }

    public Virologist(int actionCounter, PropertyHandler myProperties, Field currField){
        this.actionCounter = actionCounter;
        this.currField = currField;
        this.myProperties = myProperties;
        CollectBehavior collectBehavior = new CollectBehavior();
        ApplyBehavior applyBehavior = new ApplyBehavior();
        CreateBehavior createBehavior = new CreateBehavior();
        DefenseBehavior defenseBehavior = new DefenseBehavior();
        MovementBehavior movementBehavior = new MovementBehavior();
        StealBehavior stealBehavior = new StealBehavior();
        this.applyBehaviors.add(applyBehavior);
        this.collectBehaviors.add(collectBehavior);
        this.createBehaviors.add(createBehavior);
        this.defenseBehaviors.add(defenseBehavior);
        this.movementBehaviors.add(movementBehavior);
        this.stealBehaviors.add(stealBehavior);
    }

    /**
     * A collectBeh első elemétől függően meghívja a CollectBehavior objekt leszármazottjának
     * a Collect metódusát, ezzel elindítva a begyűjtés folyamatát
     * @param collectible     Amit összegyűjt
     */
    public void Collect(Collectible collectible){
        System.out.print("-> Collect(Collectible collectible)\n! A collectBeh első elemétől függően meghívja a CollectBehavior objekt leszármazottjának\n" +
                " a Collect metódusát, ezzel elindítva a begyűjtés folyamatát\n\n");
        collectBehaviors.firstElement().collect(collectible, myProperties);
    }

    /**
     * A MovementBeh első elemétől függően meghívja a MovementBehavior objekt leszármazottjának
     * a Step metódusát, ezzel elindítva a mozgás folyamatát
     * @param field             A mező ahova lépni szeretne a virológus
     */
    public void Step(Field field){
        System.out.println("-> Step(Field field)\n! A MovementBeh első elemétől függően meghívja a MovementBehavior objekt leszármazottjának\n" +
                " a Step metódusát, ezzel elindítva a mozgás folyamatát\n\n");
        movementBehaviors.firstElement().move(this.currField, field);
    }

    /**
     * A StealBeh első elemétől függően meghívja a StealBehavior objekt leszármazottjának
     * Steal metódusát, ezzel elindítva a lopás folyamatát
     * @param collectibel       A tárgy amit el akar lopni
     * @param affected          A virológus akitől el akarja lopni
     */
    public void Steal(Collectible collectibel, Virologist affected){
        System.out.print("-> Steal(Collectible collectibel, Virologist affected)\n! A StealBeh első elemétől függően meghívja a StealBehavior objekt leszármazottjának\n" +
                " Steal metódusát, ezzel elindítva a lopás folyamatát\n\n");
        stealBehaviors.firstElement().steal(collectibel, affected, myProperties);
    }

    /**
     * A CreateBeh első elemétől függően meghívja a CreateBehavior objekt leszármazottjának
     * CreateAgent metódusát, ezzel elindítva a lopás folyamatát
     * @param genCode           A genetikai kód amiből létre akarja hozni az ágenst
     */
    public void CreateAgent(GenCode genCode){
        System.out.println("-> CreateAgent(GenCode genCode)\n! A CreateBeh első elemétől függően meghívja a CreateBehavior objekt leszármazottjának\n" +
                " CreateAgent metódusát, ezzel elindítva a lopás folyamatát\n\n");
        createBehaviors.firstElement().create(genCode);
    }

    /**
     * Az ApplyBeh első elemétől függően meghívja az ApplyBehavior objekt leszármazottjának
     * ApplyAgent metódusát, ezzel elindítva a lopás folyamatát
     * @param agent             Amit rá akar kenni
     * @param affected          Akire rá akarja kenni
     */
    public void ApplyAgent(Agent agent, Virologist affected){
        System.out.println("-> ApplyAgent(Agent agent, Virologist affected)\n! Az ApplyBeh első elemétől függően meghívja az ApplyBehavior objekt leszármazottjának\n" +
                " ApplyAgent metódusát, ezzel elindítva a lopás folyamatát\n\n");
        applyBehaviors.firstElement().apply(agent, affected);
    }

    /**
     * Elindítja a virológus körét
     */
    public void YourTurn(){
        System.out.println("-> YourTurn()\n! Elindítja a virológus körét\n\n");
    }

    /**
     * A DefenseBeh első elemétől függően meghívja az DefenseBehavior objekt leszármazottjának
     * Defend metódusát, ezzel elindítva a lopás folyamatát
     * @param agent             Az ágens amit rákentek
     * @param attacker          Aki rákente
     */
    public void BeInfected(Agent agent, Virologist attacker){
        System.out.println("-> BeInfected(Agent agent, Virologist attacker)\n! A DefenseBeh első elemétől függően meghívja az DefenseBehavior objekt leszármazottjának\n" +
                " Defend metódusát, ezzel elindítva a lopás folyamatát\n\n");
        defenseBehaviors.firstElement().defend(agent, attacker);
    }

    /**
     * Elpusztítja a virológus egyik, a játékos által választott felszerelését
     * @param e                 Ezt a felszerelést pusztítja el
     */
    public void DestroyEquipment(Equipment e){
        System.out.println("-> DestroyEquipment(Equipment e)\n! Elpusztítja a virológus egyik, a játékos által választott felszerelését\n\n");
    }

    /**
     * currField settere
     * @param after             Erre változtatja meg
     */
    public void setCurrField(Field after) {
        System.out.println("-> setCurrField(Field after)\n! currField settere\n\n");
        this.currField = after;
    }

    /**
     * applyBeh settere
     * @param applyBehavior     Ezt az elemet adja hozzá
     */
    public void setApplyBehaviors(ApplyBehavior applyBehavior) {
        System.out.println("-> setApplyBeh(ApplyBehavior applyBehavior)\n! applyBeh settere\n\n");
        this.applyBehaviors.add(applyBehavior);
    }

    /**
     * defenseBeh settere
     * @param defenseBehavior   Ezt az elemet adja hozzá
     */
    public void setDefenseBehaviors(DefenseBehavior defenseBehavior) {
        System.out.println("-> setDefenseBeh(DefenseBehavior defenseBehavior)\n! defenseBeh settere\n\n");
        this.defenseBehaviors.add(defenseBehavior);
    }

    /**
     * Visszaadja a PropertyHandlerét a virológusnak
     * @return                  A myProperties-el tér vissza
     */
    public PropertyHandler getPropertyHandler(){
        System.out.println("-> getPropertyHandler()\n! Visszaadja a PropertyHandlerét a virológusnak\n\n");
        return myProperties;
    }

    /**
     *
     * @param stunnedMove
     */
    public void AddMoveBeh(StunnedMoveBehavior stunnedMove) {

    }

    public void AddCrazyMoveBeh(CrazyMoveBehavior crazyMoveBehavior){

    }

    public void AddApplyBeh(StunnedApplyBehavior stunnedApply) {

    }

    public void AddCreateBeh(StunnedCreateBehavior stunnedCreate) {

    }

    public void AddCollectBeh(StunnedCollectBehavior stunnedCollect) {

    }

    public void AddStealBeh(StunnedStealBehavior stunnedSteal) {

    }

    public void RemoveMoveBeh(StunnedMoveBehavior stunnedMove) {

    }

    public void RemoveCrazyMoveBeh(CrazyMoveBehavior crazyMoveBehavior){

    }

    public void RemoveApplyBeh(StunnedApplyBehavior stunnedApply) {

    }

    public void RemoveCreateBeh(StunnedCreateBehavior stunnedCreate) {

    }

    public void RemoveCollectBeh(StunnedCollectBehavior stunnedCollect) {

    }

    public void RemoveStealBeh(StunnedStealBehavior stunnedSteal) {

    }

    public void RemoveDefenseBeh(DefAgentDefBehavior defAgentDef) {

    }

    public void AddDefenseBeh(DefAgentDefBehavior defAgentDef) {

    }
}
