package behaviors;

import virologist.Virologist;

public class DefenseBehavior {
    private Virologist virologist;
    private int priority=1;

    public DefenseBehavior(Virologist v){
        virologist=v;
    }

    /**+
     * Megadja a védekező viselkedés prioritását, amely alapján a virológus
     * a felhasználásáról dönthet.
     * @return  prioritás
     */
    public int GetPriority(){
        return priority;
    }

    /**
     * A virológus alapértelmezett védekezése. Nem véd, hanem az ágens hatni fog rá.
     * @param agent     ágens, ami hatni fog a virológusra
     * @param attacker  a virológus, aki az ágenst keni
     */
    public void Defend(Agent agent, Virologist attacker){
        agent.AddBehToStack(virologist);
    }
}
