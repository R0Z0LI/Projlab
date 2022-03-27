package behaviors;

import agent.Agent;
import virologist.Virologist;

public class DefenseBehavior {
    private Virologist virologist;
    protected int priority=1;

    public DefenseBehavior(Virologist v){
        virologist=v;
    }

    public DefenseBehavior() {

    }

    /**+
     * Megadja a védekező viselkedés prioritását, amely alapján a virológus
     * a felhasználásáról dönthet.
     * @return  prioritás
     */
    public int getPriority(){
        System.out.println("<- priority");
        return priority;
    }

    /**
     * A virológus alapértelmezett védekezése. Nem véd, hanem az ágens hatni fog rá.
     * @param agent     ágens, ami hatni fog a virológusra
     * @param attacker  a virológus, aki az ágenst keni
     */
    public void defend(Agent agent, Virologist attacker){
        System.out.println("->DefenseBehavior.defend(Agent agent, Virologist attacker)");
        System.out.println("! A kenés sikeres.\n");
        agent.AddBehToStack(virologist);
    }
}
