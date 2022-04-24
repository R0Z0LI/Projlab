package Virologist;

import Collectible.Collectible;
import Field.Field;
import PropertyHandler.PropertyHandler;
import Agent.Agent;
import Behaviors.*;
import Equipments.Equipment;
import Gencode.GenCode;
import Game.Game;
import TestSets.TestInOutHandler;

import java.util.*;

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
    private Stack<AutomaticBehavior> automaticBehaviors = new Stack<>();
    private Stack<AttackBehavior> attackBehaviors = new Stack<>();

    public Virologist(Field field) {
        this.name = "vir" + id++;
        this.actionCounter = 2;
        this.myProperties = new PropertyHandler(this);
        currentField = field;
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
        AutomaticBehavior automaticBehavior = new AutomaticBehavior(this);
        this.automaticBehaviors.add(automaticBehavior);
        AttackBehavior attackBehavior = new AttackBehavior(this);
        this.attackBehaviors.add(attackBehavior);
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
            TestInOutHandler.appendToTestOutput("There is no such thing on this field.\n");
            return;
        }
        collectBehaviors.firstElement().collect(collectible, myProperties);
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
            TestInOutHandler.appendToTestOutput("You can't move there, it's not your neighbor. \n");
            return;
        }
        movementBehaviors.firstElement().move(this.currentField, field);
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
            TestInOutHandler.appendToTestOutput("This virologist is not paralysed.\n");
            return;
        }
        if(affected.getStealableThings().contains(collectible))
            stealBehaviors.firstElement().steal(collectible, affected, myProperties);
        else {
            System.out.println("The virologist does not have that equipment.");
            TestInOutHandler.appendToTestOutput("The virologist does not have that equipment.\n");
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
            TestInOutHandler.appendToTestOutput("You don't own this code.\n");
            return;
        }
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
        if(agent==null){
            System.out.println("You don't own this agent.");
            TestInOutHandler.appendToTestOutput("You don't own this agent.\n");
            return;
        }
        if(affected==null){
            System.out.println("You can't see that virologist.");
            TestInOutHandler.appendToTestOutput("You can't see that virologist.\n");
            return;
        }
        applyBehaviors.firstElement().apply(agent, affected);
        //ha már felhasználta, el lesz távolítva
        myProperties.remove(agent);
    }
    /**+
     * megpróbálja megölni a másik virológust
     * @param victim akit meg kell ölni
     */
    public void attack(Virologist victim){
        if(victim==null){
            System.out.println("You can't see that virologist.");
            TestInOutHandler.appendToTestOutput("You can't see that virologist.\n");
            return;
        }
        attackBehaviors.firstElement().attack(victim);
    }
    /**
     * Elpusztítja a virológus egyik, a játékos által választott felszerelését
     *
     * @param equipment Ezt a felszerelést pusztítja el
     */
    public void destroy(Equipment equipment) {
        if(equipment==null){
            System.out.println("You don’t own this equipment.");
            TestInOutHandler.appendToTestOutput("You don’t own this equipment.\n");
            return;
        }
        myProperties.remove(equipment);
    }
    /**
     * Elindítja a virológus körét
     * A játékos parancsait beolvassa, értelmezi
     */
    public void yourTurn() {
        actionCounter=2;
        //meghívja az automatikus viselkedést
        automaticBehaviors.firstElement().execute();
        //amíg van akció, várja a játékos utasításait
        while(actionCounter>0){
            ArrayList<Virologist> viros = new ArrayList<>();
            viros.addAll(currentField.GetTouchableVirologists());
            System.out.println("Elerheto virologusok a mezon:");
            //kiírja az összes elérhető virológust
            for(Virologist v : viros){
                System.out.println(v.getName());
                //kiírja a virológusok lopható cuccait
               for(Collectible c : v.getStealableThings()) {
                   System.out.println(c.getName());
               }
            }
            //beolvassa a játékos parancsát
            Scanner scanner = new Scanner(System.in);
            String[] command = scanner.next().split(" ");
            switch(command[0]){
                case "Apply":
                    //megkeresi, kire kell kenni
                    Virologist affected=null;
                    for(Virologist v : viros)
                        if(v.getName().equals(command[2])) {
                            affected = v;
                            break;
                        }
                    //megkeresi, melyik ágenst kell kenni
                    Agent agent=null;
                    for(Agent a : myProperties.getAgents())
                        if(a.getName().equals(command[3])) {
                            agent=a;
                            break;
                        }
                    applyAgent(agent, affected);
                    break;
                case "Collect":

                    break;
                case "Create":
                    GenCode code=null;
                    //megkeresi, melyik kódról van szó
                    for(GenCode g : myProperties.getGenCodes().values())
                        if(g.getName().equals(command[2])){
                           code=g;
                           break;
                        }
                    createAgent(code);
                    break;
                case "Kill":
                    //megkeresi, kit kell megölni
                    Virologist victim=null;
                    for(Virologist v : viros)
                        if(v.getName().equals(command[2])) {
                            victim = v;
                            break;
                        }
                    attack(victim);
                    break;
                case "Move":
                    //megkeresi, hova kell menni
                    Field nextField = null;
                    for(Field f : currentField.getNeighbours())
                        if(f.getName().equals(command[2])){
                            nextField=f;
                            break;
                        }
                    step(nextField);
                    break;
                case "Steal":
                    //megkeresi, hogy kitől kell lopni
                    Virologist stealVictim=null;
                    for(Virologist v : viros)
                        if(v.getName().equals(command[2])) {
                            stealVictim = v;
                            break;
                        }
                    //megkeresi, hogy mit kell lopni
                    Collectible stealable=null;
                    for(Collectible c: stealVictim.getStealableThings())
                        if(c.getName().equals(command[3])){
                            stealable=c;
                            break;
                        }
                    steal(stealable, stealVictim);
                    break;
                case "Throw":
                    //megkeresi, hogy mit kell eldobni
                    Equipment equipment=null;
                    for(Equipment e: myProperties.getEquipments())
                        if(e.getName().equals(command[2])){
                            equipment=e;
                        }
                    destroy(equipment);
                    break;
            }
            actionCounter--;
        }
    }

    /**
     * Elindítja a virológus körét
     * A játékos parancsait beolvassa, értelmezi
     */
    public void yourTurn(String commands) {
        //meghívja az automatikus viselkedést
        automaticBehaviors.firstElement().execute();
        //amíg van akció, végrehajtja az utasításokat
        String[] command = commands.split(" ");
        if(actionCounter>0){
            ArrayList<Virologist> viros = new ArrayList<>();
            viros.addAll(currentField.GetTouchableVirologists());
            switch(command[0]){
                case "Apply":
                    //megkeresi, kire kell kenni
                    Virologist affected=null;
                    for(Virologist v : viros)
                        if(v.getName().equals(command[2])) {
                            affected = v;
                            break;
                        }
                    //megkeresi, melyik ágenst kell kenni
                    Agent agent=null;
                    for(Agent a : myProperties.getAgents())
                        if(a.getName().equals(command[3])) {
                            agent=a;
                            break;
                        }
                    applyAgent(agent, affected);
                    break;
                case "Collect":
                    collect(currentField.getCollectible());
                    break;
                case "Create":
                    GenCode code=null;
                    //megkeresi, melyik kódról van szó
                    for(GenCode g : myProperties.getGenCodes().values())
                        if(g.getName().equals(command[2])){
                            code=g;
                            break;
                        }
                    createAgent(code);
                    break;
                case "Kill":
                    //megkeresi, kit kell megölni
                    Virologist victim=null;
                    for(Virologist v : viros)
                        if(v.getName().equals(command[2])) {
                            victim = v;
                            break;
                        }
                    attack(victim);
                    break;
                case "Move":
                    //megkeresi, hova kell menni
                    Field nextField = null;
                    for(Field f : currentField.getNeighbours())
                        if(f.getName().equals(command[2])){
                            nextField=f;
                            break;
                        }
                    step(nextField);
                    break;
                case "Steal":
                    //megkeresi, hogy kitől kell lopni
                    Virologist stealVictim=null;
                    for(Virologist v : viros)
                        if(v.getName().equals(command[2])) {
                            stealVictim = v;
                            break;
                        }
                    //megkeresi, hogy mit kell lopni
                    Collectible stealable = null;
                    // if there is anyone stunned and there are stealable things
                    if (stealVictim != null && stealVictim.getStealableThings() != null) {
                        for (Collectible c : stealVictim.getStealableThings()) {
                            if (c.getName().equals(command[3])) {
                                stealable = c;
                                break;
                            }
                        }
                        steal(stealable, stealVictim);
                    }
                    break;
                case "Throw":
                    //megkeresi, hogy mit kell eldobni
                    Equipment equipment=null;
                    for(Equipment e: myProperties.getEquipments()){
                        if(e.getName().equals(command[2])){
                            equipment=e;
                        }
                    }
                    destroy(equipment);
                    break;
                case "List":
                    toString();
                    break;
            }
            actionCounter--;
        }
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
        TestInOutHandler.appendToTestOutput(name+ " died.");
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
    /**+
     * beállítja az actionCounter értékét
     * @param actionCount az új érték
     */
    public void setActionCounter(int actionCount){actionCounter=actionCount;}

    /**+
     * A megadott számmal csökkenti at actionCounter értékét
     * @param number csökkentés
     */
    public void decreaseActionCounter(int number){
        actionCounter-=number;
    }

    /**+
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

    /**+
     * automatikus behavior hozzáadása
     * @param beh
     */
    public void add(AutomaticBehavior beh){
        this.automaticBehaviors.add(0,beh);
    }

    /**+
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
     * +
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

    /**+
     * eltávolítja az automatikus viselkedést
     * @param beh
     */
    public void remove(AutomaticBehavior beh){
        automaticBehaviors.remove(beh);
    }

    /**+
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
}

