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
    public void removeBehFromStack(Virologist v) {
        defAgentDef.setVirologist(v);
        v.removeDefenseBeh(defAgentDef);
        System.out.println("-> RemoveBehFromStack(Virologist v)\n! Kitörli a megadott virológus verméből a defAgentDef viselkedést.\n\n");
    }

    /**+
     * Hozzáadja a megadott virológus verméhez a defAgentDef viselkedést, amit az aktuális ágens okoz.
     * @param v  virológus, akinek a verméhez hozzá kell adni a viselkedést.
     */
    @Override
    public void addBehToStack(Virologist v) {
        System.out.println("-> AddBehToStack(Virologist v)\n! Hozzáadja a megadott virológus verméhez a defAgentDef viselkedést.\n\n");
        defAgentDef.setVirologist(v);
        v.addDefenseBehavior(defAgentDef);

    }

    @Override
    public void Step() {
        super.Step();

        // we are gonna remove the agent from the virologist
        if (getTime_left() == 0) {
            removeBehFromStack(defAgentDef.getVirologist());
        }
    }

}
