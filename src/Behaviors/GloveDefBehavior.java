package Behaviors;

import Agent.Agent;
import Virologist.Virologist;

public class GloveDefBehavior extends DefenseBehavior {
    private int usability;

    public GloveDefBehavior(Virologist v) {
        super(v);
        priority = 4;
        usability = 1;
    }

    /**
     * A kesztyű a kenést kezdeményező (támadó) virológusra visszadobja az ágenst.
     *
     * @param agent    ágens, amit a virológusra kell kenni
     * @param attacker a virológus, aki az ágenst keni
     */
    @Override
    public void defend(Agent agent, Virologist attacker) {
        if (usability == -1) {
            priority = 4;
            virologist.resortDefenseBehaviors();
            System.out.println("->GloveDefBehavior.defend()");
            System.out.println("!A kesztyu a kenést kezdeményezo (támado) virologusra visszadobja az ágenst.");
            usability = 1;
            attacker.beInfected(agent, virologist);
        }
        if (usability == 0) {
            System.out.println("->GloveDefBehavior.defend()");
            System.out.println("!A kesztyu elhasználodott, egy korig nem véd.");
            priority = 0;
            virologist.resortDefenseBehaviors();
            usability--;
            virologist.beInfected(agent, attacker);
        }
        if (usability == 1) {
            priority = 4;
            virologist.resortDefenseBehaviors();
            System.out.println("->GloveDefBehavior.defend()");
            System.out.println("!A kesztyu a kenést kezdeményezo (támado) virologusra visszadobja az ágenst.");
            usability--;
            attacker.beInfected(agent, virologist);
        }

    }
}
