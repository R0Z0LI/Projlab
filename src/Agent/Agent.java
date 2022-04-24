package Agent;

import Game.Steppable;
import Virologist.Virologist;

/**
 * Az ágenst reprezentáló osztály
 */
public abstract class Agent implements Steppable {
    protected String name;
    private int timeLeft;

    /**
     * Agent constructor
     * @param timeLeft remaining time
     */
    public Agent(int timeLeft) {
        this.timeLeft = timeLeft;
    }

    /**
     * Empty Agent constructor
     */
    public Agent() { }

    /**
     * Lépteti az ágens visszalévő idejét.
     */
    public void step() { timeLeft--; }

    /**
     * Kitörli a megadott virológus verméből azt a viselkedést, amit az aktuális ágens okozna.
     *
     * @param v virológus, akinek a verméből törölni kell a viselkedést.
     */
    public abstract void removeBehavior(Virologist v);

    /**
     * Hozzáadja a megadott virológus verméhez azt a viselkedést, amit az aktuális ágens okozna.
     *
     * @param v virológus, akinek a verméhez hozzá kell adni a viselkedést.
     */
    public abstract void addBehavior(Virologist v);

    // get name of the object
    public String getName() { return name; }

    // get remaining time for this agent
    public int getTimeLeft() { return timeLeft; }
}
