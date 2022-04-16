package Agent;

import Behaviors.DefAgentDefBehavior;
import Virologist.Virologist;

/**+
 * Védő ágenst reprezentáló osztály.
 */
public class ProtectionAgent extends Agent{

    private DefAgentDefBehavior defAgentDef;

    public ProtectionAgent(int timeleft) {
        super(timeleft);
        defAgentDef = new DefAgentDefBehavior();
    }


    /**+
     * Kitörli a megadott virológus verméből a defAgentDef viselkedést, amit az aktuális ágens okoz.
     * @param v  virológus, akinek a verméből törölni kell a viselkedést.
     */
    @Override
    public void removeBehavior(Virologist v) {
        defAgentDef.setVirologist(v);
        v.removeDefenseBeh(defAgentDef);
        System.out.println("-> RemoveBehFromStack(Virologist v)\n! Kitorli a megadott virologus vermebol a defAgentDef viselkedest.\n\n");
    }

    /**+
     * Hozzáadja a megadott virológus verméhez a defAgentDef viselkedést, amit az aktuális ágens okoz.
     * @param v  virológus, akinek a verméhez hozzá kell adni a viselkedést.
     */
    @Override
    public void addBehavior(Virologist v) {
        System.out.println("-> AddBehToStack(Virologist v)\n! Hozzaadja a megadott virologus vermehez a defAgentDef viselkedest.\n\n");
        defAgentDef.setVirologist(v);
        v.add(defAgentDef);

    }

    @Override
    public void step() {
        super.step();

        // we are gonna remove the agent from the virologist
        if (getTimeLeft() == 0) {
            removeBehavior(defAgentDef.getVirologist());
        }
    }

}
