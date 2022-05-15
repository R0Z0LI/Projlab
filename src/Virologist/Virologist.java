package Virologist;

import Collectible.Collectible;
import Field.Field;
import Graphics.CommandView;
import Graphics.FieldView;
import Graphics.GameFrame;
import Graphics.VirologistView;
import PropertyHandler.PropertyHandler;
import Agent.Agent;
import Behaviors.*;
import Equipments.Equipment;
import Gencode.GenCode;
import Game.Game;

import java.util.*;

/**
 * A virológust reprezentáló osztály
 */
public class Virologist {
    private String name;
    private static int id = 0;
    private int actionCounter;

    private CommandView myCommandView;
    private VirologistView myViroView;
    private PropertyHandler myProperties;
    private Field currentField;
    private Stack<MovementBehavior> movementBehaviors = new Stack<>();
    private Stack<CreateBehavior> createBehaviors = new Stack<>();
    private Stack<ApplyBehavior> applyBehaviors = new Stack<>();
    private Stack<CollectBehavior> collectBehaviors = new Stack<>();
    private Stack<StealBehavior> stealBehaviors = new Stack<>();
    private Stack<DefenseBehavior> defenseBehaviors = new Stack<>();
    private Stack<AutomaticBehavior> automaticBehaviors = new Stack<>();
    private Stack<AttackBehavior> attackBehaviors = new Stack<>();

    public Virologist(String name) {
        this.name = name;
        this.actionCounter = 3;
        this.myProperties = new PropertyHandler(this);

        this.movementBehaviors.add(new MovementBehavior(this));
        this.createBehaviors.add(new CreateBehavior(this));
        this.applyBehaviors.add(new ApplyBehavior(this));
        this.collectBehaviors.add(new CollectBehavior(this));
        this.stealBehaviors.add(new StealBehavior(this));
        this.defenseBehaviors.add(new DefenseBehavior(this));
        this.automaticBehaviors.add(new AutomaticBehavior(this));
        this.attackBehaviors.add(new AttackBehavior(this));

        myViroView = new VirologistView(id++);
        myCommandView = new CommandView(this);
    }
    public Virologist(Field field) {
        this.name = "vir" + id++;
        currentField = field;
        this.actionCounter = 3;
        this.myProperties = new PropertyHandler(this);

        this.movementBehaviors.add(new MovementBehavior(this));
        this.createBehaviors.add(new CreateBehavior(this));
        this.applyBehaviors.add(new ApplyBehavior(this));
        this.collectBehaviors.add(new CollectBehavior(this));
        this.stealBehaviors.add(new StealBehavior(this));
        this.defenseBehaviors.add(new DefenseBehavior(this));
        this.automaticBehaviors.add(new AutomaticBehavior(this));
        this.attackBehaviors.add(new AttackBehavior(this));

        myViroView = new VirologistView(id);
        myCommandView = new CommandView(this);
    }

    public String getName() {
        return name;
    }

    /**
     * A collectBeh első elemétől függően meghívja a CollectBehavior objekt leszármazottjának
     * a Collect metódusát, ezzel elindítva a begyűjtés folyamatát
     *
     * @param collectible Amit összegyűjt
     */
    public void collect(Collectible collectible) {
        if(collectible==null){
            System.out.println("There is no such thing on this field.");
            return;
        }
        collectBehaviors.firstElement().collect(collectible, myProperties);
        actionCounter--;
    }

    /**
     * A MovementBeh első elemétől függően meghívja a MovementBehavior objekt leszármazottjának
     * a Step metódusát, ezzel elindítva a mozgás folyamatát
     *
     * @param field A mező ahova lépni szeretne a virológus
     */
    public void step(Field field) {
        if(field==null){
            System.out.println("You can't move there, it's not your neighbor. \n");
            return;
        }
        movementBehaviors.firstElement().move(this.currentField, field);
        actionCounter--;
    }

    /**
     * A StealBeh első elemétől függően meghívja a StealBehavior objekt leszármazottjának
     * Steal metódusát, ezzel elindítva a lopás folyamatát
     *
     * @param collectible A tárgy amit el akar lopni
     * @param affected    A virológus akitől el akarja lopni
     */
    public void steal(Collectible collectible, Virologist affected)  {
        if(affected.getStealableThings() == null) {
            System.out.println("This virologist is not paralysed.");
            return;
        }
        if(affected.getStealableThings().contains(collectible)) {
            stealBehaviors.firstElement().steal(collectible, affected, myProperties);
            actionCounter--;
        }
        else {
            System.out.println("The virologist does not have that equipment.");
        }
    }

    /**
     * A CreateBeh első elemétől függően meghívja a CreateBehavior objekt leszármazottjának
     * CreateAgent metódusát, ezzel elindítva a lopás folyamatát
     *
     * @param genCode A genetikai kód amiből létre akarja hozni az ágenst
     */
    public void createAgent(GenCode genCode) {
        if(genCode==null){
            System.out.println("You don't own this code.");
            return;
        }
        createBehaviors.firstElement().create(genCode);
        actionCounter--;
    }

    /**
     * Az ApplyBeh első elemétől függően meghívja az ApplyBehavior objekt leszármazottjának
     * ApplyAgent metódusát, ezzel elindítva a lopás folyamatát
     *
     * @param agent    Amit rá akar kenni
     * @param affected Akire rá akarja kenni
     */
    public void applyAgent(Agent agent, Virologist affected) {
        if(agent==null){
            System.out.println("You don't own this agent.");
            return;
        }
        if(affected==null){
            System.out.println("You can't see that virologist.");
            return;
        }
        applyBehaviors.firstElement().apply(agent, affected);
        //ha már felhasználta, el lesz távolítva
        myProperties.remove(agent);
        actionCounter--;
    }

    /**
     * megpróbálja megölni a másik virológust
     * @param victim akit meg kell ölni
     */
    public void attack(Virologist victim){
        if(victim==null){
            System.out.println("You can't see that virologist.");
            return;
        }
        attackBehaviors.firstElement().attack(victim);
        actionCounter--;
    }

    /**
     * Elpusztítja a virológus egyik, a játékos által választott felszerelését
     *
     * @param equipment Ezt a felszerelést pusztítja el
     */
    public void destroy(Equipment equipment) {
        if(equipment==null){
            System.out.println("The virologist does not have that equipment.");
            return;
        }
        myProperties.remove(equipment);
        actionCounter--;
    }

    /**
     * Elindítja a virológus körét
     * A játékos parancsait beolvassa, értelmezi
     */
    public void yourTurn() {
        actionCounter = 3;

        myCommandView.update();
        myCommandView.activateView();

        //meghívja az automatikus viselkedést
        automaticBehaviors.firstElement().execute();
    }

    public int getActionCounter() { return actionCounter; }

    public String toString(){
        return name+"\n"+myProperties.toString()+"\n"+name;
    }

    /**
     * A DefenseBeh első elemétől függően meghívja az DefenseBehavior objekt leszármazottjának
     * Defend metódusát
     *
     * @param agent    Az ágens amit rákentek
     * @param attacker Aki rákente
     */
    public void beInfected(Agent agent, Virologist attacker) {
        defenseBehaviors.firstElement().defend(agent, attacker);
    }

    public void beKilled(){
        Game.removeVirologist(this);
        System.out.println(name+ " died.");
    }

    /**
     * currentField settere
     *
     * @param field Erre változtatja meg
     */
    public void setCurrentField(Field field) {
        this.currentField = field;
    }

    /**+
     *
     * @return pozíció
     */
    public Field getCurrentField(){return currentField;}

    /**
     * Visszaadja a PropertyHandlerét a virológusnak
     *
     * @return A myProperties-el tér vissza
     */
    public PropertyHandler getPropertyHandler() {
        return myProperties;
    }

    /**
     * beállítja az actionCounter értékét
     * @param actionCount az új érték
     */
    public void setActionCounter(int actionCount){actionCounter=actionCount;}

    /**
     * A megadott számmal csökkenti at actionCounter értékét
     * @param number csökkentés
     */
    public void decreaseActionCounter(int number){
        actionCounter-=number;
    }

    /**
     * visszaadja a virológust megjelenítő objektumot
     * @return
     */
    public VirologistView getVirologistView(){
        return myViroView;
    }

    /**
     * visszaadja a CommandView-t
     * @return
     */
    public CommandView getCommandView(){
        return myCommandView;
    }

    /**
     * visszaadja a virológustól ellopható dolgokat
     * @return ellopható dolgok
     */
    public ArrayList<Collectible> getStealableThings(){
        ArrayList<Collectible> stealables = automaticBehaviors.firstElement().getStealables(myProperties);
        return stealables;
    }

    /**
     * applyBeh settere
     *
     * @param beh Ezt az elemet adja hozzá
     */
    public void add(ApplyBehavior beh) {
        this.applyBehaviors.add(0,beh);
    }

    /**
     * automatikus behavior hozzáadása
     * @param beh
     */
    public void add(AutomaticBehavior beh){
        this.automaticBehaviors.add(0,beh);
    }

    /**
     * támadási viselkedés hozzáadása
     * @param beh
     */
    public void add(AttackBehavior beh){
        this.attackBehaviors.add(0,beh);
    }

    /**
     * defenseBeh settere
     *
     * @param beh Ezt az elemet adja hozzá
     */
    public void add(DefenseBehavior beh) {
        this.defenseBehaviors.add(beh);
        defenseBehaviors.sort(Comparator.comparingInt(DefenseBehavior::getPriority));
        Collections.reverse(defenseBehaviors);
    }

    /**
     * stealBeh settere
     *
     * @param beh Ezt az elemet adja hozzá
     */
    public void add(StealBehavior beh) {
        this.stealBehaviors.add(0,beh);
    }

    /**
     * collectBehavior settere
     *
     * @param beh Ezt az elemet adja hozzá
     */
    public void add(CollectBehavior beh) {
        this.collectBehaviors.add(0,beh);
    }

    /**
     * createBehavior settere
     *
     * @param beh Ezt az elemet adja hozzá
     */
    public void add(CreateBehavior beh) {
        this.createBehaviors.add(0,beh);
    }

    /**
     * movementBehavior settere
     *
     * @param beh Ezt az elemet adja hozzá
     */
    public void add(MovementBehavior beh) {
        this.movementBehaviors.add(0,beh);
    }
    //TODO kell-e még most is

    /**
     * Újra sorba állítja a defense Behavior gyűjteményét prioritás szerint.
     */
    public void resortDefenseBehaviors() {
        defenseBehaviors.sort((d1, d2) -> d2.getPriority() - d1.getPriority());
    }

    /**
     * lveszi a stack-ből a paraméterként adott behavior-t
     *
     * @param beh Ezt a behavior-t veszi el
     */
    public void remove(MovementBehavior beh) {
        this.movementBehaviors.remove(beh);
    }

    /**
     * eltávolítja az automatikus viselkedést
     * @param beh
     */
    public void remove(AutomaticBehavior beh){
        automaticBehaviors.remove(beh);
    }

    /**
     * eltávolítja a támadási viselkedést
     * @param beh
     */
    public void remove(AttackBehavior beh){
        attackBehaviors.remove(beh);
    }

    //TODO kell?
    /**
     * Elveszi a stack-ből a paraméterként adott behavior-t
     *
     * @param beh Ezt a behavior-t veszi el
     */
    public void remove(ApplyBehavior beh) {
        this.applyBehaviors.remove(beh);
    }

    //TODO kell?
    /**
     * Elveszi a stack-ből a paraméterként adott behavior-t
     *
     * @param beh Ezt a behavior-t veszi el
     */
    public void remove(CreateBehavior beh) {
        this.createBehaviors.remove(beh);
    }

    //TODO kell?
    /**
     * Elveszi a stack-ből a paraméterként adott behavior-t
     *
     * @param beh Ezt a behavior-t veszi el
     */
    public void remove(CollectBehavior beh) {
        this.collectBehaviors.remove(beh);
    }

    //TODO kell?
    /**
     * Elveszi a stack-ből a paraméterként adott behavior-t
     *
     * @param beh Ezt a behavior-t veszi el
     */
    public void remove(StealBehavior beh) {
        this.stealBehaviors.remove(beh);
    }

    /**
     * Elveszi a stack-ből a paraméterként adott behavior-t
     *
     * @param beh Ezt a behavior-t veszi el
     */
    public void remove(DefenseBehavior beh) {
        this.defenseBehaviors.remove(beh);
    }

    public CommandView getMyCommandView() {
        return myCommandView;
    }

    public void setMyCommandView(CommandView myCommandView) {
        this.myCommandView = myCommandView;
    }
}

