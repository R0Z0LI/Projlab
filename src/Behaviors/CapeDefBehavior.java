package Behaviors;

import Agent.Agent;
import Virologist.Virologist;

public class CapeDefBehavior extends DefenseBehavior{
        public CapeDefBehavior(Virologist v){
            super(v);
            priority=2;
        }

        /**+
         * A védőköpeny 82.3% valószínűséggel kivédi a támadást.
         * @param agent     ágens, amit a virológusra kell kenni
         * @param attacker  a virológus, aki az ágenst keni
         */
        public void defend(Agent agent, Virologist attacker) {
            System.out.println("-> CapeDefBehavior.defend(Agent Agent, Virologist attacker)");
            double chance= Math.random()*100;
            if(chance>82.3) {
                System.out.println("! A köpeny védése nem jött össze.");
                priority--;
                virologist.resortDefenseBehaviors();
                virologist.beInfected(agent, attacker);
            }
            else {
                System.out.println("! A köpeny most megvédett.");
                return;
            }
        }
}
