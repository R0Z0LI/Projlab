package Behaviors;

import Agent.Agent;
import TestSets.TestOutputWriter;
import Virologist.Virologist;

public class CapeDefenseBehavior extends DefenseBehavior {

    private static final double DEFENSE_CHANCE_PERCENT = 82.3;

    public CapeDefenseBehavior(Virologist v) {
        super(v);
        priority = 2;
    }

    /**
     * +
     * A védőköpeny 82.3% valószínűséggel kivédi a támadást.
     *
     * @param agent    ágens, amit a virológusra kell kenni
     * @param attacker a virológus, aki az ágenst keni
     */
    public void defend(Agent agent, Virologist attacker) {
        double chance = Math.random() * 100;
        if (chance > DEFENSE_CHANCE_PERCENT) {
            System.out.println(virologist.getName()+" used cape for defense. Defense failed.");
            TestOutputWriter.appendToTestOutput(virologist.getName()+" used cape for defense. Defense failed.\n");
            priority--;
            virologist.resortDefenseBehaviors();
            virologist.beInfected(agent, attacker);
        } else {
            System.out.println(virologist.getName()+" used cape for defense. Successful defense.");
            TestOutputWriter.appendToTestOutput(virologist.getName()+" used cape for defense. Successful defense.");
        }
    }
}
