package Agent;

import Steppable.Steppable;
import Virologist.Virologist;

/**
 * Az ágenst reprezentáló osztály
 */
public abstract class Agent implements Steppable {

    private int time_left;

    public Agent(int timeleft){
        time_left=timeleft;
    }

    public Agent() {}

    public void setTime_left(int time_left) {
        this.time_left = time_left;
    }

    public int getTime_left() {
        return time_left;
    }

    /**+
     * Lépteti az ágens visszalévő idejét.
     */
    public void Step(){
        time_left--;
    }

    /**+
     * Kitörli a megadott virológus verméből azt a viselkedést, amit az aktuális ágens okozna.
     * @param v  virológus, akinek a verméből törölni kell a viselkedést.
     */
    public abstract void removeBehFromStack(Virologist v);

    /**+
     * Hozzáadja a megadott virológus verméhez azt a viselkedést, amit az aktuális ágens okozna.
     * @param v  virológus, akinek a verméhez hozzá kell adni a viselkedést.
     */
    public abstract void addBehToStack(Virologist v);
}
