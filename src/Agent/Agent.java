package Agent;

import Steppable.Steppable;
import Virologist.Virologist;

/**
 * Az ágenst reprezentáló osztály
 */
public abstract class Agent implements Steppable {

    protected String name;
    private int timeLeft;


    public Agent(int timeLeft) {
        this.timeLeft = timeLeft;
    }

    public Agent() {
    }

    public void setTimeLeft(int timeLeft) {
        this.timeLeft = timeLeft;
    }

    public int getTimeLeft() {
        return timeLeft;
    }

    /**
     * Lépteti az ágens visszalévő idejét.
     */
    public void step() {
        System.out.println("! Csokkent az ideje az agensnek\n");
        timeLeft--;
    }

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
}
