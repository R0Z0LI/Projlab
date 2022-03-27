package Behaviors;

import Agent.Agent;
import Virologist.Virologist;

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
        System.out.println("->DefAgentDefBehavior.defend(Agent Agent, Virologist attacker)");
        System.out.println("! A védő ágens megvéd a kenéstől.");
        return;
    }
}
