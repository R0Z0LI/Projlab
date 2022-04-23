package Behaviors;

import Agent.Agent;
import TestSets.TestInOutHandler;
import Virologist.Virologist;

public class ApplyBehavior {
    private Virologist virologist;

    public ApplyBehavior(Virologist v) {
        virologist = v;
    }

    public ApplyBehavior() {
    }

    public void setVirologist(Virologist v) {
        virologist = v;
    }

    public Virologist getVirologist() {
        return virologist;
    }

    /**
     * +
     * Végrehajtja egy ágens kenését. (Nem feltétlenül lesz sikeres, hiszen
     * az áldozat kivédheti.)
     *
     * @param agent    ágens, amit kenni kell
     * @param affected virológus, akire kenni kell
     */
    public void apply(Agent agent, Virologist affected) {
        if (affected == virologist) {
            agent.addBehavior(virologist);
        } else {
            System.out.println(virologist.getName()+" tried to apply "+agent.getName()+" on "+affected.getName());
            TestInOutHandler.appendToTestOutput(virologist.getName()+" tried to apply "+agent.getName()+" on "+affected.getName());
            affected.beInfected(agent, virologist);
        }

    }
}
