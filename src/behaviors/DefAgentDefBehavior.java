package behaviors;

import agent.Agent;
import virologist.Virologist;

public class DefAgentDefBehavior extends DefenseBehavior{
    public DefAgentDefBehavior(Virologist v){
        super(v);
        priority=4;
    }

    public DefAgentDefBehavior() {
        super();
    }
    /**+
     * A védő ágens hatása, hogy a kenés nem sikerül.
     * @param agent     ágens, ami nem fog hatni a virológusra
     * @param attacker  a virológus, aki az ágenst kenni próbálja
     */
    @Override
    public void defend(Agent agent, Virologist attacker) {
        return;
    }
}
