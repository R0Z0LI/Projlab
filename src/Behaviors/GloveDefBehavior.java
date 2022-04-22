package Behaviors;

import Agent.Agent;
import Equipments.Gloves;
import TestSets.TestOutputWriter;
import Virologist.Virologist;

public class GloveDefBehavior extends DefenseBehavior {
    private int usability;
    private Gloves gloves;

    public GloveDefBehavior(Virologist v, Gloves glove) {
        super(v);
        gloves=glove;
        priority = 4;
        usability = 3;
    }

    /**
     * A kesztyű a kenést kezdeményező (támadó) virológusra visszadobja az ágenst.
     *
     * @param agent    ágens, amit a virológusra kell kenni
     * @param attacker a virológus, aki az ágenst keni
     */
    @Override
    public void defend(Agent agent, Virologist attacker) {
        if (usability >0) {
            System.out.println(virologist.getName()+" used gloves for defense. Successful defense and application is returned.");
            TestOutputWriter.appendToTestOutput(virologist.getName()+" used gloves for defense. Successful defense and application is returned.");
            attacker.beInfected(agent, virologist);
        }
        usability--;
        if(usability<=0){
            gloves.removeBehavior(virologist);
        }

    }
}
