package Agent;

import Behaviors.CrazyMoveBehavior;
import Virologist.Virologist;
/**+
 * Vitustáncot reprezentáló osztály.
 */
public class CrazyDanceAgent extends Agent {

    private CrazyMoveBehavior crazyMove;

    public CrazyDanceAgent(int timeleft) {
        super(timeleft);
        crazyMove = new CrazyMoveBehavior();
    }

    public CrazyDanceAgent() {

    }
    /**+
     * Kitörli a megadott virológus verméből a crazyMove viselkedést, amit az aktuális ágens okoz.
     * @param v  virológus, akinek a verméből törölni kell a viselkedést.
     */
    @Override
    public void RemoveBehFromStack(Virologist v) {
        v.removeCrazyMoveBeh(crazyMove);
        System.out.println("-> RemoveBehFromStack(Virologist v)\n! Kitörli a megadott virológus verméből a crazyMove viselkedést.\n\n");

    }

    /**+
     * Hozzáadja a megadott virológus verméhez a crazyMove viselkedést, amit az aktuális ágens okoz.
     * @param v  virológus, akinek a verméhez hozzá kell adni a viselkedést.
     */
    @Override
    public void AddBehToStack(Virologist v) {
        crazyMove.setVirologist(v);
        v.addMoveBehavior(crazyMove);
        System.out.println("-> AddBehToStack(Virologist v)\n! Hozzáadja a megadott virológus verméhez a crazyMove viselkedést.\n\n");
    }

    @Override
    public void Step() {
        super.Step();
    }
}
