package behaviors;

import agent.Agent;
import virologist.Virologist;

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
            double chance= Math.random()*100;
            if(chance>82.3)
                super.defend(agent,attacker);
            else
                return;
        }
}
