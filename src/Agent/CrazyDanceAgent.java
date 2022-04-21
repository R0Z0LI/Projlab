package Agent;

import Behaviors.CrazyMoveBehavior;
import Virologist.Virologist;
/**
 * Vitustáncot reprezentáló osztály.
 */
public class CrazyDanceAgent extends Agent {
    private static int id = 0;
    private CrazyMoveBehavior crazyMove;

    public CrazyDanceAgent(int timeleft) {
        super(timeleft);
        this.name = "cda" + id++;
        crazyMove = new CrazyMoveBehavior();
    }

    /**
     * Kitörli a megadott virológus verméből a crazyMove viselkedést, amit az aktuális ágens okoz.
     * @param v  virológus, akinek a verméből törölni kell a viselkedést.
     */
    @Override
    public void removeBehavior(Virologist v) {
        v.remove(crazyMove);
        System.out.println("-> RemoveBehFromStack(Virologist v)\n! Kitorli a megadott virologus vermebol a crazyMove viselkedest.\n\n");
    }

    /**
     * Hozzáadja a megadott virológus verméhez a crazyMove viselkedést, amit az aktuális ágens okoz.
     * @param v  virológus, akinek a verméhez hozzá kell adni a viselkedést.
     */
    @Override
    public void addBehavior(Virologist v) {
        crazyMove.setVirologist(v);
        v.add(crazyMove);
        System.out.println("-> AddBehToStack(Virologist v)\n! Hozzaadja a megadott virologus vermehez a crazyMove viselkedest.\n\n");
    }

    @Override
    public void step() {
        super.step();

        // we are gonna remove the agent from the virologist
        if (getTimeLeft() == 0) {
            removeBehavior(crazyMove.getVirologist());
        }
    }
}
