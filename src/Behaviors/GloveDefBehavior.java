package Behaviors;

import Agent.Agent;
import Virologist.Virologist;

public class GloveDefBehavior extends DefenseBehavior{
    public GloveDefBehavior(Virologist v){
        super(v);
        priority=4;
    }
    /**
     * A kesztyű a kenést kezdeményező (támadó) virológusra visszadobja az ágenst.
     * @param agent     ágens, amit a virológusra kell kenni
     * @param attacker  a virológus, aki az ágenst keni
     */
    @Override
    public void defend(Agent agent, Virologist attacker) {
        System.out.println("->GloveDefBehavior.defend()");
        System.out.println("!A kesztyű a kenést kezdeményező (támadó) virológusra visszadobja az ágenst.");
        attacker.beInfected(agent, attacker);
    }
}
