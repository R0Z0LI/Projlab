package Behaviors;

import Agent.Agent;
import TestSets.TestInOutHandler;
import Virologist.Virologist;

public class DefenseBehavior {
    protected Virologist virologist;
    protected int priority = 1;

    public DefenseBehavior(Virologist v) {
        virologist = v;
    }

    public DefenseBehavior() {
    }

    public Virologist getVirologist() {
        return virologist;
    }

    /**
     * +
     * Megadja a védekező viselkedés prioritását, amely alapján a virológus
     * a felhasználásáról dönthet.
     *
     * @return prioritás
     */
    public int getPriority() {
        return priority;
    }

    public void setVirologist(Virologist v) {
        virologist = v;
    }

    /**
     * A virológus alapértelmezett védekezése. Nem véd, hanem az ágens hatni fog rá.
     *
     * @param agent    ágens, ami hatni fog a virológusra
     * @param attacker a virológus, aki az ágenst keni
     */
    public void defend(Agent agent, Virologist attacker) {
        System.out.println(virologist.getName()+" used nothing for defense. Defense failed.");
        TestInOutHandler.appendToTestOutput(virologist.getName()+" used nothing for defense. Defense failed.");
        agent.addBehavior(virologist);
    }
}
