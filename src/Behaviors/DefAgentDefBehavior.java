package Behaviors;

import Agent.Agent;
import TestSets.TestOutputWriter;
import Virologist.Virologist;

public class DefAgentDefBehavior extends DefenseBehavior {
    public DefAgentDefBehavior(Virologist v) {
        super(v);
        priority = 4;
    }

    public DefAgentDefBehavior() {
        super();
        priority = 4;
    }

    /**
     * +
     * A védő ágens hatása, hogy a kenés nem sikerül.
     *
     * @param agent    ágens, ami nem fog hatni a virológusra
     * @param attacker a virológus, aki az ágenst kenni próbálja
     */
    @Override
    public void defend(Agent agent, Virologist attacker) {
        System.out.println(virologist.getName()+" used protecting agent for defense. Successful defense.");
        TestOutputWriter.appendToTestOutput(virologist.getName()+" used protecting agent for defense. Successful defense.\n");
    }
}
