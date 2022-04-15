package Virologist;

import Collectible.Collectible;
import Field.Field;
import PropertyHandler.PropertyHandler;
import Agent.Agent;
import Behaviors.*;
import Equipments.Equipment;
import Gencode.GenCode;

import java.util.Collections;
import java.util.Comparator;
import java.util.Stack;

/**
 * A virológust reprezentáló osztály
 */
public class Virologist {
    private String name;
    private static int id = 0;
    private int actionCounter;
    private PropertyHandler myProperties;
    private Field currentField;
    private Stack<MovementBehavior> movementBehaviors = new Stack<>();
    private Stack<CreateBehavior> createBehaviors = new Stack<>();
    private Stack<ApplyBehavior> applyBehaviors = new Stack<>();
    private Stack<CollectBehavior> collectBehaviors = new Stack<>();
    private Stack<StealBehavior> stealBehaviors = new Stack<>();
    private Stack<DefenseBehavior> defenseBehaviors = new Stack<>();

    public Virologist() {
        this.actionCounter = 2;
        this.myProperties = new PropertyHandler(this);
        MovementBehavior movementBehavior = new MovementBehavior(this);
        this.movementBehaviors.add(movementBehavior);
        CreateBehavior createBehavior = new CreateBehavior(this);
        this.createBehaviors.add(createBehavior);
        ApplyBehavior applyBehavior = new ApplyBehavior(this);
        this.applyBehaviors.add(applyBehavior);
        CollectBehavior collectBehavior = new CollectBehavior(this);
        this.collectBehaviors.add(collectBehavior);
        StealBehavior stealBehavior = new StealBehavior(this);
        this.stealBehaviors.add(stealBehavior);
        DefenseBehavior defenseBehavior = new DefenseBehavior(this);
        this.defenseBehaviors.add(defenseBehavior);
    }

    //TODO szükség van erre
    public Virologist(Field currentField) {
        this.name = "vir" + id++;
        this.currentField = currentField;
        currentField.addVirologist(this);

        this.myProperties = new PropertyHandler();
        MovementBehavior movementBehavior = new MovementBehavior(this);
        this.movementBehaviors.add(movementBehavior);
        CreateBehavior createBehavior = new CreateBehavior(this);
        this.createBehaviors.add(createBehavior);
        ApplyBehavior applyBehavior = new ApplyBehavior(this);
        this.applyBehaviors.add(applyBehavior);
        CollectBehavior collectBehavior = new CollectBehavior(this);
        this.collectBehaviors.add(collectBehavior);
        StealBehavior stealBehavior = new StealBehavior(this);
        this.stealBehaviors.add(stealBehavior);
        DefenseBehavior defenseBehavior = new DefenseBehavior(this);
        this.defenseBehaviors.add(defenseBehavior);
    }


    /**
     * A collectBeh első elemétől függően meghívja a CollectBehavior objekt leszármazottjának
     * a Collect metódusát, ezzel elindítva a begyűjtés folyamatát
     *
     * @param collectible Amit összegyűjt
     */
    public void collect(Collectible collectible) {
        System.out.print("-> Collect(Collectible collectible)\n! A virológus elinditja a begyujtés folyamatát.\n\n");
        collectBehaviors.firstElement().collect(collectible, myProperties);
    }

    /**
     * A MovementBeh első elemétől függően meghívja a MovementBehavior objekt leszármazottjának
     * a Step metódusát, ezzel elindítva a mozgás folyamatát
     *
     * @param field A mező ahova lépni szeretne a virológus
     */
    public void step(Field field) {
        System.out.println("-> Step(Field field)\n! A virológus elinditja a mozgás folyamatát.\n\n");
        movementBehaviors.firstElement().move(this.currentField, field);
    }

    /**
     * A StealBeh első elemétől függően meghívja a StealBehavior objekt leszármazottjának
     * Steal metódusát, ezzel elindítva a lopás folyamatát
     *
     * @param collectible A tárgy amit el akar lopni
     * @param affected    A virológus akitől el akarja lopni
     */
    public void steal(Collectible collectible, Virologist affected) {
        System.out.print("-> Steal(Collectible collectible, Virologist affected)\n! A virológus elinditja a lopás folyamatát\n\n");
        stealBehaviors.firstElement().steal(collectible, affected, myProperties);
    }

    /**
     * A CreateBeh első elemétől függően meghívja a CreateBehavior objekt leszármazottjának
     * CreateAgent metódusát, ezzel elindítva a lopás folyamatát
     *
     * @param genCode A genetikai kód amiből létre akarja hozni az ágenst
     */
    public void createAgent(GenCode genCode) {
        System.out.println("-> CreateAgent(GenCode genCode)\n! A virológus elinditja az ágens előállitásának folyamatát.\n\n");
        createBehaviors.firstElement().create(genCode);
    }

    /**
     * Az ApplyBeh első elemétől függően meghívja az ApplyBehavior objekt leszármazottjának
     * ApplyAgent metódusát, ezzel elindítva a lopás folyamatát
     *
     * @param agent    Amit rá akar kenni
     * @param affected Akire rá akarja kenni
     */
    public void applyAgent(Agent agent, Virologist affected) {
        System.out.println("-> ApplyAgent(Agent agent, Virologist affected)\n! A virológus elinditja a kenés folyamatát\n\n");
        applyBehaviors.firstElement().apply(agent, affected);
    }

    /**
     * Elindítja a virológus körét
     */
    public void yourTurn() {
        System.out.println("-> YourTurn()\n! Elinditja a virológus korét.\n\n");
    }

    /**
     * A DefenseBeh első elemétől függően meghívja az DefenseBehavior objekt leszármazottjának
     * Defend metódusát
     *
     * @param agent    Az ágens amit rákentek
     * @param attacker Aki rákente
     */
    public void beInfected(Agent agent, Virologist attacker) {
        System.out.println("-> BeInfected(Agent agent, Virologist attacker)\n! A virológus megpróbálja kivédeni a kenést\n\n");
        defenseBehaviors.firstElement().defend(agent, attacker);
    }

    /**
     * Elpusztítja a virológus egyik, a játékos által választott felszerelését
     *
     * @param equipment Ezt a felszerelést pusztítja el
     */
    public void destroy(Equipment equipment) {
        System.out.println("-> DestroyEquipment(Equipment equipment)\n! Elpusztitja a virológus egyik, a játékos által választott felszerelését.\n\n");
        myProperties.remove(equipment);
    }

    /**
     * currentField settere
     *
     * @param field Erre változtatja meg
     */
    public void setCurrentField(Field field) {
        System.out.println("-> setCurrField(Field field)\n! Beállitja a virológus pozicióját.\n\n");
        this.currentField = field;
    }

    /**
     * applyBeh settere
     *
     * @param applyBehavior Ezt az elemet adja hozzá
     */
    public void add(ApplyBehavior applyBehavior) {
        System.out.println("-> setApplyBeh(ApplyBehavior applyBehavior)\n! applyBehavior beállitva.\n\n");
        this.applyBehaviors.add(applyBehavior);
    }

    /**
     * defenseBeh settere
     *
     * @param defenseBehavior Ezt az elemet adja hozzá
     */
    public void add(DefenseBehavior defenseBehavior) {
        System.out.println("-> addDefenseBehavior(DefenseBehavior defenseBehavior)\n! defenseBehavior beállitva.\n");
        this.defenseBehaviors.add(defenseBehavior);
        defenseBehaviors.sort(Comparator.comparingInt(DefenseBehavior::getPriority));
        Collections.reverse(defenseBehaviors);
        System.out.println("! A védő stratégiák prioritás szerint sorba lettek rendezve. Az első lesz alkalmazva.\n\n");
    }

    /**
     * stealBeh settere
     *
     * @param stealBehavior Ezt az elemet adja hozzá
     */
    public void add(StealBehavior stealBehavior) {
        System.out.println("->  addStealBehavior(StealBehavior stealBehavior)\n! stealBehavior beállitva.\n\n");
        this.stealBehaviors.add(stealBehavior);
    }

    /**
     * collectBehavior settere
     *
     * @param cBehavior Ezt az elemet adja hozzá
     */
    public void add(CollectBehavior cBehavior) {
        System.out.println("-> addCollectBehavior(CollectBehavior collectBehavior)\n! collectBehavior beállitva.\n\n");
        this.collectBehaviors.add(cBehavior);
    }

    /**
     * createBehavior settere
     *
     * @param cBehavior Ezt az elemet adja hozzá
     */
    public void add(CreateBehavior cBehavior) {
        System.out.println("-> addCreateBehavior(CreateBehavior createBehavior)\n! createBehavior beállitva.\n\n");
        this.createBehaviors.add(cBehavior);
    }

    /**
     * movementBehavior settere
     *
     * @param movementBehavior Ezt az elemet adja hozzá
     */
    public void add(MovementBehavior movementBehavior) {
        System.out.println("-> addMoveBehavior(MovementBehavior movementBehavior)\n! moveBehavior beállitva.\n\n");
        this.movementBehaviors.add(movementBehavior);
    }

    /**
     * +
     * Újra sorba állítja a defense Behavior gyűjteményét prioritás szerint.
     */
    public void resortDefenseBehaviors() {
        defenseBehaviors.sort((d1, d2) -> {
            return d2.getPriority() - d1.getPriority();
        });
    }

    /**
     * Visszaadja a PropertyHandlerét a virológusnak
     *
     * @return A myProperties-el tér vissza
     */
    public PropertyHandler getPropertyHandler() {
        System.out.println("-> getPropertyHandler()\n");
        return myProperties;
    }

    /**
     * lveszi a stack-ből a paraméterként adott behavior-t
     *
     * @param stunnedMove Ezt a behavior-t veszi el
     */
    public void removeMoveBeh(StunnedMoveBehavior stunnedMove) {
        this.movementBehaviors.remove(stunnedMove);
    }

    /**
     * Elveszi a stack-ből a paraméterként adott behavior-t
     *
     * @param crazyMoveBehavior Ezt a behavior-t veszi el
     */
    public void removeCrazyMoveBeh(CrazyMoveBehavior crazyMoveBehavior) {
        this.movementBehaviors.remove(crazyMoveBehavior);
    }

    /**
     * Elveszi a stack-ből a paraméterként adott behavior-t
     *
     * @param stunnedApply Ezt a behavior-t veszi el
     */
    public void removeApplyBeh(StunnedApplyBehavior stunnedApply) {
        this.applyBehaviors.remove(stunnedApply);
    }

    /**
     * Elveszi a stack-ből a paraméterként adott behavior-t
     *
     * @param stunnedCreate Ezt a behavior-t veszi el
     */
    public void removeCreateBeh(StunnedCreateBehavior stunnedCreate) {
        this.createBehaviors.remove(stunnedCreate);
    }

    /**
     * Elveszi a stack-ből a paraméterként adott behavior-t
     *
     * @param stunnedCollect Ezt a behavior-t veszi el
     */
    public void removeCollectBeh(StunnedCollectBehavior stunnedCollect) {
        this.collectBehaviors.remove(stunnedCollect);
    }

    /**
     * Elveszi a stack-ből a paraméterként adott behavior-t
     *
     * @param stunnedSteal Ezt a behavior-t veszi el
     */
    public void removeStealBeh(StunnedStealBehavior stunnedSteal) {
        this.stealBehaviors.remove(stunnedSteal);
    }

    /**
     * Elveszi a stack-ből a paraméterként adott behavior-t
     *
     * @param defenseBehavior Ezt a behavior-t veszi el
     */
    public void removeDefenseBeh(DefenseBehavior defenseBehavior) {
        this.defenseBehaviors.remove(defenseBehavior);
    }

    public Stack<ApplyBehavior> getApplyBehaviors() {
        return applyBehaviors;
    }
}

