package Behaviors;

import Agent.Agent;
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
        System.out.println("-> CapeDefBehavior.defend(Agent Agent, Virologist attacker)");
        double chance = Math.random() * 100;
        if (chance > DEFENSE_CHANCE_PERCENT) {
            System.out.println("! A kopeny védése nem jott ossze.");
            priority--;
            virologist.resortDefenseBehaviors();
            virologist.beInfected(agent, attacker);
        } else {
            System.out.println("! A kopeny most megvédett.\n");
        }
    }
}
