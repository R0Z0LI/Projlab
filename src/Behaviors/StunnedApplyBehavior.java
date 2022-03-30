package Behaviors;

import Agent.Agent;
import Virologist.Virologist;

public class StunnedApplyBehavior extends ApplyBehavior {
    public StunnedApplyBehavior(Virologist v) {
        super(v);
    }

    public StunnedApplyBehavior() {
        super();
    }

    /**
     * +
     * Lebénulva nem sikerül a kenés.
     *
     * @param agent    ágens, amit kenni kellene
     * @param affected virológus, akire kenni kellene
     */
    @Override
    public void apply(Agent agent, Virologist affected) {
        System.out.println("-> StunnedApplyBehavior.apply(Agent Agent, Virologist affected)");
        System.out.println("! Lebénulva nem sikerül a kenés.");
    }
}
